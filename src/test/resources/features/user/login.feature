Feature: User Login
  This feature file checks the user authentication via login form.

  Scenario: Test invalid login
    Given I am in a login page
    When I enter invalid login credentials
    Then I should not be logged into the application

  Scenario: Test valid login
    Given I am in a login page
    When I enter valid login credentials
    Then I should be logged into the application
