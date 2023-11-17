package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;
import static starter.elements.HomePage.*;
import static starter.elements.Pages.*;
import static starter.stepdefinitions.Constants.*;

@Slf4j
public class SearchStepDefinitions {

    @Managed
    WebDriver driver;

    private EnvironmentVariables env;

    @Given("{actor} goes to herokuapp and checks the page")
    public void checksHerokuappPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(String.valueOf(TheWebPage.title())).containsIgnoringCase(term));
    }

    @When("{actor} verifies link is working for AB Testing")
    public void heVerifiesLinkIsWorkingFor(Actor actor) {
        actor.attemptsTo(
                Ensure.that(AB_TESTING).hasText(AB_TESTING_HEADER),
                Click.on(AB_TESTING),
                Ensure.thatTheCurrentPage().pageSource().containsIgnoringCase(AB_TESTING_PAGE_STRING)
        );
    }

    @Then("{actor} can click on the footer Elemental Selenium")
    public void heCanClickOnTheFooterElementalSelenium(Actor actor) {
        actor.attemptsTo(
                Ensure.that(ELEMENTAL_SELENIUM).hasText(ELEMENTAL_STRING),
                Click.on(ELEMENTAL_SELENIUM).afterWaitingUntilEnabled(),
                Switch.toNewWindow(),
                Ensure.thatTheCurrentPage().currentUrl().contains(ELEMENTAL_SELENIUM_URL)
        );
    }

    @When("{actor} verifies link is working for Add Remove Elements")
    public void heVerifiesLinkIsWorkingForAddRemoveElements(Actor actor) {
        actor.attemptsTo(
                Ensure.that(ADD_REMOVE_ELEMENTS).hasText(ADD_REMOVE_HEADER),
                Click.on(ADD_REMOVE_ELEMENTS),
                Click.on(ADD_REMOVE_ELEMENT_ADD_BUTTON),
                Click.on(ADD_REMOVE_ELEMENT_DELETE_BUTTON),
                Ensure.that(ADD_REMOVE_ELEMENT_DELETE_BUTTON).isNotDisplayed()
        );
    }

    @When("{actor} is able to add {int} multiple elements and then delete them all")
    public void heIsAbleToKeepAddingMultipleElementsAndThenDeleteThemAll(Actor actor,int count) {
        for(int i = 0;i < count;i++){
            actor.attemptsTo(Click.on(ADD_REMOVE_ELEMENT_ADD_BUTTON));
        }

        for(int d = 0;d < count;d++){
            actor.attemptsTo(Click.on(ADD_REMOVE_ELEMENT_DELETE_BUTTON));
        }

        actor.attemptsTo(Ensure.that(ADD_REMOVE_ELEMENT_DELETE_BUTTON).isNotDisplayed());
    }

    @When("{actor} can land to the basic auth from the UI")
    public void heCanLandToTheBasicAuthFromTheUI(Actor actor) {
        actor.attemptsTo(
                Ensure.that(BASIC_AUTH).hasText(BASIC_AUTH_HEADER),
                Click.on(BASIC_AUTH).afterWaitingUntilPresent(),
                Ensure.thatTheCurrentPage().currentUrl().contains("https://the-internet.herokuapp.com")
        );
    }

    @When("he successfully logs in to Basic Auth with the endpoint")
    public void heSuccessfullyLogsInToBasicAuthWithTheEndpoint() {
        Actor actor = Actor.named("Admin")
                .whoCan(CallAnApi.at("https://the-internet.herokuapp.com"));

        actor.attemptsTo(
                Get.resource("/basic_auth")
                        .with(request ->
                                request.header(
                                        "Authorization", "Basic YWRtaW46YWRtaW4=")));

        actor.should(
                seeThatResponse("200 with Congratulations should be returned",
                        response -> response.statusCode(200)
                                .body(anything("Congratulations")))
        );
    }

    @When("he fails to log in to Basic Auth and redirect correctly with the endpoint")
    public void heFailsToLogInToBasicAuthAndRedirectCorrectlyWithTheEndpoint() {
        Actor actor = Actor.named("Admin")
                .whoCan(CallAnApi.at("https://the-internet.herokuapp.com"));

        actor.attemptsTo(
                Get.resource("/basic_auth")
                        .with(request ->
                                request.header(
                                        "Authorization", "Basic none")));

        actor.should(
                seeThatResponse("200 with Congratulations should be returned",
                        response -> response.statusCode(401)
                                .body(anything("Not authorized")))
        );
    }

    @When("{actor} verifies link is working for Broken Images")
    public void heVerifiesLinkIsWorkingForBrokenImages(Actor actor) {
        actor.attemptsTo(
                Ensure.that(BROKEN_IMAGES).hasText(BROKEN_IMAGES_HEADER),
                Click.on(BROKEN_IMAGES),
                Ensure.thatTheCurrentPage().pageSource().containsIgnoringCase(BROKEN_IMAGES_HEADER)
        );
    }

    @When("he finds that there are {int} total broken images on the page")
    public void heFindsThatThereAreTotalBrokenImagesOnThePage(int images) {
        int brokenImage = 0;
        driver.get("http://the-internet.herokuapp.com/broken_images");
        for (WebElement image : driver.findElements(By.cssSelector("img"))) {
            if (image.getAttribute("naturalWidth").equals("0"))
            {
                log.debug(image.getAttribute("outerHTML") + " is broken.");
                brokenImage++;
            }
        }
        log.info("Total amount of broken images are {}", brokenImage);
        Assert.assertEquals("should be the same", brokenImage, images);
    }
}