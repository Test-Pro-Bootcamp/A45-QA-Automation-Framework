Feature: Login feature
  Scenario: Login Success
    Given I open login page
    When I enter email "esther.martinez32@gmail.com"
    And I enter password "Proverbs99"
    And I submit
    Then I am logged in

    Scenario: Login Failure
      Given I open login page
      When I enter email "notreal@email.com"
      And I enter password "blah"
      And I submit
      Then I am not logged in
