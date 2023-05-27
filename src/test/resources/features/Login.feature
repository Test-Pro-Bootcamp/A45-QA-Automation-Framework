Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "kristina.matskaylo@testpro.io"
    And I enter password "11111111*a"
    And I submit
    Then I am logged in