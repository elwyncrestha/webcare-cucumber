Feature: Department List
  This feature file checks whether the department component loads the data or not.

  Scenario: Test department list pagination counts
    Given I am logged into the system for department listing
    When I open department component
    Then I should have department list populated
