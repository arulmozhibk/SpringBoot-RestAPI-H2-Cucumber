package com.sb.rest.app.sbapph2.consts;

public class Constants {

    //Applicaiton Policies
    public static final int PASSWORD_LENGTH=8;
    public static final int GROUPID_MIN_MAX_LENGTGH=6;
    public static final int APPID_MIN_MAX_LENGTGH=3;
    public static final int USERID_MIN_LENGTGH=6;

    //Application Group configuration
    public static final String APP_GROUP_GIM="GIM";
    public static final String APP_GROUP_GIT="GIT";
    public static final String APP_GROUP_GIH="GIH";
    public static final String APP_GROUP_GIP="GIP";

    //Role Configuration
    public static final String GIT_ADMIN_ROLE="3000";
    public static final String GIT_OPERATOR_ROLE="3001";
    public static final String GIT_SUPPORT_ROLE="3002";

    public static final String GIM_ADMIN_ROLE="1000";
    public static final String GIM_OPERATOR_ROLE="1001";
    public static final String GIM_SUPPORT_ROLE="1002";

    //Response Code
    public static final String OPERATION_SUCCESS="100";
    public static final String OPERATION_FAILED="101";
    public static final String APPID_INVALID="102";
    public static final String GROUPID_INVALID="103";
    public static final String USERID_INVALID="104";
    public static final String INVALID_ADMIN_USER="104";
    public static final String USER_AUTHENTICATION_FAILED="105";

    //Application Configuration
    public static final String PARAMETER_MISSING="110";
}
