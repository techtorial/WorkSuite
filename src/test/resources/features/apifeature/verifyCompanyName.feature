Feature: Verify Company Name API Testing

  Scenario: Verify Company Name
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/app" execute
    When User sends a GET request with the following details:
      | email                             |   password             |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200 execute
    And The response "data.company_name" should be "techtorial" execute
