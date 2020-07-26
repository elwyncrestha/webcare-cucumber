Feature: View All Notifications
  This feature file checks the notification component to load all notifications.

  Scenario: Test notification component to view all notifications
    Given I am logged into the system for notification listing
    When I open notification component
    Then I should have notification list populated
