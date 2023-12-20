Feature: Validate Client Search Functionality

  Scenario: Login with correct credentials and add validate client search functionality
    When the user navigates to the "https://techtorialwork.com/worksuit/public/login"
    Then the user enter email "dev_techtorial@example.com" password "123456789"
    # And the user clicks Clients on the left side of the page
    And the user clicks main menu "Clients"
    Then get the initial number of clients
    When the user enters "ad" in the search box
    Then the user validates all names in the search result contain "ad"
    Then the user deletes text in search box
    When the user enters "gmail" in the search box
    Then the user validates all emails in the search result contain "gmail"
    Then the user deletes text in search box
    Then the user verifies default list is displayed