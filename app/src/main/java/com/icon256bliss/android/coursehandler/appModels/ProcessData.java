package com.icon256bliss.android.coursehandler.appModels;

import android.content.Context;

import com.icon256bliss.android.coursehandler.pagercache.ProcessDataCache;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Kall on 8/5/2016.
 */
public class ProcessData {



    public static class Prerequisites{
        private HashMap<String,String> entries;
        ProcessDataCache pr;
        Context c;
        public Prerequisites(Context c){
            pr = new ProcessDataCache(c);
        }
        public Prerequisites(Context c,HashMap<String,String> entries){
            pr = new ProcessDataCache(c);
            pr.setPrerequisites(entries.toString());
        }
        public HashMap<String,String> getEntries(){

            return pr.getPrerequisites();
        }

        public JSONObject getPJString(){
            return pr.pJString();
        }
    }

    public static class OlevelResults{
        private HashMap<String,String> entries;
        ProcessDataCache ol;
        Context c;
        public OlevelResults(Context c){
            ol = new ProcessDataCache(c);
        }
        public OlevelResults(Context c,HashMap<String,String> entries){
            ol = new ProcessDataCache(c);
            ol.setOlevelResults(entries.toString());
        }
        public HashMap<String,String> getEntries(){

            return ol.getOlevelResults();
        }

        public JSONObject getOJString(){
            return ol.oJString();
        }
    }

    public static class AlevelResults{
        private HashMap<String,String> entries;
        ProcessDataCache al;
        Context c;
        public AlevelResults(Context c){
            al = new ProcessDataCache(c);
        }
        public AlevelResults(Context c,HashMap<String,String> entries){
            al = new ProcessDataCache(c);
            al.setAlevelResults(entries.toString());
        }
        public AlevelResults(Context c,String entries){
            al = new ProcessDataCache(c);
            al.setAlevelResults(entries);
        }
        public HashMap<String,String> getEntries(){

            return al.getAlevelResults();
        }

        public JSONObject getAJString(){
            return al.aJString();
        }

    }

}
