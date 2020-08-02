Feature: Online Help Desk Query
  This feature file checks the help desk component to add a new query.

  Scenario: Test help desk component to add a new query
    Given I am in the login page
    When I click the get help button
    And I enter help desk query details
    Then I should have query requested and redirected to login page
