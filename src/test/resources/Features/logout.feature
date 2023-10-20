Feature: Logout
  @Logout @Positive
  Scenario: user logout from website
    Given user open browser and login to website
    And user input valid username
    And user input valid password
    When user click login button
    Then user will redirected to dashboard page with menu button
    When user click menu button
    And user click logout button
    Then user will redirected to login page

    @Logout @Negative
      Scenario: user logout from website
      Given user open browser and login to website
      And user input valid username
      And user input valid password
      When user click login button
      Then user will redirected to dashboard page with menu button
      When user click menu button
      Then user close the browser