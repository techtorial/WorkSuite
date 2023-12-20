Feature: Home Menu

  Scenario: the user clicks main menu
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    Then the user validate the title "Dashboard"
    Then the user clicks main menu "Clients"
    Then the user clicks main menu "Products"
    Then the user clicks main menu "Events"