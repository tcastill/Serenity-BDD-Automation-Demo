package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class ElementalSeleniumPage {
    public static final String ELEMENTAL_STRING = "Elemental Selenium";
    public static final String ELEMENTAL_SELENIUM_URL = "https://elementalselenium.com/";
    public static Target ELEMENTAL_SELENIUM = Target.the("A/B Testing").locatedBy("//a[contains(., 'Elemental Selenium')]");
}