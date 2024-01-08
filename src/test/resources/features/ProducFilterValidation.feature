Feature: Validate filter for product

  Scenario: The user login with correct credentials and validate product filter functionality
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    Then the user clicks the "Products" from menu option
    And the user select product category "Lifting and Material Handling Equipment"
    And the user select sub category "Mobile Cranes"
    And the user click action button and select "View" from the option
    Then the user verify product Category "Lifting and Material Handling Equipment" and Product Sub Category "Mobile Cranes" is matching selection