Feature: Validate Export on Order

  Scenario: Login with correct credentials and add validate order in Client page
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks main menu "Orders"
    When the user clicks Export button
    Then Validate Excel file "orders-2024" downloaded in "C:\\Users\\Cristina\\Downloads\\"