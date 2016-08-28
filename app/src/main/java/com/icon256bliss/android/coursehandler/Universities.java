package com.icon256bliss.android.coursehandler;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.adapters.UniversityGridAdapter;
import com.icon256bliss.android.coursehandler.appModels.University;
import com.icon256bliss.android.coursehandler.apputils.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Universities extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = Universities.class.getSimpleName();
    private ProgressDialog pDialog;
    private List<University> universities = new ArrayList<>();

    private SQLiteHandler db;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //checkConnection();
        getUniversites();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        TextView txtName = (TextView) findViewById(R.id.name);
        TextView txtEmail = (TextView) findViewById(R.id.email);
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_register).setVisible(true);
            //logoutUser();
        } else {
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_register).setVisible(false);
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);



        /*recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(this,"item clicked "+position,Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(Universities.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //String title = getString(R.string.app_name);
        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_results) {
            if (!session.isLoggedIn()) {
                Intent d = new Intent(Universities.this, LoginActivity.class);
                startActivity(d);
            } else {
                Intent d = new Intent(Universities.this, EnterPrerequisites.class);
                startActivity(d);
                //Toast.makeText(getApplicationContext(), "Gallery action is selected!", Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.nav_score) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    Universities.this);

            // set title
            alertDialogBuilder.setTitle("My Results");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Coming Soon....... ")
                    .setCancelable(false)

                    .setNegativeButton("Close",new DialogInterface.OnClickListener() {
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
            //Toast.makeText(getApplicationContext(), "Slideshow action is selected!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_register) {
            if (!session.isLoggedIn()) {
                Intent d = new Intent(Universities.this, LoginActivity.class);
                startActivity(d);
            }

        } else if (id == R.id.nav_logout) {
            if (session.isLoggedIn()) {
                logoutUser();
            }

        } else if (id == R.id.nav_share) {
            String message = "http://icon256bliss.com/";
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));
            //Toast.makeText(getApplicationContext(), "Share action is selected!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_help) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    Universities.this);

            // set title
            alertDialogBuilder.setTitle("App Help");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Coming Soon....... ")
                    .setCancelable(false)

                    .setNegativeButton("Close",new DialogInterface.OnClickListener() {
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
            /*Intent d = new Intent(Universities.this, HelpActivity.class);
            startActivity(d);*/
            //Toast.makeText(getApplicationContext(), "help action is selected!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {
            Intent d = new Intent(Universities.this, AboutActivity.class);
            startActivity(d);
            //Toast.makeText(getApplicationContext(), "help action is selected!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_exit) {
            Universities.this.finish();
            System.exit(0);
            //Toast.makeText(getApplicationContext(), "Send action is selected!", Toast.LENGTH_SHORT).show();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new UniversityGridAdapter(this,universities));
    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     */
    private void getUniversites() {
        // Tag used to cancel the request
        String tag_string_req = "req_universities";

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(true);

        pDialog.setMessage("Loading universities ...");
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET, AppConfig.URL_UNIVERSITIES, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                if(response !=null){
                    Log.d(TAG, "Done loading universities ");
                    Log.d(TAG, "Universities Response: " + response);
                   pDialog.dismiss();
                }


                try {

                    JSONObject jObj = new JSONObject(response);

                    JSONArray jsonArray = jObj.getJSONArray("universities");

                    int error = jObj.getInt("error");
                    if (error == 1) {
                        Log.d(TAG, "Universities: " + jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String imageUrl = jsonObject.getString("image");

                            University university = new University(id, name, imageUrl);

                            universities.add(university);

                            View recyclerView = findViewById(R.id.recycler_view);
                            setupRecyclerView((RecyclerView) recyclerView);
                        }
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        if(errorMsg == null){
                            Toast.makeText(getApplicationContext(),
                                    "Error loading", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    errorMsg, Toast.LENGTH_LONG).show();
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error getting universities: " + error.getMessage());
                if(error.getMessage() == null){
                    Toast.makeText(getApplicationContext(),
                            "Error loading", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_LONG).show();
                }
                pDialog.dismiss();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
       // MyApplication.getInstance().setConnectivityListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(universities.size() > 0){
            Log.d(TAG, "University in array list: " + universities.get(0).imageUrl);
        }

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    /*public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
*/
    /**
     * Converting dp to pixel
     */
   /* private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }*/



}
