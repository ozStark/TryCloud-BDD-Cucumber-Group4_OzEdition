@test
  Feature: As a user, I should be able to access to Files module.

    Background:
      Given user is on the login page


    Scenario Outline:
      And user enter valid "<username>" and "<password>"
      And user click login button
      And Verify user launched to the dashboard
      When user clicks any file on the page
      And clicks action icon
      And clicks "Details" from the action dropdown
      And clicks "Comments" from the details menu
      And enters "comment" in the box
      And clicks submit button
      Then verify the message is displayed

      Examples:
        | username | password    |
        | User3    | Userpass123 |
        | User33   | Userpass123 |
        | User63   | Userpass123 |
        | User93   | Userpass123 |
