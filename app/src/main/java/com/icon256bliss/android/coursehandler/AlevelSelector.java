package com.icon256bliss.android.coursehandler;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class AlevelSelector extends AppCompatActivity {

    ArrayList<String> selectedSubjects = new ArrayList<>();
    CheckBox physics, chemistry, biology, geography, techinical,
            fnnutrition, computer, math, economics, fineart, cre, literature,
            submath, agriculture, kiswahili, french, metalwork, luganda,
            latin, arabic, music, germany, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alevel_selector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        physics = (CheckBox) findViewById(R.id.chkAndroid);
        chemistry = (CheckBox) findViewById(R.id.chemistry);
        biology = (CheckBox) findViewById(R.id.biology);
        geography = (CheckBox) findViewById(R.id.geography);
        history = (CheckBox) findViewById(R.id.history);
        techinical = (CheckBox) findViewById(R.id.tdrawing);
        fnnutrition = (CheckBox) findViewById(R.id.foodandnutrition);
        computer = (CheckBox) findViewById(R.id.computer);
        math = (CheckBox) findViewById(R.id.chkIos);

        economics = (CheckBox) findViewById(R.id.economics);
        fineart = (CheckBox) findViewById(R.id.fineart);
        cre = (CheckBox) findViewById(R.id.cre);
        literature = (CheckBox) findViewById(R.id.literature);
        submath = (CheckBox) findViewById(R.id.submath);
        agriculture = (CheckBox) findViewById(R.id.agriculture);
        kiswahili = (CheckBox) findViewById(R.id.kiswahili);
        french = (CheckBox) findViewById(R.id.french);
        metalwork = (CheckBox) findViewById(R.id.metalwork);
        luganda = (CheckBox) findViewById(R.id.luganda);
        latin = (CheckBox) findViewById(R.id.latin);
        arabic = (CheckBox) findViewById(R.id.arabic);
        music = (CheckBox) findViewById(R.id.music);
        germany = (CheckBox) findViewById(R.id.germany);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (physics.isChecked()) {
                    if (!selectedSubjects.contains("Physics"))
                        selectedSubjects.add("Physics");
                } else {
                    if (selectedSubjects.contains("Physics")) {
                        selectedSubjects.remove("Physics");
                    }
                }

                if (chemistry.isChecked()) {
                    if (!selectedSubjects.contains("Chemistry"))
                        selectedSubjects.add("Chemistry");
                } else {
                    if (selectedSubjects.contains("Chemistry")) {
                        selectedSubjects.remove("Chemistry");
                    }
                }


                if (biology.isChecked()) {
                    if (!selectedSubjects.contains("Biology"))
                        selectedSubjects.add("Biology");
                } else {
                    if (selectedSubjects.contains("Biology")) {
                        selectedSubjects.remove("Biology");
                    }
                }

                if (geography.isChecked()) {
                    if (!selectedSubjects.contains("Geography"))
                        selectedSubjects.add("Geography");
                } else {
                    if (selectedSubjects.contains("Geography")) {
                        selectedSubjects.remove("Geography");
                    }
                }

                if (techinical.isChecked()) {
                    if (!selectedSubjects.contains("Techinical Drawing"))
                        selectedSubjects.add("Techinical Drawing");
                } else {
                    if (selectedSubjects.contains("Techinical Drawing")) {
                        selectedSubjects.remove("Techinical Drawing");
                    }
                }

                if (history.isChecked()) {
                    if (!selectedSubjects.contains("History"))
                        selectedSubjects.add("History");
                } else {
                    if (selectedSubjects.contains("History")) {
                        selectedSubjects.remove("History");
                    }
                }

                if (fnnutrition.isChecked()) {
                    if (!selectedSubjects.contains("Food and Nutrition"))
                        selectedSubjects.add("Food and Nutrition");
                } else {
                    if (selectedSubjects.contains("Food and Nutrition")) {
                        selectedSubjects.remove("Food and Nutrition");
                    }
                }

                if (computer.isChecked()) {
                    if (!selectedSubjects.contains("Computer"))
                        selectedSubjects.add("Computer");
                } else {
                    if (selectedSubjects.contains("Computer")) {
                        selectedSubjects.remove("Computer");
                    }
                }


                if (math.isChecked()) {
                    if (!selectedSubjects.contains("Mathematics"))
                        selectedSubjects.add("Mathematics");
                } else {
                    if (selectedSubjects.contains("Mathematics")) {
                        selectedSubjects.remove("Mathematics");
                    }
                }

                if (economics.isChecked()) {
                    if (!selectedSubjects.contains("Economics"))
                        selectedSubjects.add("Economics");
                } else {
                    if (selectedSubjects.contains("Economics")) {
                        selectedSubjects.remove("Economics");
                    }
                }

                if (fineart.isChecked()) {
                    if (!selectedSubjects.contains("Fine Art"))
                        selectedSubjects.add("Fine Art");
                } else {
                    if (selectedSubjects.contains("Fine Art")) {
                        selectedSubjects.remove("Fine Art");
                    }
                }

                if (cre.isChecked()) {
                    if (!selectedSubjects.contains("Christian Religious Education"))
                        selectedSubjects.add("Christian Religious Education");
                } else {
                    if (selectedSubjects.contains("Christian Religious Education")) {
                        selectedSubjects.remove("Christian Religious Education");
                    }
                }

                if (literature.isChecked()) {
                    if (!selectedSubjects.contains("Literature"))
                        selectedSubjects.add("Literature");
                } else {
                    if (selectedSubjects.contains("Literature")) {
                        selectedSubjects.remove("Literature");
                    }
                }

                if (submath.isChecked()) {
                    if (!selectedSubjects.contains("Sub Math"))
                        selectedSubjects.add("Sub Math");
                } else {
                    if (selectedSubjects.contains("Sub Math")) {
                        selectedSubjects.remove("Sub Math");
                    }
                }

                if (agriculture.isChecked()) {
                    if (!selectedSubjects.contains("Agriculture"))
                        selectedSubjects.add("Agriculture");
                } else {
                    if (selectedSubjects.contains("Agriculture")) {
                        selectedSubjects.remove("Agriculture");
                    }
                }

                if (kiswahili.isChecked()) {
                    if (!selectedSubjects.contains("Kiswahili"))
                        selectedSubjects.add("Kiswahili");
                } else {
                    if (selectedSubjects.contains("Kiswahili")) {
                        selectedSubjects.remove("Kiswahili");
                    }
                }

                if (french.isChecked()) {
                    if (!selectedSubjects.contains("French"))
                        selectedSubjects.add("French");
                } else {
                    if (selectedSubjects.contains("French")) {
                        selectedSubjects.remove("French");
                    }
                }

                if (metalwork.isChecked()) {
                    if (!selectedSubjects.contains("Metal Work"))
                        selectedSubjects.add("Metal Work");
                } else {
                    if (selectedSubjects.contains("Metal Work")) {
                        selectedSubjects.remove("Metal Work");
                    }
                }

                if (luganda.isChecked()) {
                    if (!selectedSubjects.contains("Luganda"))
                        selectedSubjects.add("Luganda");
                } else {
                    if (selectedSubjects.contains("Luganda")) {
                        selectedSubjects.remove("Luganda");
                    }
                }

                if (latin.isChecked()) {
                    if (!selectedSubjects.contains("Latin"))
                        selectedSubjects.add("Latin");
                } else {
                    if (selectedSubjects.contains("Latin")) {
                        selectedSubjects.remove("Latin");
                    }
                }

                if (arabic.isChecked()) {
                    if (!selectedSubjects.contains("Arabic"))
                        selectedSubjects.add("Arabic");
                } else {
                    if (selectedSubjects.contains("Arabic")) {
                        selectedSubjects.remove("Arabic");
                    }
                }

                if (music.isChecked()) {
                    if (!selectedSubjects.contains("Music"))
                        selectedSubjects.add("Music");
                } else {
                    if (selectedSubjects.contains("Music")) {
                        selectedSubjects.remove("Music");
                    }
                }

                if (germany.isChecked()) {
                    if (!selectedSubjects.contains("Germany"))
                        selectedSubjects.add("Germany");
                } else {
                    if (selectedSubjects.contains("Germany")) {
                        selectedSubjects.remove("Germany");
                    }
                }

                if (selectedSubjects.size() != 4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSelector.this);
                    String Checked = "";
                    for (int i = 0; i < selectedSubjects.size(); i++) {
                        Checked += selectedSubjects.get(i) + "\n";
                    }

                    builder.setTitle("YOU SELECTED MORE OR LESS SUBJECTS");
                    builder.setMessage(Checked);

                    builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Do nothing but close the dialog

                            selectedSubjects.clear();
                            //reload activity
                            startActivity(getIntent());


                        }

                    });


                    AlertDialog alert = builder.create();
                    alert.show();

                } else {
                    // String subjects
                    if (!selectedSubjects.contains("Computer")
                            && !selectedSubjects.contains("Sub Math")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSelector.this);
                        String Checked = "";
                        for (int i = 0; i < selectedSubjects.size(); i++) {
                            Checked += selectedSubjects.get(i) + "\n";
                        }

                        builder.setTitle("SELECTION MUST HAVE EITHER SUB-MATH OR COMPUTER");
                        builder.setMessage(Checked);

                        builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing but close the dialog

                                selectedSubjects.clear();
                                //reload activity
                                startActivity(getIntent());
                            }

                        });

                        AlertDialog alert = builder.create();
                        alert.show();

                    }else {

                        if (selectedSubjects.contains("Computer")
                                && selectedSubjects.contains("Sub Math")) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSelector.this);
                            String Checked = "";
                            for (int i = 0; i < selectedSubjects.size(); i++) {
                                Checked += selectedSubjects.get(i) + "\n";
                            }


                            builder.setTitle("YOU CAN'T SELECT BOTH SUB MATH AND COMPUTER");
                            builder.setMessage(Checked);

                            builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

                                    selectedSubjects.clear();
                                    //reload activity
                                    startActivity(getIntent());
                                }

                            });

                            AlertDialog alert = builder.create();
                            alert.show();

                        } else if (selectedSubjects.contains("Sub Math")
                                && selectedSubjects.contains("Mathematics")) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSelector.this);
                            String Checked = "";
                            for (int i = 0; i < selectedSubjects.size(); i++) {
                                Checked += selectedSubjects.get(i) + "\n";
                            }


                            builder.setTitle("YOU CAN'T SELECT BOTH SUB MATH AND MATHEMATICS");
                            builder.setMessage(Checked);

                            builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

                                    selectedSubjects.clear();
                                    //reload activity
                                    startActivity(getIntent());
                                }

                            });

                            AlertDialog alert = builder.create();
                            alert.show();

                        } else {
                            Bundle basket = new Bundle();
                            basket.putStringArrayList("subjects", selectedSubjects);
                            Intent i = new Intent(AlevelSelector.this, EnterALevelResults.class);
                            i.putExtras(basket);
                            startActivity(i);
                        }
                    }
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
