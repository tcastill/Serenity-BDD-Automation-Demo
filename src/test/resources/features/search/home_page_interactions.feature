Feature: Home Page Verifications

  Background: Test Sernity BDD with herokuapp page
    Given Edward goes to herokuapp and checks the page

  @Smoke
  Scenario: A/B Testing functionality
    When he verifies link is working for AB Testing
    Then he can click on the footer Elemental Selenium

  @Smoke
  Scenario: Add/Remove Elements
    When he verifies link is working for Add Remove Elements
    When he is able to add 10 multiple elements and then delete them all
    Then he can click on the footer Elemental Selenium
