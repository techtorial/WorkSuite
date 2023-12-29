Feature: Authentication API Testing

  Scenario: Authenticate and obtain access token
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password              |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200
    And The response should contain "Logged in successfully"
    And The response "data.user.name" should be "dev_techtorial"


  Scenario: Unsuccesfull login test
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password              |
      | dev_techtorial@example.com        |   12345678            |
    Then The API should respond with status code 403
    And The response should contain "Wrong credentials provided"
    And The response "error.innererror.code" should be "2001"