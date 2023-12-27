Feature: Product and Sub Product validation



Scenario: Login with correct credentials and test functionality of add product
  When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
  Then the user enter email "dev_techtorial@example.com" password "123456789"
  Then the user clicks the "Products" from menu option
  And  user click "AddProduct" button
  And user click add new category button
  And the user enter "Hauling Equipment"
  And the user clicks "Save"
  And the user verifies category "Hauling Equipment" added
  And the user click add new category button
  And the user verifies new category Hauling Equipment showing on the category list
  And the user selects "Hauling Equipment" as category
  And the user click add button for the product Sub Category
  And the user enter Sub Category Name: "Standard Dump Trucks"
  And the user clicks "Save"
  Then the user verifies Sub Category is displayed on product page and after clicking add button



























