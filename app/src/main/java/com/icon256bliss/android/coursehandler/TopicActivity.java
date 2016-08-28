package com.icon256bliss.android.coursehandler;

/**
 * Created by Kall on 8/1/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * This activity displays some help information on a topic.
 * It displays some text and provides a way to get back to the home activity.
 * The text to be displayed is determined by the text id argument passed to the activity.
 *
 */

public class TopicActivity extends AppCompatActivity
{

    int mTextResourceId = 0;

    /**
     * onCreate
     *
     * @param savedInstanceState Bundle
     */

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.topic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Read the arguments from the Intent object.
        Intent in = getIntent ();
        mTextResourceId = in.getIntExtra (HelpActivity.ARG_TEXT_ID, 0);
        if (mTextResourceId <= 0) mTextResourceId = R.string.no_help_available;

        TextView textView = (TextView) findViewById (R.id.topic_text);
        textView.setMovementMethod (LinkMovementMethod.getInstance());
        textView.setText (Html.fromHtml (getString (mTextResourceId)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

} // end class

