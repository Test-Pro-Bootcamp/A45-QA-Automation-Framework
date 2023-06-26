Feature: Login Success

  Given I open login page
  When I enter my email
  And I enter my password
  And I hit submit
  Then I am logged in
