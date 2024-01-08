Feature: Login User with Incorrect Email and Password Test

  Scenario: Login test with incorrect credentials
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user validate the title "techtorial"
    Then verify "Log In" is visible on the page
    Then the user enter email "dev_techtorial@example.com" password "12345678910"
    And verify error message "These credentials do not match our records." in red