Feature:
Background: chrome testing
  Given user test with "chrome" browser

  @smokes
  @regression_test
  Scenario: Testing autotrader.com
    Given user is in landing page
    Then Verify that "Browser By Make" are present
    Then Verify that "Browser By Style" are present
    Then Verify that "Advence Search" are present
    And Verify that search button is present
    Then Verify that "Any Make" and "Any Model" is visible

  @integration_test
  Scenario: Entering the Advance serch link
    Given User click Advance link on  the home page
    Then  User enter "30004" in the zip code text box
    Then  User select "Certified" check box under "Condition"
    Then  User select "Convertable" check box under "Style"
    Then  User update year "2017" to "2020"
    Then  User select "BMW" car from Make, Model and Trim
    Then  User clicks Search Button
    Then  User verify that he is in result page
    Then  User verify that he sees only "BMW" cars in listing
    Then  Display in console, the number of cars


  Scenario Outline: testing multiple entry
    Given choose make as "<model>"
    Examples:
      |model   |
      |BMW     |
      |Audi    |
      |Mercedes|
      |Toyota  |
      |Acura   |

