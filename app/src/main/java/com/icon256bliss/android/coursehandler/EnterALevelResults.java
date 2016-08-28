package com.icon256bliss.android.coursehandler;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.icon256bliss.android.coursehandler.appModels.ProcessData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EnterALevelResults extends AppCompatActivity {

    private static final String TAG = EnterALevelResults.class.getSimpleName();

    ArrayList<EditText> yCheck = new ArrayList<>();
    List<EditText> alleds = new ArrayList<>();
    ArrayList<String> gotBreadalv;
    EditText generalpaper;
    String pp, generalpapere;
    int row, column, i;
    HashMap<String, String> aLevelResults = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_alevel_results);
        LinearLayout mLayout = (LinearLayout) findViewById(R.id.layouta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Bundle gotBasket = getIntent().getExtras();
        gotBreadalv = gotBasket.getStringArrayList("subjects");

        for (int i = 0; i < gotBreadalv.size(); i++) {
            pp = pp + "\n" + gotBreadalv.get(i);

            TextView textView = new TextView(EnterALevelResults.this);
            textView.setText(gotBreadalv.get(i));
            textView.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(12, 12, 12, 12); // llp.setMargins(left, top, right, bottom);
            textView.setLayoutParams(llp);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
            mLayout.addView(textView);

            EditText mEdit1 = new EditText(EnterALevelResults.this);

            alleds.add(mEdit1);
            mEdit1.setTag(gotBreadalv.get(i).toLowerCase());
            Log.d(TAG, "Ale subjects: " + gotBreadalv.get(i).toLowerCase());
            if (gotBreadalv.get(i).equals("Computer") || gotBreadalv.get(i).equals("Sub Math"))
                mEdit1.setHint("Enter Grades (D,C,P,F)");
            else
                mEdit1.setHint("Enter Grades (A,B,C,D,E,O)");

            mEdit1.setId(i);
            mEdit1.setPadding(20, 0, 0, 10);
            mEdit1.setBackgroundColor(Color.WHITE);
            mEdit1.setTextColor(Color.BLACK);
            mEdit1.setEms(10);
            mEdit1.setHeight(getResources().getDimensionPixelSize(R.dimen.dyno_et));
            //mEdit.setInputType(0x00001001);
            // Set the background resource of EditText widget
            mEdit1.setBackgroundResource(R.drawable.edittext_bg);
            // Create a border programmatically
            ShapeDrawable shape = new ShapeDrawable(new RectShape());
            shape.getPaint().setColor(Color.RED);
            shape.getPaint().setStyle(Paint.Style.STROKE);
            shape.getPaint().setStrokeWidth(3);

            mEdit1.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,
                    Toolbar.LayoutParams.WRAP_CONTENT));
            mEdit1.setFocusableInTouchMode(true);
            mEdit1.setFocusable(true);
            mEdit1.requestFocus();
            mLayout.addView(mEdit1);
            yCheck.add(mEdit1);
        }

        TextView textView = new TextView(EnterALevelResults.this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        textView.setPadding(17, 0, 0, 0);
        textView.setTextSize(20);
        mLayout.addView(textView);


        gotBasket.getStringArrayList("subjects").clear();
        generalpaper = (EditText) findViewById(R.id.editgeneralpaper);
        generalpaper.setTag("general paper");

        // Set the background resource of EditText widget
        generalpaper.setBackgroundResource(R.drawable.edittext_bg);
        //Validating on focus-change
        generalpaper.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    generalpapere = generalpaper.getText().toString().toUpperCase();
                    if ((generalpapere.equals("D") || generalpapere.equals("C") || generalpapere.equals("P") || generalpapere.equals("F") && generalpaper.getText().length() != 0)) {
                        generalpaper.setError(null);
                    } else {
                        generalpaper.setError("Invalid Grades");
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
                // TODO Auto-generated method stub
                int x = 0;

                HashMap<String, String> tg = new HashMap<>();
                StringBuffer js = new StringBuffer();
                String subs = null;
                String gp = null;

                /*General paper result*/
                generalpapere = generalpaper.getText().toString().toUpperCase();
                if (generalpaper.getText().length() == 0) {
                    generalpaper.setError("Field cannot be left blank.");

                    x++;
                } else {
                    if (generalpapere.equals("D") || generalpapere.equals("C")
                            || generalpapere.equals("P")
                            || generalpapere.equals("F")) {

                        aLevelResults.put(generalpaper.getTag().toString(), generalpapere);
                        gp = generalpaper.getTag().toString()+"="+generalpapere;

                    } else {
                        generalpaper.setError("Invalid Grades");
                        x++;
                    }
                }



                for (int i = 0; i < alleds.size(); i++) {

                    EditText eEt = alleds.get(i);
                    String sEt = alleds.get(i).getText().toString().trim();

                    if (eEt.getTag().toString().equalsIgnoreCase("Computer")) {
                        if (sEt.length() == 0) {
                            eEt.setError("Field cannot be left blank.");
                            x++;
                        } else {
                            if (sEt.equalsIgnoreCase("D")
                                    || sEt.equalsIgnoreCase("C")
                                    || sEt.equalsIgnoreCase("P")
                                    || sEt.equalsIgnoreCase("F")) {
                                aLevelResults.put(eEt.getTag().toString(),
                                        sEt.toUpperCase());
                                subs = eEt.getTag().toString()+"="+sEt.toUpperCase();
                            } else {
                                eEt.setError("Invalid grade");
                                x++;
                            }
                        }
                    } else if (eEt.getTag().toString().equalsIgnoreCase("Sub Math")) {
                        if (sEt.length() == 0) {
                            eEt.setError("Field cannot be left blank.");
                            x++;
                        } else {
                            if (sEt.equalsIgnoreCase("D")
                                    || sEt.equalsIgnoreCase("C")
                                    || sEt.equalsIgnoreCase("P")
                                    || sEt.equalsIgnoreCase("F")) {

                                aLevelResults.put(eEt.getTag().toString(),
                                        sEt.toUpperCase());
                                subs = eEt.getTag().toString()+"="+sEt.toUpperCase();

                            } else {
                                eEt.setError("Invalid grade");
                                x++;
                            }
                        }
                    }


                    if (sEt.length() == 0) {
                        eEt.setError("Field cannot be left blank.");
                        x++;
                    } else {
                        if (sEt.equalsIgnoreCase("A")
                                || sEt.equalsIgnoreCase("B")
                                || sEt.equalsIgnoreCase("C")
                                || sEt.equalsIgnoreCase("D")
                                || sEt.equalsIgnoreCase("E")
                                || sEt.equalsIgnoreCase("O")
                                || sEt.equalsIgnoreCase("F")) {
                            if (eEt.getTag().toString().equalsIgnoreCase("Sub math")
                                    || eEt.getTag().toString().equalsIgnoreCase("Computer")) {
                                continue;
                            }

                            tg.put(eEt.getTag().toString(),
                                    sEt.equalsIgnoreCase("F")?"Z":sEt.toUpperCase());
                                /*aLevelResults.put(eEt.getTag().toString(),
                                        sEt.toUpperCase());*/


                        } else {
                            eEt.setError("Invalid grade");
                            x++;
                        }
                    }



                }


                //aLevelResults.putAll(sortByValue(tg));




                js.append("{");
                String dVal;
                for (Map.Entry<String, String> entry : sortByValue(tg).entrySet()) {
                    System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
                    dVal = entry.getValue().equalsIgnoreCase("Z")?"F":entry.getValue();
                    js.append(entry.getKey()+"="+ dVal);
                    js.append(", ");
                }
                js.append(subs+", ");
                js.append(gp);
                js.append("}");


                if (aLevelResults.isEmpty()) {

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            EnterALevelResults.this);

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
                    Log.d(TAG, "All: " + js);


                    ProcessData.OlevelResults oLevelResultHash =
                            new ProcessData.OlevelResults(EnterALevelResults.this);

                    Log.d(TAG, "Ole: " + oLevelResultHash.getEntries().toString());

                    ProcessData.Prerequisites prerequisites =
                            new ProcessData.Prerequisites(EnterALevelResults.this);

                    Log.d(TAG, "Pre : " + prerequisites.getEntries().toString());

                    ProcessData.AlevelResults aLevelResultHash =
                            new ProcessData.AlevelResults(EnterALevelResults.this, js.toString());

                    Log.d(TAG, "Ale: " + aLevelResultHash.getAJString()+" ..... "+aLevelResults.size()+" ****** "+js);


                    Intent i = new Intent(EnterALevelResults.this, ProcessedChoicesListActivity.class);
                    startActivity(i);
                }

            }


        });
    }



    public <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
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
