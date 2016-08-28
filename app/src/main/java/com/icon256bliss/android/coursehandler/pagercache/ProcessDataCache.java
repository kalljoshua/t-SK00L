package com.icon256bliss.android.coursehandler.pagercache;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 0 on 6/5/2016.
 */
public class ProcessDataCache {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared pref file name
    private static final String PREF_NAME = "com.icon265bliss.android.coursehandler.PROCESS_RESULT_KEY";

    // Prerequisites
    public static final String KEY_PREREQUISITES = "prerequisites";

    public static final String KEY_OLEVEL_RESULTS = "olevelResults";

    public static final String KEY_ALEVEL_RESULTS = "alevelResults";

    // Constructor
    public ProcessDataCache(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setPrerequisites(String prerequisites) {

        // Storing prerequisites in pref
        editor.putString(KEY_PREREQUISITES, prerequisites);

        // commit changes
        editor.commit();
    }

    public void setOlevelResults(String olevelResults) {

        // Storing olevel results in pref
        editor.putString(KEY_OLEVEL_RESULTS, olevelResults);

        // commit changes
        editor.commit();
    }

    public void setAlevelResults(String alevelResults) {

        // Storing alevel results in pref
        editor.putString(KEY_ALEVEL_RESULTS, alevelResults);

        // commit changes
        editor.commit();
    }

    /**
     * Get stored cache data
     */
    public HashMap<String, String> getPrerequisites() {

        String s = pref.getString(KEY_PREREQUISITES, null);

        String value = s.toString();
        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        HashMap<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
        }

        // return hasmap
        return map;
    }

    public JSONObject pJString(){

        return new JSONObject(getPrerequisites());

    }

    /**
     * Get stored cache data
     */
    public HashMap<String, String> getOlevelResults() {

        String s = pref.getString(KEY_OLEVEL_RESULTS, null);

        String value = s.toString();
        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        HashMap<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
        }

        // return hasmap
        return map;
    }

    public JSONObject oJString(){

        return new JSONObject(getOlevelResults());

    }

    /**
     * Get stored cache data
     */
    public HashMap<String, String> getAlevelResults() {

        String s = pref.getString(KEY_ALEVEL_RESULTS, null);

        String value = s.toString();
        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        HashMap<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
        }

        // return hasmap
        return map;
    }

    /**
     * Get stored cache data
     */
    public String getAlevelResultsJson() {

        return pref.getString(KEY_ALEVEL_RESULTS, null);
    }

    public JSONObject aJString(){

        String s = pref.getString(KEY_ALEVEL_RESULTS, null);

        assert s != null;
        System.out.println("The foreign string "+ s);


        //String value = "{name=akena,age=21}";
        String value = s;
        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");

        JSONObject obj = new JSONObject();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            try {
                obj.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println("The string "+obj.toString());
        }


        return obj;

    }


}
