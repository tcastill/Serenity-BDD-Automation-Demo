package starter.tools;

import org.openqa.selenium.WebElement;

public class Criteria {
    public void isImageBroken(WebElement image)
    {
        if (image.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
        }
    }
}
