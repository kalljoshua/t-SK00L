package com.icon256bliss.android.coursehandler.appModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kall on 8/5/2016.
 */
public class Appdata {
    private static List<University> universitesList = null;
    private static List<College> collegeList = null;
    private static List<Course> courseList = null;
    private static List<PossibleChoice> possibleChoiceList = null;

    public static List<University> getUniversitesList(){
        if(universitesList==null){
            universitesList = new ArrayList<>();
        }
        return universitesList;
    }

    public static List<College> getCollegeList(){
        if(collegeList==null){
            collegeList = new ArrayList<>();
        }
        return collegeList;
    }

    public static List<Course> getCourseList(){
        if(courseList==null){
            courseList = new ArrayList<>();
        }
        return courseList;
    }

    public static List<PossibleChoice> getPossibleChoiceList(){
        if(possibleChoiceList==null){
            possibleChoiceList = new ArrayList<>();
        }
        return possibleChoiceList;
    }
}
