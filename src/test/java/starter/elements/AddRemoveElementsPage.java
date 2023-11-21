package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

public class AddRemoveElementsPage {
    public static final String ADD_REMOVE_HEADER = "Add/Remove Elements";
    public static Target ADD_REMOVE_ELEMENTS = Target.the("Add/Remove Elements").locatedBy("//a[contains(., 'Add/Remove Elements')]");
    public static Target ADD_REMOVE_ELEMENT_ADD_BUTTON = Target.the("Add Element Button").locatedBy("//button[text()='Add Element']");
    public static Target ADD_REMOVE_ELEMENT_DELETE_BUTTON = Target.the("Add Element Button").locatedBy("//button[text()='Delete']");
}