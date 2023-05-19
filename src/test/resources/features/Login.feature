Feature: Verify that login feature working as expected

  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login incorrect password
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "teststudent"
    And I submit
    Then I am not logged in