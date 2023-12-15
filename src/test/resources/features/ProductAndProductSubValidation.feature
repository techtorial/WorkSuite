Feature: Validation Product And Product Sub Category

  Scenario: User login with correct credentials and validates Product and Product sub categories
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    And the user clicks the Products from menu option
    And the user selects product category Lifting and Material Handling Equipment
    And the user selects the sub Category: Mobile Cranes
    And the user clicks three dots for the first product and clicks view button
    And the user verifies that product "Lifting and Material Handling Equipment"
    Then the user verifies "Mobile Cranes"

