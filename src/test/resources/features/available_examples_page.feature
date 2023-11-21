Feature: Available Example Page Tests

  Background: Test Serenity Screenplay BDD with herokuapp page
    Given Edward goes to herokuapp and checks the page

  @Smoke
  Scenario: A/B Testing functionality
    When he verifies link is working for AB Testing
    Then he can click on the footer Elemental Selenium

  @Smoke
  Scenario: Add/Remove Elements
    When he verifies link is working for Add Remove Elements
    And he is able to add 10 multiple elements and then delete them all
    Then he can click on the footer Elemental Selenium

  @Smoke
  Scenario: Basic Auth: Login Successfully
    When he successfully logs in to Basic Auth with the endpoint
    When he fails to log in to Basic Auth and redirect correctly with the endpoint
    When he successfully logs in to Basic Auth UI
    Then he can click on the footer Elemental Selenium

  @Smoke
  Scenario: Broken Images: Find any broken images in the page
    When he verifies link is working for Broken Images
    When he finds that there are 2 total broken images on the page
    Then he can click on the footer Elemental Selenium

  @Smoke
  Scenario: Challenging DOM: Find any broken images in the page
    When he verifies link is working for Challenging DOM
    When he can successfully click on the BLUE DOM BUTTON

  @Smoke
  Scenario: Checkboxes: Check and Un-Check all boxes
    When he verifies link is working for Checkboxes
    When he can click to enable and disable checkbox 1
    When he can click to disable and enable checkbox 2
    Then he can click on the footer Elemental Selenium