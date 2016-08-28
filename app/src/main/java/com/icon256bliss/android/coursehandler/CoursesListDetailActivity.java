package com.icon256bliss.android.coursehandler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icon256bliss.android.coursehandler.appModels.College;
import com.icon256bliss.android.coursehandler.apputils.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * An activity representing a single CoursesList detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link CoursesListListActivity}.
 */
public class CoursesListDetailActivity extends AppCompatActivity {

    private static final String TAG = CoursesListDetailActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    int cid;

    int colId;
    String colName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseslist_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        cid = getIntent().getIntExtra(CoursesListDetailFragment.ARG_ITEM_ID,0);

        Log.d("ITEM ID",""+cid);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(CoursesListDetailFragment.ARG_ITEM_ID,
                    String.valueOf(getIntent().getIntExtra(CoursesListDetailFragment.ARG_ITEM_ID,0)));
            CoursesListDetailFragment fragment = new CoursesListDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.courseslist_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            Intent i = new Intent(this, CoursesListListActivity.class);
            i.putExtra("INDEX",getIntent().getIntExtra("INDEX", 0));
            i.putExtra("COL_NAME",getIntent().getStringExtra("COL_NAME"));
            NavUtils.navigateUpTo(this, i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
