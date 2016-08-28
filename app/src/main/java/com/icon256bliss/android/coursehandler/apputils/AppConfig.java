package com.icon256bliss.android.coursehandler.apputils;

/**
 * Created by Kall on 7/29/2016.
 */

public class AppConfig {
    //remote route
    private static String URL_ROOT = "http://weare-magpie.com/handler/";

    private static String URL_ROOT_2 = "http://traceme.net16.net/handler/";
    //local route
    private static String URL_ROOT_LOCAL = "http://192.168.8.103/icon256/handler/";

    /*
    *
    * Remote server user register url
     */
    public static String URL_REGISTER = URL_ROOT + "register.php";

    public static String URL_LOGIN = URL_ROOT + "login.php";

    public static String URL_UNIVERSITIES = URL_ROOT + "get_universities.php";

    public static String URL_COLLEGES = URL_ROOT + "get_colleges.php";

    public static String URL_COURSES = URL_ROOT + "get_courses.php";

    public static String URL_CHOICES = URL_ROOT + "select_courses.php";

    public static String URL_COURSE_DETAILS = URL_ROOT + "get_course_detail.php";

    /*
    *
    * End of remote server urls
    * */

    //----------------------------------------------------------------------------------------------


    /*
    *
    * Simo urls
     */
        /*public static String URL_UNIVERSITIES = URL_ROOT_2 + "get_universities.php";

        public static String URL_COLLEGES = URL_ROOT_2 + "get_colleges.php";

        public static String URL_COURSES = URL_ROOT_2 + "get_courses.php";

        public static String URL_CHOICES = URL_ROOT_2 + "select_courses.php";

        public static String URL_COURSE_DETAILS = URL_ROOT_2 + "get_course_detail.php";*/
        // local routes
    /*
    *
    * End of simo urls
     */

    //----------------------------------------------------------------------------------------------
    /*
    *
    * Local urls
     */

   /* public static String URL_UNIVERSITIES = URL_ROOT_LOCAL + "get_universities.php";

    public static String URL_COLLEGES = URL_ROOT_LOCAL + "get_colleges.php";

    public static String URL_COURSES = URL_ROOT_LOCAL + "get_courses.php";

    //public static String URL_CHOICES = URL_ROOT_LOCAL + "select_courses.php";
    public static String URL_CHOICES = URL_ROOT_LOCAL + "sample.php";

    public static String URL_COURSE_DETAILS = URL_ROOT_LOCAL + "get_course_detail.php";*/
    /*
    *
    * End of local urls
     */
}