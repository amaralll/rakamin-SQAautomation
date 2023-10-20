Feature: Login
  @Login @Positive
  Scenario: User login with valid credential
    Given user open browser
    And user open the website
    And user input username
    And user input password
    When user tap the login button
    Then user will redirected to dashboard page

    @Login @Negative
    Scenario: User with invalid credential
      Given user open browser
      And user open the website
      And user input username
      And user input invalid password
      When user tap the login button
      Then user will see error message