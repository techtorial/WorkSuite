Feature: Validate Order in Client Page

  Scenario: Login with correct credentials and add validate order in Client page
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks main menu "Clients"
    When the user clicks Up and Down arrow next to the ID on Client list
    Then Validate all IDs are listed in ascending order