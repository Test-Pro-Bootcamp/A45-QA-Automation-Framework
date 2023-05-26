Feature: Login Feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "kcroker@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in