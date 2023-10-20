Feature: Checkout Item
  @CheckoutItem @Positive
  Scenario: User can check out item that already added to cart
    Given User open browser
    And user open website login page
    And user input the valid username
    And user input the valid password
    When user clicked the login button
    Then user get redirected to dashboard page
    When user see item in dashboard page
    And user click add to cart button in each item
    Then user will see cart logo with number in it indicating item has been added
    When user click the cart button
    Then user will redirected to your cart page
    And user will see item QTY and item description that already been added before
    When user click checkout button
    Then user will redirected to Checkout information page
    And user input firstname
    And user input lastname
    And user input zip code
    When user click continue button
    Then user will see detail item
    And user will see detail payment information
    When user click finish button
    Then user will redirected to Checkout complete page
    And user will see success message

