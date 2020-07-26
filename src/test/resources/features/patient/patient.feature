Feature: Patient List
  This feature file checks whether the patient component loads the data or not.

  Scenario: Test patient list pagination counts
    Given I am logged into the system for patient listing
    When I open patient component
    Then I should have patient list populated
