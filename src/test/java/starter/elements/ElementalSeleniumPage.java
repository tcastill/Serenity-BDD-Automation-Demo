package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Elemental Selenium page constants and locators
 *
 * @author Cristorey Castillo
 */
public class ElementalSeleniumPage {
    public static final String ELEMENTAL_STRING = "Elemental Selenium";
    public static final String ELEMENTAL_SELENIUM_URL = "https://elementalselenium.com/";
    public static Target ELEMENTAL_SELENIUM = Target.the("A/B Testing").locatedBy("//a[contains(., 'Elemental Selenium')]");
}