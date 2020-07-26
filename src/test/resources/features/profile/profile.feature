Feature: User Profile
  This feature file checks the user profile.

  Scenario: Test if user profile component loads or not.
    Given I am logged in
    When I open user profile
    Then I should find profile component being loaded
