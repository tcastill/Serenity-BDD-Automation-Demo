package starter.elements;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Broken Images page constants and locators
 *
 * @author Cristorey Castillo
 */
public class BrokenImagesPage {
    public static final String BROKEN_IMAGES_HEADER = "Broken Images";
    public static final String NATURAL_WIDTH = "naturalWidth";
    public static final String OUTTER_HTML = "outerHTML";
    public static final String IMG = "img";
    public static final String NONE = "none";
    public static final String BROKEN_IMAGE_URL = "http://the-internet.herokuapp.com/broken_images";
    public static Target BROKEN_IMAGES = Target.the("Broken Images").locatedBy("//a[contains(., 'Broken Images')]");
}
