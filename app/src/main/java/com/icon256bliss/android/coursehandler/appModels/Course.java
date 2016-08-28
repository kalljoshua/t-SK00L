package com.icon256bliss.android.coursehandler.appModels;

/**
 * Created by Kall on 8/5/2016.
 */
public class Course {
    public int id;
    public String name;
    public String tuition;
    public String duration;
    public String programme;
    public String cpPujab;
    public String cpPrivate;
    public String details;
    public String availability;

    public Course(int id, String name, String tuition, String duration,
                  String programme, String cpPujab, String cpPrivate,
                  String details, String availability) {
        this.id = id;
        this.name = name;
        this.tuition = tuition;
        this.duration = duration;
        this.programme = programme;
        this.cpPujab = cpPujab;
        this.cpPrivate = cpPrivate;
        this.details = details;
        this.availability = availability;
    }

}
