Feature: Update Employee Shift Table

  Scenario: Login with correct credentials and update employee shift table
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    Then the user clicks the "Dashboard" from menu option
    Then the user clicks the "Private Dashboard"
    Then the user click Employee Shift Button
    Then the user clicks Edit button
    And the user change Shift Name to "Company Shift Weekdays"
    And the user select only weekdays
    And the user clicks "Save" button
    And the user verifies name is changed to "Company Shift Weekdays"
    Then the user verifies after click Employee Shift button you can see text "Office opens on: Monday Tuesday Wednesday Thursday Friday"

























