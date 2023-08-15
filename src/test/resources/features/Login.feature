Feature: Login feature

  Scenario: Login Success
    Given I open Login page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

    Scenario: Login incorrect password
      Given  I open Login Page
      When I enter email "demo@class.com"
      And I enter password "123@"
      And I submit
      Then I am logged out

    Scenario:  Login Not existing email
        Given I open Login Page
        When I enter email "not_existing_email$.com"
        And I enter password "te$t$tudent"
        And I submit
        Then I am logged out

    Scenario:  Empty Login and Password
        Given I open Login Page
        When I enter email ""
        And I enter password ""
        And I submit
        Then I am logged out




