package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

import static starter.elements.HomePage.*;
import static starter.elements.Pages.*;
import static starter.stepdefinitions.Constants.*;

public class SearchStepDefinitions {

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
}
