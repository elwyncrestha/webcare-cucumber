Feature: Online Feedback
  This feature file checks the feedback component to add a new feedback.

  Scenario: Test feedback component to add a new feedback
    Given I am in the login page for the feedback
    When I click the get feedback button
    And I enter feedback details
    Then I should have feedback submitted and redirected to login page
