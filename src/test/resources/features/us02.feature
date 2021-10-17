Feature: As a user, I should be access all the main modules of the app.

  Scenario Outline: Verify modules

    Given user is on the login page
    When user enter valid "<username>" and "<password>"
    And user click login button
    Then Verify user launched to the dashboard
    Then Verify the user sees the following modules
    #Then Verify the user sees the following modules
      #| modules   |
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Calendar  |
      | Deck      |
    Then TEST user logs out

    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |



