Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I enter email "asdASD@mail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login Wrong email
    Given I open login page
    When I enter email "asd@mail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am not logged in

  Scenario: Login Wrong password
    Given I open login page
    When I enter email "asdASD@mail.com"
    And I enter password "te$t$"
    Then I am not logged in

  Scenario: Login empty email and password
    Given I open login page
    When I enter email ""
    And I enter password ""
    Then I am not logged in