package com.icon256bliss.android.coursehandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.adapters.CustomExpandableListAdapter;
import com.icon256bliss.android.coursehandler.adapters.PossibleChoicesListAdapter;
import com.icon256bliss.android.coursehandler.appModels.College;
import com.icon256bliss.android.coursehandler.appModels.ExpandableListDataPump;
import com.icon256bliss.android.coursehandler.appModels.PossibleChoice;
import com.icon256bliss.android.coursehandler.appModels.ProcessData;
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
 * lead to a {@link ProcessedChoicesDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ProcessedChoicesListActivity extends AppCompatActivity {

    private static final String TAG = ProcessedChoicesListActivity.class.getSimpleName();

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<PossibleChoice>> expandableListDetail;

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ProgressDialog pDialog;
    private List<PossibleChoice> possibleChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processedchoices_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        possibleChoices = new ArrayList<>();

        getChoices();


        if (findViewById(R.id.processedchoices_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new PossibleChoicesListAdapter(possibleChoices));
    }


    private void getChoices() {
        // Tag used to cancel the request
        String tag_string_req = "req_courses";

        pDialog.setMessage("Loading courses ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_CHOICES, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Choices Response: " + response);
                hideDialog();

                try {

                    JSONObject jObj = new JSONObject(response);

                    JSONArray jsonArray = jObj.getJSONArray("courses");

                    int error = jObj.getInt("error");
                    List<PossibleChoice> mak = new ArrayList<>();
                    List<PossibleChoice> ky = new ArrayList<>();
                    List<PossibleChoice> mb = new ArrayList<>();
                    List<PossibleChoice> gu = new ArrayList<>();
                    List<PossibleChoice> bu = new ArrayList<>();

                    if (error == 1) {
                        Log.d(TAG, "Courses: " + jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String uname = jsonObject.getString("uname");
                            String cname = jsonObject.getString("cname");

                            if (uname.trim().equalsIgnoreCase("Makerere University")) {
                                System.out.println("Data: " + uname + ":" + cname);
                                mak.add(new PossibleChoice(uname.trim(), cname.trim()));
                            } else if (uname.trim().equalsIgnoreCase("Kyambogo University")) {
                                System.out.println("Data: " + uname + ":" + cname);
                                ky.add(new PossibleChoice(uname.trim(), cname.trim()));
                            } else if (uname.trim().equalsIgnoreCase("Mbarara University")) {
                                System.out.println("Data: " + uname + ":" + cname);
                                mb.add(new PossibleChoice(uname.trim(), cname.trim()));
                            } else if (uname.trim().equalsIgnoreCase("Gulu University")) {
                                System.out.println("Data: " + uname + ":" + cname);
                                gu.add(new PossibleChoice(uname.trim(), cname.trim()));
                            } else if (uname.trim().equalsIgnoreCase("Busitema University")) {
                                System.out.println("Data: " + uname + ":" + cname);
                                bu.add(new PossibleChoice(uname.trim(), cname.trim()));
                            }

                            PossibleChoice possibleChoice = new PossibleChoice(uname.trim(), cname.trim());

                            possibleChoices.add(possibleChoice);

                            /*View recyclerView = findViewById(R.id.processedchoices_list);
                            assert recyclerView != null;
                            setupRecyclerView((RecyclerView) recyclerView);*/

                        }


                        for (int i = 0; i < mak.size(); i++) {
                            Log.e(TAG, "List courses: " + mak.get(i).toString());
                        }

                        ExpandableListDataPump.setMakerere((ArrayList<PossibleChoice>) mak);
                        ExpandableListDataPump.setKyambogo((ArrayList<PossibleChoice>) ky);
                        ExpandableListDataPump.setMbarara((ArrayList<PossibleChoice>) mb);
                        ExpandableListDataPump.setGulu((ArrayList<PossibleChoice>) gu);
                        ExpandableListDataPump.setBusitema((ArrayList<PossibleChoice>) bu);

                        for (int i = 0; i < ExpandableListDataPump.getMakerere().size(); i++) {
                            Log.e(TAG, "Makerere expandable list details : " + ExpandableListDataPump.getMakerere().get(i).courseName);
                        }

                        for (int i = 0; i < ExpandableListDataPump.getKyambogo().size(); i++) {
                            Log.e(TAG, "Kyambogo expandable list details : " + ExpandableListDataPump.getKyambogo().get(i).courseName);
                        }


                        Log.e(TAG, "THE DATA : " + ExpandableListDataPump.getData());

                        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
                        expandableListDetail = ExpandableListDataPump.getData();
                        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                        expandableListAdapter = new CustomExpandableListAdapter
                                (ProcessedChoicesListActivity.this, expandableListTitle, expandableListDetail);
                        expandableListView.setAdapter(expandableListAdapter);
                        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                            @Override
                            public void onGroupExpand(int groupPosition) {
                                Toast.makeText(getApplicationContext(),
                                        expandableListTitle.get(groupPosition) + " List Expanded.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                            @Override
                            public void onGroupCollapse(int groupPosition) {
                                Toast.makeText(getApplicationContext(),
                                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        });

                        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                            @Override
                            public boolean onChildClick(ExpandableListView parent, View v,
                                                        int groupPosition, int childPosition, long id) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                        ProcessedChoicesListActivity.this);

                                // set title
                                alertDialogBuilder.setTitle( expandableListTitle.get(groupPosition));

                                // set dialog message
                                alertDialogBuilder
                                        .setMessage(" " +possibleChoices.get(groupPosition))
                                        .setCancelable(false)
                                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                // if this button is clicked, close
                                                // current activity
                                                ProcessedChoicesListActivity.this.finish();
                                            }
                                        })
                                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                // if this button is clicked, just close
                                                // the dialog box and do nothing
                                                dialog.cancel();
                                            }
                                        });

                                // create alert dialog
                                AlertDialog alertDialog = alertDialogBuilder.create();

                                // show it
                                alertDialog.show();
                                return false;
                            }
                        });


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

                // Posting parameters to process result url
                ProcessData.OlevelResults oLevelResultHash =
                        new ProcessData.OlevelResults(ProcessedChoicesListActivity.this);

                ProcessData.AlevelResults aLevelResultHash =
                        new ProcessData.AlevelResults(ProcessedChoicesListActivity.this);

                ProcessData.Prerequisites prerequisites =
                        new ProcessData.Prerequisites(ProcessedChoicesListActivity.this);


                Map<String, String> params = new HashMap<>();
                params.put("olevel", oLevelResultHash.getOJString().toString());
                params.put("alevel", aLevelResultHash.getAJString().toString());
                params.put("pre", prerequisites.getPJString().toString());

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
