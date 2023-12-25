Feature: add New Client

  Scenario: Login with correct credentials and add new client
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks "Clients" from main menu
    And user click "Add Client" button
    And the user enters personal information by map
      | Name    | Email                | Phone number |
      | Joe Doe | john.doe@examples.com | 5551234567   |
    And the user select country
    And the user enters company information by map
      | Company name         | Website                       | Telephone number | Address                         | Shipping address                              |
      | Doe Construction Inc | http://www.deconstruction.com | (555) 001-2345   | 456 Oak Avenue, Springfield, IL | 62701 "789 Birch Lane, Springfield, IL, 62702 |
    And the user clicks save button
    Then user verify new client was created "Joe Doe"
    Then user delete created client after verification