Feature: Dashboard Test

  Scenario: Verify Dashboard after login
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    Then the user validate the title "Dashboard"
    Then the user navigates to the main dashboard and sees details like "Week Timelogs","Tasks","Projects","Shift Schedule"




