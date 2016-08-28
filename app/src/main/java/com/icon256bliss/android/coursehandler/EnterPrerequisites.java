package com.icon256bliss.android.coursehandler;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.icon256bliss.android.coursehandler.appModels.ProcessData;

import java.util.HashMap;

public class EnterPrerequisites extends AppCompatActivity {

    private static final String TAG = EnterPrerequisites.class.getSimpleName();

    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    String radio,radio1,radio2;
    String rad1 = "0";
    String rad2 = "0";
    String rad3 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processresults);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);

        // add back arrow to toolbar
        /*if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                int selectedid = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = (RadioButton) findViewById(selectedid);

                int selectedd = radioGroup3.getCheckedRadioButtonId();
                radioButton3 = (RadioButton) findViewById(selectedd);

                if(radioButton.isChecked()){
                    radio =  radioButton.getText().toString().trim();
                    if (radio.equals("YES")&& radio.length() != 0)
                        rad1 = "1";
                }else{
                    radioButton.setError("Please make Selection");
                }

                if(radioButton2.isChecked()){
                    radio1 =  radioButton2.getText().toString().trim();
                    if (radio1.equals("YES") && radio1.length() != 0)
                        rad2 = "1";
                }else{
                    radioButton2.setError("Please make Selection");
                }

                if(radioButton3.isChecked()){
                    radio2 =  radioButton3.getText().toString().trim();
                    if (radio2.equals("YES")&& radio2.length() != 0)
                        rad3 = "1";
                }else{
                    radioButton3.setError("Please make Selection");
                }


                HashMap<String, String> pre = new HashMap<>();

                pre.put("games", rad1);
                pre.put("gender", rad2);
                pre.put("selection", rad3);



                ProcessData.Prerequisites prerequisites =
                        new ProcessData.Prerequisites(EnterPrerequisites.this,pre);

                Log.d(TAG, prerequisites.getEntries().toString());



                    Intent i = new Intent(EnterPrerequisites.this, OlevelSelector.class);
                    startActivity(i);

            }
        });


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
