package com.icon256bliss.android.coursehandler;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.icon256bliss.android.coursehandler.appModels.ProcessData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnterOlevelResults extends AppCompatActivity {

    private static final String TAG = EnterOlevelResults.class.getSimpleName();
    ArrayList<EditText> mCheck = new ArrayList<>();
    List<EditText> alleds = new ArrayList<>();
    ArrayList<String> gotBread;
    EditText math, physics, chemistry, biology, geography, english, history;
    String x, mathe, physicse, chemistrye, biologye, geographye, englishe,
            historye;
    double total = 0;//total o-level grade

    HashMap<String,String> oLevelResults = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_olevel_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        LinearLayout mLayout = (LinearLayout) findViewById(R.id.layout);

        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getStringArrayList("subjects");
        for (int i = 0; i < gotBread.size(); i++) {
            x = x + "\n" + gotBread.get(i);

            TextView textView = new TextView(EnterOlevelResults.this);
            textView.setText(gotBread.get(i));
            textView.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(12, 12, 12, 12); // llp.setMargins(left, top, right, bottom);
            textView.setLayoutParams(llp);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            mLayout.addView(textView);


            EditText mEdit = new EditText(EnterOlevelResults.this);


            alleds.add(mEdit);
            Log.e(TAG,"Foreign et: "+ gotBread.get(i));
            mEdit.setTag(gotBread.get(i).toLowerCase());
            mEdit.setHint("Enter Grades (D,C,P,F)");
            mEdit.setId(i);
            mEdit.setPadding(20, 0, 0, 10);
            mEdit.setBackgroundColor(Color.WHITE);
            mEdit.setTextColor(Color.BLACK);
            mEdit.setEms(10);
            mEdit.setHeight(getResources().getDimensionPixelSize(R.dimen.dyno_et));
            //mEdit.setInputType(0x00001001);
            // Set the background resource of EditText widget
            mEdit.setBackgroundResource(R.drawable.edittext_bg);
            // Create a border programmatically
            ShapeDrawable shape = new ShapeDrawable(new RectShape());
            shape.getPaint().setColor(Color.RED);
            shape.getPaint().setStyle(Paint.Style.STROKE);
            shape.getPaint().setStrokeWidth(3);

            mEdit.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,
                    Toolbar.LayoutParams.WRAP_CONTENT));
            //mEdit.setFocusableInTouchMode(true);
            //mEdit.setFocusable(true);
            //mEdit.requestFocus();
            mLayout.addView(mEdit);
            mCheck.add(mEdit);
        }

        TextView textView = new TextView(EnterOlevelResults.this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        textView.setPadding(17, 0, 0, 0);
        textView.setTextSize(20);
        mLayout.addView(textView);


        gotBasket.getStringArrayList("subjects").clear();

        math = (EditText) findViewById(R.id.editmath);
        math.setTag("math");
        // Set the background resource of EditText widget
        math.setBackgroundResource(R.drawable.edittext_bg);
        math.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    mathe = math.getText().toString().toUpperCase();
                    if ((mathe.equals("D") || mathe.equals("C") || mathe.equals("P") || mathe.equals("F") && math.getText().length() != 0)) {
                        math.setError(null);
                    }else{
                        math.setError("Invalid Grades");
                    }
                }
            }
        });

        physics = (EditText) findViewById(R.id.editphysics);
        physics.setTag("physics");
        // Set the background resource of EditText widget
        physics.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        physics.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    physicse = physics.getText().toString().toUpperCase();
                    if ((physicse.equals("D") || physicse.equals("C") || physicse.equals("P") || physicse.equals("F") && physics.getText().length() != 0)) {
                        physics.setError(null);
                    }else{
                        physics.setError("Invalid Grades");
                    }
                }
            }
        });

        biology = (EditText) findViewById(R.id.editbiology);
        biology.setTag("biology");
        // Set the background resource of EditText widget
        biology.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        biology.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    biologye = biology.getText().toString().toUpperCase();
                    if ((biologye.equals("D") || biologye.equals("C") || biologye.equals("P") || biologye.equals("F") && biology.getText().length() != 0)) {
                        biology.setError(null);
                    }else{
                        biology.setError("Invalid Grades");
                    }
                }
            }
        });

        chemistry = (EditText) findViewById(R.id.editchemistry);
        chemistry.setTag("chemistry");
        // Set the background resource of EditText widget
        chemistry.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        chemistry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    chemistrye = chemistry.getText().toString().toUpperCase();
                    if ((chemistrye.equals("D") || chemistrye.equals("C") || chemistrye.equals("P") || chemistrye.equals("F") && chemistry.getText().length() != 0)) {
                        chemistry.setError(null);
                    }else{
                        chemistry.setError("Invalid Grades");
                    }
                }
            }
        });

        geography = (EditText) findViewById(R.id.editgeography);
        geography.setTag("geography");
        // Set the background resource of EditText widget
        geography.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        geography.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    geographye = geography.getText().toString().toUpperCase();
                    if ((geographye.equals("D") || geographye.equals("C") || geographye.equals("P") || geographye.equals("F") && geography.getText().length() != 0)) {
                        geography.setError(null);
                    }else{
                        geography.setError("Invalid Grades");
                    }
                }
            }
        });

        history = (EditText) findViewById(R.id.edithistory);
        history.setTag("history");
        // Set the background resource of EditText widget
        history.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        history.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    historye = history.getText().toString().toUpperCase();
                    if ((historye.equals("D") || historye.equals("C") || historye.equals("P") || historye.equals("F") && history.getText().length() != 0)) {
                        history.setError(null);
                    }else{
                        history.setError("Invalid Grades");
                    }
                }
            }
        });

        english = (EditText) findViewById(R.id.editenglish);
        english.setTag("english");
        // Set the background resource of EditText widget
        english.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        english.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    englishe = english.getText().toString().toUpperCase();
                    if ((englishe.equals("D") || englishe.equals("C") || englishe.equals("P") || englishe.equals("F") && english.getText().length() != 0)) {
                        english.setError(null);
                    }else{
                        english.setError("Invalid Grades");
                    }
                }
            }
        });




        // Create a border programmatically
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.RED);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = 0;//tracking empty errors
                int y = 0;//tracking invalid grade errors
                mathe = math.getText().toString().toUpperCase();
                if (math.getText().length() == 0) {
                    math.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((mathe.equals("D") || mathe.equals("C") || mathe.equals("P") || mathe.equals("F") && math.getText().length() != 0)) {

                        oLevelResults.put(math.getTag().toString(),mathe);
                    } else {
                        math.setError("Invalid Grades");
                        y++;
                    }
                }

                physicse = physics.getText().toString().toUpperCase();
                if (physics.getText().length() == 0) {
                    physics.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((physicse.equals("D") || physicse.equals("C") || physicse.equals("P") || physicse.equals("F") && physics.getText().length() != 0)) {

                        oLevelResults.put(physics.getTag().toString(),physicse);
                    } else {
                        physics.setError("Invalid Grades");
                        y++;
                    }
                }

                biologye = biology.getText().toString().toUpperCase();
                if (biology.getText().length() == 0) {
                    biology.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((biologye.equals("D") || biologye.equals("C") || biologye.equals("P") || biologye.equals("F") && biology.getText().length() != 0)) {

                        oLevelResults.put(biology.getTag().toString(),biologye);
                    } else {
                        biology.setError("Invalid Grades");
                        y++;
                    }
                }

                chemistrye = chemistry.getText().toString().toUpperCase();
                if (chemistry.getText().length() == 0) {
                    chemistry.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((chemistrye.equals("D") || chemistrye.equals("C") || chemistrye.equals("P") || chemistrye.equals("F") && chemistry.getText().length() != 0)) {

                        oLevelResults.put(chemistry.getTag().toString(),chemistrye);
                    } else {
                        chemistry.setError("Invalid Grades");
                        y++;
                    }
                }

                geographye = geography.getText().toString().toUpperCase();
                if (geography.getText().length() == 0) {
                    geography.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((geographye.equals("D") || geographye.equals("C") || geographye.equals("P") || geographye.equals("F") && geography.getText().length() != 0)) {

                        oLevelResults.put(geography.getTag().toString(),geographye);
                    } else {
                        geography.setError("Invalid Grades");
                        y++;
                    }
                }

                historye = history.getText().toString().toUpperCase();
                if (history.getText().length() == 0) {
                    history.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((historye.equals("D") || historye.equals("C") || historye.equals("P") || historye.equals("F") && history.getText().length() != 0)) {

                        oLevelResults.put(history.getTag().toString(),historye);
                    } else {
                        history.setError("Invalid Grades");
                        y++;
                    }
                }
                englishe = english.getText().toString().toUpperCase();
                if (english.getText().length() == 0) {
                    english.setError("Field cannot be left blank.");
                    x++;
                } else {
                    if ((englishe.equals("D") || englishe.equals("C") || englishe.equals("P") || englishe.equals("F") && english.getText().length() != 0)) {

                        oLevelResults.put(english.getTag().toString(),englishe);
                    } else {
                        english.setError("Invalid Grades");
                        y++;
                    }
                }

                String[] getinput = new String[alleds.size()];
                for (int i = 0; i < alleds.size(); i++) {



                    if (alleds.get(i).getText().length() == 0) {
                        alleds.get(i).setError("Field cannot be left blank.");
                        x++;
                    } else {
                        getinput[i] = alleds.get(i).getText().toString().toUpperCase();
                        if (getinput[i].equals("D")
                                || getinput[i].equals("C")
                                || getinput[i].equals("P")
                                || getinput[i].equals("F")) {

                            Log.d(TAG,"EDIT TEXT TAG: " +alleds.get(i).getTag()+" "+alleds.get(i).getText());

                            oLevelResults.put(alleds.get(i).getTag().toString(),alleds.get(i).getText().toString().toUpperCase());


                        } else {
                            alleds.get(i).setError("Invalid Grades");
                            y++;
                        }
                    }

                }

                if (oLevelResults.isEmpty() || oLevelResults.size()<8) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            EnterOlevelResults.this);

                    // set title
                    alertDialogBuilder.setTitle("Empty Fields");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Fields Can not be left blank! ")
                            .setCancelable(false)

                            .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }else{

                    Log.e(TAG, "Olevel results :" + oLevelResults.toString() + " ... " + oLevelResults.size());

                    ProcessData.OlevelResults oLevelResultHash =
                            new ProcessData.OlevelResults(EnterOlevelResults.this, oLevelResults);

                    Log.d(TAG, "Ole: " + oLevelResultHash.getEntries().toString());

                    ProcessData.Prerequisites prerequisites =
                            new ProcessData.Prerequisites(EnterOlevelResults.this);

                    Log.d(TAG, "Pre : " + prerequisites.getEntries().toString());

                    Intent i = new Intent(EnterOlevelResults.this, AlevelSelector.class);
                    startActivity(i);

                }


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
