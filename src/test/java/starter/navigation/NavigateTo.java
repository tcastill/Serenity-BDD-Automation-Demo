package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * The type Navigate to.
 *
 * @author Cristorey Castillo
 */
public class NavigateTo {
    /**
     * Opens the home page on the browser
     *
     * @return the performable
     */
    public static Performable theHomePage() {
        return Task.where("{0} opens the Heroku App home page",
                Open.browserOn().the(HerokuAppHomePage.class));
    }
}
