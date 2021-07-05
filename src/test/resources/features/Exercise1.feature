Feature: Exercise 1 - Different Elements Page Test

  Scenario: Test of proper login information indication
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then Check that current user is 'Roman Iovlev'

  Scenario: Test web page Event log generation
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I open through the header menu Service -> Different Elements Page
    When I select checkboxes 'Water' and 'Wind'
    And I select radio 'Selen'
    And I select in dropdown menu 'Yellow' color
    Then For each checkbox there is an individual log row and value is corresponded to the status of checkbox
    And For radio button there is a log row and value is corresponded to the status of radio button
    And For dropdown there is a log row and value is corresponded to the selected value