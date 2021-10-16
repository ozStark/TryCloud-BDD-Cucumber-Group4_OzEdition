Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user is on login page
    And user provides valid credentials
    When user clicks on Contacts module


  @us12
  Scenario: AC#1 - verify users can access to Talks module

    Then user verifies the page title is Contents module's title


  @us12
  Scenario: AC#2 - verify user can add contacts

    And user clicks on New Contact button
    When user fills out the contact info like: Title, Phone, email, address, etc
    Then user verifies the contact name is added to the contact list