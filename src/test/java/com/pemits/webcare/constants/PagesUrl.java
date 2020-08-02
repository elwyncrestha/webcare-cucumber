package com.pemits.webcare.constants;

/**
 * @author Elvin Shrestha on 7/2/2020
 */
public class PagesUrl {

    public static final String BASE_URL = "http://localhost:4200/#";
    public static final String LOGIN_PAGE_URL = BASE_URL + "/login";
    public static final String FEATURE_URL = BASE_URL + "/feature";
    public static final String DASHBOARD_URL = FEATURE_URL + "/dashboard";
    public static final String DEPARTMENT_COMPONENT_URL = FEATURE_URL + "/departments";
    public static final String DOCTOR_COMPONENT_URL = FEATURE_URL + "/users/doctor";
    public static final String PATIENT_COMPONENT_URL = FEATURE_URL + "/users/patient";
    public static final String NOTIFICATION_COMPONENT_URL = FEATURE_URL + "/notification";
    public static final String PROFILE_COMPONENT_URL = FEATURE_URL + "/profile";
    public static final String HELP_DESK_COMPONENT_URL = BASE_URL + "/portal/user-query";
    public static final String FEEDBACK_COMPONENT_URL = BASE_URL + "/portal/feedback";

    private PagesUrl() {}
}
