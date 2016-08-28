package com.icon256bliss.android.coursehandler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.icon256bliss.android.coursehandler.appModels.ProcessData;

import java.util.ArrayList;

public class OlevelSelector extends AppCompatActivity {
    private static final String TAG = OlevelSelector.class.getSimpleName();
    ArrayList<String> selectedSubjects = new ArrayList<>();
    CheckBox techinical, Homeeconomics, computer, political, fineart, cre, literature,
            addmath, agriculture, kiswahili, french, metalwork, luganda,latin, arabic, music, germany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olevelselector);//layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//tool bar
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ProcessData.Prerequisites prerequisites =
                new ProcessData.Prerequisites(OlevelSelector.this);

        Log.d(TAG,"Prerequisites cache: "+prerequisites.getEntries().toString());


        //finding checkbox views by ID
        techinical = (CheckBox) findViewById(R.id.tdrawing);
        Homeeconomics = (CheckBox) findViewById(R.id.Homeeconomics);
        computer = (CheckBox) findViewById(R.id.computer);
        political = (CheckBox) findViewById(R.id.political);
        fineart = (CheckBox) findViewById(R.id.fineart);
        cre = (CheckBox) findViewById(R.id.cre);
        literature = (CheckBox) findViewById(R.id.literature);
        addmath = (CheckBox) findViewById(R.id.addmath);
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

                if (techinical.isChecked()) {
                    if(!selectedSubjects.contains("Techinical Drawing"))
                        selectedSubjects.add("Techinical Drawing");
                }else{
                    if(selectedSubjects.contains("Techinical Drawing")){
                        selectedSubjects.remove("Techinical Drawing");
                    }
                }

                if (Homeeconomics.isChecked()) {
                    if(!selectedSubjects.contains("Home Economics"))
                        selectedSubjects.add("Home Economics");
                }else{
                    if(selectedSubjects.contains("Home Economics")){
                        selectedSubjects.remove("Home Economics");
                    }
                }
                if (computer.isChecked()) {
                    if(!selectedSubjects.contains("Computer"))
                        selectedSubjects.add("Computer");
                }else{
                    if(selectedSubjects.contains("Computer")){
                        selectedSubjects.remove("Computer");
                    }
                }
                if (political.isChecked()) {
                    if(!selectedSubjects.contains("Political Education"))
                        selectedSubjects.add("Political Education");
                }else{
                    if(selectedSubjects.contains("Political Education")){
                        selectedSubjects.remove("Political Education");
                    }
                }
                if (fineart.isChecked()) {
                    if(!selectedSubjects.contains("Fine Art"))
                        selectedSubjects.add("Fine Art");
                }else{
                    if(selectedSubjects.contains("Fine Art")){
                        selectedSubjects.remove("Fine Art");
                    }
                }
                if (cre.isChecked()) {
                    if(!selectedSubjects.contains("Christian Religious Education"))
                        selectedSubjects.add("Christian Religious Education");
                }else{
                    if(selectedSubjects.contains("Christian Religious Education")){
                        selectedSubjects.remove("Christian Religious Education");
                    }
                }
                if (literature.isChecked()) {
                    if(!selectedSubjects.contains("Literature"))
                        selectedSubjects.add("Literature");
                }else{
                    if(selectedSubjects.contains("Literature")){
                        selectedSubjects.remove("Literature");
                    }
                }
                if (addmath.isChecked()) {
                    if(!selectedSubjects.contains("Additional Math"))
                        selectedSubjects.add("Additional Math");
                }else{
                    if(selectedSubjects.contains("Additional Math")){
                        selectedSubjects.remove("Additional Math");
                    }
                }
                if (agriculture.isChecked()) {
                    if(!selectedSubjects.contains("Agriculture"))
                        selectedSubjects.add("Agriculture");
                }else{
                    if(selectedSubjects.contains("Agriculture")){
                        selectedSubjects.remove("Agriculture");
                    }
                }
                if (kiswahili.isChecked()) {
                    if(!selectedSubjects.contains("Kiswahili"))
                        selectedSubjects.add("Kiswahili");
                }else{
                    if(selectedSubjects.contains("Kiswahili")){
                        selectedSubjects.remove("Kiswahili");
                    }
                }
                if (french.isChecked()) {
                    if(!selectedSubjects.contains("French"))
                        selectedSubjects.add("French");
                }else{
                    if(selectedSubjects.contains("French")){
                        selectedSubjects.remove("French");
                    }
                }
                if (metalwork.isChecked()) {
                    if(!selectedSubjects.contains("Metal Work"))
                        selectedSubjects.add("Metal Work");
                }else{
                    if(selectedSubjects.contains("Metal Work")){
                        selectedSubjects.remove("Metal Work");
                    }
                }
                if (luganda.isChecked()) {
                    if(!selectedSubjects.contains("Luganda"))
                        selectedSubjects.add("Luganda");
                }else{
                    if(selectedSubjects.contains("Luganda")){
                        selectedSubjects.remove("Luganda");
                    }
                }
                if (latin.isChecked()) {
                    if(!selectedSubjects.contains("Latin"))
                        selectedSubjects.add("Latin");
                }else{
                    if(selectedSubjects.contains("Latin")){
                        selectedSubjects.remove("Latin");
                    }
                }
                if (arabic.isChecked()) {
                    if(!selectedSubjects.contains("Arabic"))
                        selectedSubjects.add("Arabic");
                }else{
                    if(selectedSubjects.contains("Arabic")){
                        selectedSubjects.remove("Arabic");
                    }
                }
                if (music.isChecked()) {
                    if(!selectedSubjects.contains("Music"))
                        selectedSubjects.add("Music");
                }else{
                    if(selectedSubjects.contains("Music")){
                        selectedSubjects.remove("Music");
                    }
                }
                if (germany.isChecked()) {
                    if(!selectedSubjects.contains("Germany"))
                        selectedSubjects.add("Germany");
                }else{
                    if(selectedSubjects.contains("Germany")){
                        selectedSubjects.remove("Germany");
                    }
                }


                if(selectedSubjects.size()>3 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(OlevelSelector.this);
                    String Checked = "";
                    for(int i=0; i<selectedSubjects.size(); i++){
                        Checked += selectedSubjects.get(i)+"\n";
                    }

                    builder.setTitle("YOU SELECTED MORE THAN 3 SUBJECTS");
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

                }else if(selectedSubjects.size()<1 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(OlevelSelector.this);
                    String Checked = "";
                    for(int i=0; i<selectedSubjects.size(); i++){
                        Checked += selectedSubjects.get(i)+"\n";
                    }

                    builder.setTitle("YOU NEED TO SELECT AT LEAST ONE SUBJECT");
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

                    // String subjects = result.toString();

                    Bundle basket = new Bundle();
                    basket.putStringArrayList("subjects", selectedSubjects);
                    Intent i = new Intent(OlevelSelector.this, EnterOlevelResults.class);
                    i.putExtras(basket);
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
