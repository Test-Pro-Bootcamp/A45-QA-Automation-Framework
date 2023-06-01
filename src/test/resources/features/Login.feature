Feature: Login feature

  Scenario: Login success
    Given You open browser
    And I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am login in