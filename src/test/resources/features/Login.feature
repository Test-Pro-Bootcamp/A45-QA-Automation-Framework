Feature: Login feature
  Scenario: Login Success
   Given I open login page
    When I enter email "pavel.furnic@testpro.io"
    And I enter password "Test123456789@"
    And I submit
    Then I am logged in