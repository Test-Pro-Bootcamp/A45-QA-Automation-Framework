Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "daria.pavlyuk@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    And I am logged in

