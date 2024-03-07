Feature: Login Test

  Scenario: Login test with correct credentials
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter cred
    Then the user validate the title "Dashboard"