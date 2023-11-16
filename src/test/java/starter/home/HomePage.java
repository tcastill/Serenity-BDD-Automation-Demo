package starter.home;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static Target AB_TESTING = Target.the("A/B Testing").locatedBy("//*[@id=\"content\"]/ul/li[1]/a");
}
