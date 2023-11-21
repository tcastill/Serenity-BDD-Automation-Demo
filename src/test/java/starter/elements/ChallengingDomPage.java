package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class ChallengingDomPage {
    public static final String BLUE_BUTTON_NAME = "BLUE DOM BUTTON";
    public static final String CHALLENGING_DOM_HEADER = "Challenging DOM";
    public static Target BLUE_DOM_BUTTON = Target.the("BLUE DOM BUTTON").locatedBy("/html/body/div[2]/div/div/div/div/div[1]/a[1]");
    public static Target CHALLENGING_DOM = Target.the("Challenging DOM").locatedBy("//a[contains(., 'Challenging DOM')]");
}
