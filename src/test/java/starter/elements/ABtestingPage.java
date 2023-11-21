package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class ABtestingPage {
    public static final String AB_TESTING_PAGE_STRING = "Also known as split testing";
    public static final String AB_TESTING_HEADER = "A/B Testing";
    public static Target AB_TESTING = Target.the("A/B Testing").locatedBy("//a[contains(., 'A/B Testing')]");
}
