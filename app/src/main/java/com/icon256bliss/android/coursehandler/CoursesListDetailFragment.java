package com.icon256bliss.android.coursehandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.apputils.AppConfig;
import com.icon256bliss.android.coursehandler.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A fragment representing a single CoursesList detail screen.
 * This fragment is either contained in a {@link CoursesListListActivity}
 * in two-pane mode (on tablets) or a {@link CoursesListDetailActivity}
 * on handsets.
 */
public class CoursesListDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private static final String TAG = CoursesListDetailFragment.class.getSimpleName();

    private ProgressDialog pDialog;

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    private TextView mCourseName;
    private TextView mCourseDescription;
    private TextView mCourseEssentials;
    private TextView mCourseRelevants;
    private TextView mCourseOpportunities;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CoursesListDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Progress dialog
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            getCourseDetails(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.courseslist_detail, container, false);


            mCourseName = ((TextView) rootView.findViewById(R.id.course_name));
            mCourseDescription = ((TextView) rootView.findViewById(R.id.description));
            mCourseEssentials = ((TextView) rootView.findViewById(R.id.essentials));
            mCourseRelevants = ((TextView) rootView.findViewById(R.id.relevants));
            mCourseOpportunities = ((TextView) rootView.findViewById(R.id.opps));

        return rootView;
    }

    private void getCourseDetails(final int id) {
        // Tag used to cancel the request
        String tag_string_req = "req_colleges";

        pDialog.setMessage("Loading colleges ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_COURSE_DETAILS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Course detail response: " + response);
                hideDialog();

                try {

                    JSONObject jObj = new JSONObject(response);

                    JSONArray jsonArray = jObj.getJSONArray("course");

                    int error = jObj.getInt("error");
                    if (error == 1) {
                        Log.d(TAG, "Course: " + jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            /*int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");*/

                            mCourseName.setText(jsonObject.getString("name").trim());
                            mCourseDescription.setText(jsonObject.getString("details").trim());
                            mCourseEssentials.setText(jsonObject.getString("essentials").trim());
                            mCourseRelevants.setText(jsonObject.getString("relevants").trim());


                            String Str = jsonObject.getString("opportunity");
                            StringBuilder st = new StringBuilder();
                            for (String retval: Str.trim().split(",")){
                                st.append("* "+cap(retval.trim())+"\n\n");
                                System.out.println(retval.trim());
                            }

                            mCourseOpportunities.setText(st);




                        }
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getActivity(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error getting course details: " + error.getMessage());
                Toast.makeText(getActivity(),
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

    private String cap(String str){
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }
}
