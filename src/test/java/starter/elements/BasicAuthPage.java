package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class BasicAuthPage {
    public static final String ADMIN = "admin";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String BASIC_AUTHEN = "/basic_auth";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BASIC_CRED = "Basic YWRtaW46YWRtaW4=";
    public static final String MAIN_URL = "https://the-internet.herokuapp.com";
    public static final String BASIC_AUTH_HEADER = "Basic Auth";
    public static final String CONGRATULATIONS = "Congratulations";
    public static final String NOT_AUTHORIZED = "Not authorized";
    public static Target BASIC_AUTH = Target.the("Basic Auth").locatedBy("//a[contains(., 'Basic Auth')]");
}