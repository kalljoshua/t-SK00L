package com.icon256bliss.android.coursehandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.adapters.CollegeListAdapter;
import com.icon256bliss.android.coursehandler.appModels.College;
import com.icon256bliss.android.coursehandler.appModels.University;
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
 * lead to a {@link CollegeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CollegeListActivity extends AppCompatActivity {

    public static final String TAG = CollegeListActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private List<College> colleges;

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        Intent i = getIntent();

        int uniId = i.getIntExtra("INDEX",0);
        String uniName = i.getStringExtra("UNI_NAME");

        Log.d(TAG, "University id: " + uniId);
        Log.d(TAG, "University name: " + uniName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(uniName);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        colleges = new ArrayList<>();

        getColleges(uniId);



        if (findViewById(R.id.college_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Log.d(TAG, "Call to the adapter: " + colleges.get(0).name);
        recyclerView.setAdapter(new CollegeListAdapter(colleges));
    }



    private void getColleges(final int id) {
        // Tag used to cancel the request
        String tag_string_req = "req_colleges";

        pDialog.setMessage("Loading colleges ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_COLLEGES, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Colleges Response: " + response.toString());
                hideDialog();

                try {

                   JSONObject jObj = new JSONObject(response);

                     JSONArray jsonArray = jObj.getJSONArray("colleges");

                    int error = jObj.getInt("error");
                    if (error == 1) {
                        Log.d(TAG, "Colleges: " + jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Log.d(TAG, "Writing to memo: " + jsonArray.toString());
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");

                            College college = new College(id, name);

                            colleges.add(college);

                            View recyclerView = findViewById(R.id.college_list);
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
                Log.e(TAG, "Error getting colleges: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }){

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
        if(colleges.size() > 0){
            Log.d(TAG, "College in array list: " + colleges.get(0).name);
            colleges.clear();
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
