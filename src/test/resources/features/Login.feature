Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I enter email "asdASD@mail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in