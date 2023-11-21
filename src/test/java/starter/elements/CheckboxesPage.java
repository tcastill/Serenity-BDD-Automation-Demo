package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class CheckboxesPage {
    public static final String CHECKED = "checked";
    public static final String CHECKBOXES_HEADER = "Checkboxes";
    public static final String CHECKBOX_ONE_ELEMENT = "//*[@id=\"checkboxes\"]/input[1]";
    public static final String CHECKBOX_TWO_ELEMENT = "//*[@id=\"checkboxes\"]/input[2]";
    public static Target CHECKBOXES_ONE = Target.the("Checkboxes").locatedBy(CHECKBOX_ONE_ELEMENT);
    public static Target CHECKBOXES_TWO = Target.the("Checkboxes").locatedBy(CHECKBOX_TWO_ELEMENT);
    public static Target CHECKBOXES = Target.the("Checkboxes").locatedBy("//a[contains(., 'Checkboxes')]");
}