Feature: User Authentication
  This feature file checks the user authentication by trying to open dashboard without authenticating.

  Scenario: Test unauthenticated action to open the dashboard
    Given I am not authenticated
    When I am opening dashboard using direct url
    Then I should be redirected to login for authentication
