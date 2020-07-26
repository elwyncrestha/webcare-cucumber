Feature: Doctor List Filter
  This feature file checks whether the doctor component filter filters the data or not.

  Scenario: Test doctor list pagination filter
    Given I am logged into the system for doctor filtering
    When I open initial doctor component
    And I filter doctor by name
    Then I should have a doctor list filtered
