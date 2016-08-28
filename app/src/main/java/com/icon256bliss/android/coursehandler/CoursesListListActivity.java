package com.icon256bliss.android.coursehandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.adapters.CourseListAdapter;
import com.icon256bliss.android.coursehandler.appModels.Course;
import com.icon256bliss.android.coursehandler.apputils.AppConfig;
import com.icon256bliss.android.coursehandler.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CoursesListDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CoursesListListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public static final String TAG = CollegeListActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private List<Course> courses;
    private boolean mTwoPane;
    int colId;
    String colName;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseslist_list);

        Log.e("Check the create", "Still running");

        i = getIntent();

        colId = i.getIntExtra("INDEX", 0);

        colName = i.getStringExtra("COL_NAME");

        Log.d(TAG, "College id: " + colId);
        Log.d(TAG, "College name: " + colName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(colName);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        courses = new ArrayList<>();


        getCourses(colId);


        if (findViewById(R.id.courseslist_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new CourseListAdapter(courses,i));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.e("CID", String.valueOf(colId));
        savedInstanceState.putInt("INDEX", colId);
        Log.e("CIDd", String.valueOf(savedInstanceState.getInt("INDEX")));
        savedInstanceState.putString("COL_NAME", colName);
    }

    @Override
    protected void onStop() {
        super.onStop();

        getIntent().putExtra("INDEX", colId);
        getIntent().putExtra("COL_NAME", colName);
    }

    private void getCourses(final int id) {
        // Tag used to cancel the request
        String tag_string_req = "req_courses";

        pDialog.setMessage("Loading courses ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_COURSES, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Courses Response: " + response.toString());
                hideDialog();

                try {

                    JSONObject jObj = new JSONObject(response);

                    JSONArray jsonArray = jObj.getJSONArray("courses");

                    int error = jObj.getInt("error");
                    if (error == 1) {
                        Log.d(TAG, "courses: " + jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Log.d(TAG, "Writing to memo: " + jsonArray.toString());
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String tuition = jsonObject.getString("tuition");
                            String duration = jsonObject.getString("duration");
                            String programme = jsonObject.getString("programme");
                            String cpPujab = jsonObject.getString("cp_pujab");
                            String cpPrivate = jsonObject.getString("cp_private");
                            String details = jsonObject.getString("details");
                            String availability = jsonObject.getString("availability");

                            Course course = new Course(id, name, tuition, duration, programme, cpPujab, cpPrivate, details, availability);

                            courses.add(course);

                            View recyclerView = findViewById(R.id.courseslist_list);
                            assert recyclerView != null;
                            setupRecyclerView((RecyclerView) recyclerView);

                        }
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error getting courses: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(id));

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (courses.size() > 0) {
            Log.d(TAG, "Courses in array list: " + courses.get(0).name);
            courses.clear();
        /*universities = null;*/
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
