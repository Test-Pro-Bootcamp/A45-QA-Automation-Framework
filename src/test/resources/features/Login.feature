Feature: Verify the login feature is working as expected

  Scenario: Login Success
    Given Open Login Page
    When  Enter email "andrei.bryliakov@testpro.io"
    And Enter password "te$t$tudent1"
    And Click submit
    Then User is logged in