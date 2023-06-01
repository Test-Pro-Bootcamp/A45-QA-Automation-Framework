Feature: Login feature

  Scenario: Login success
    Given You open login page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am login in