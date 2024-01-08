Feature: Verify Company Name API Testing

  Scenario: Verify Company Name
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password              |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200
    Then a GET request is made to "https://techtorialwork.com/worksuit/public/api/v1/auth/login" endpoint
    Then the API response is received
    And the company name in the response is "techtorial"