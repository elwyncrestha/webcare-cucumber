Feature: Doctor List
  This feature file checks whether the doctor component loads the data or not.

  Scenario: Test doctor list pagination counts
    Given I am logged into the system for doctor listing
    When I open doctor component
    Then I should have doctor list populated
