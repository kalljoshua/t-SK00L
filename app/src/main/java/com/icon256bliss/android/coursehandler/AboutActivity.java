package com.icon256bliss.android.coursehandler;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ratel, website, licensesl, googleplusl, githubl, twitterl, appsl, bugsl, donatel;
    String version;
    TextView versionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        try {
            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), PackageManager.GET_ACTIVITIES);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        versionText = (TextView) findViewById(R.id.app_version);
        versionText.setText(version);

        versionText = (TextView) findViewById(R.id.app_version);
        versionText.setText(version);

        ratel = (LinearLayout) findViewById(R.id.rate);
        //changelogl = (LinearLayout) findViewById(R.id.changelog);
        licensesl = (LinearLayout) findViewById(R.id.licenses);
        googleplusl = (LinearLayout) findViewById(R.id.googleplus);
        githubl = (LinearLayout) findViewById(R.id.github);
        twitterl = (LinearLayout) findViewById(R.id.twitter);
        website = (LinearLayout) findViewById(R.id.website);
        bugsl = (LinearLayout) findViewById(R.id.bugs);
        donatel = (LinearLayout) findViewById(R.id.donate);

        ratel.setOnClickListener(this);
        //changelogl.setOnClickListener(this);
        licensesl.setOnClickListener(this);
        googleplusl.setOnClickListener(this);
        githubl.setOnClickListener(this);
        twitterl.setOnClickListener(this);
        website.setOnClickListener(this);
        bugsl.setOnClickListener(this);
        donatel.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rate:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName())));
                break;

            /*case R.id.changelog:
                new Changelog(this).show();
                break;
*/
            case R.id.licenses:

                break;

            case R.id.googleplus:
                Intent g = new Intent(Intent.ACTION_VIEW); g.setData(Uri.parse("https://plus.google.com/u/1/communities/103942298879567133883"));
                AboutActivity.this.startActivity(g);
                break;

            case R.id.github:
                Intent f = new Intent(Intent.ACTION_VIEW); f.setData(Uri.parse("https://www.facebook.com/icon256"));
                AboutActivity.this.startActivity(f);
                break;

            case R.id.twitter:
                Intent t = new Intent(Intent.ACTION_VIEW); t.setData(Uri.parse("https://twitter.com/icon256bliss"));
                AboutActivity.this.startActivity(t);
                break;

           case R.id.website:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://icon256bliss.com/")));
                break;

            case R.id.bugs:
                String[] addresses = { getString(R.string.mail_feedback_email) };
                String text = getString(R.string.mail_feedback_message);
                composeEmail(addresses, getString(R.string.mail_feedback_subject),text);
                break;

            case R.id.donate:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/your_paypal"));
                startActivity(browserIntent);
                break;

        }
    }

    public void composeEmail(String[] addresses, String subject ,String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //Start a new activity for sending a feedback email
    /*private void sendFeedback() {
        final Intent _Intent = new Intent(android.content.Intent.ACTION_SENDTO);
        _Intent.setType("text/html");
        _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
        _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
        _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
        startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
    }*/

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




}
