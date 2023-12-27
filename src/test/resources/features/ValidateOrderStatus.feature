Feature: Validate Status for Orders Functionality

  Scenario: Login with correct credentials and add validate client search functionality
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks main menu "Orders"
    Then the user clicks Add New Order button
    When the user clicks Status button
    #Then the user validates the Status options "Pending On Hold Failed Processing Completed Canceled"
    Then the user validates the Status options by map
      |Status1 | Status2 | Status3 | Status4    | Status5   | Status6
      |Pending | On Hold | Failed  | Processing | Completed | Canceled