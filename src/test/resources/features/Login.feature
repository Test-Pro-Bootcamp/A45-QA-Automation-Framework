Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login page
    When I enter email "heavenmayhem@gmail.com"
    And  I enter password "Everything2Me0628!"
    And I submit
    Then I am logged in