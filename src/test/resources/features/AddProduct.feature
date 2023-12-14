Feature: addProduct

  Scenario: Login with correct credentials and add new product
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    Then the user clicks the Products from menu option and AddProduct button
    And the user enter "Truck-Mounted Crane" price "15000"
    Then the user select product from the product category, product Sub category, tax, and select client can purschase
    And user add product description for the product
   # And user upload picture of the product
    And then user clicks save button
    Then user validates the product name on the page

