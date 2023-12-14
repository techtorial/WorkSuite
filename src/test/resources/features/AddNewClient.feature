Feature: add New Client

  Scenario: Login with correct credentials and add new client
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks Clients and add client button
    And the user enters personal information:  "John Doe", "john.doe@example.com", "5551234567"
    And the user select country
    And the user enters company information:"Doe Construction Inc", "http://www.doeconstruction.com", "(555) 001-2345" "456 Oak Avenue, Springfield, IL, 62701", "789 Birch Lane, Springfield, IL, 62702";
    And the user clicks save button
    Then user verify new client was created