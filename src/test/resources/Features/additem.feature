Feature: Add item to cart
  @AddCart @Positive
  Scenario: user add several item to cart
    Given user open the browser
    When user open website and see the login page
    Then user input the username
    And user input the password
    When user click the login button
    Then user will redirected to the dashboard page
    When user see several item in dashboard page
    And user click add to cart button
    Then user will see the cart logo with number of the item being added


