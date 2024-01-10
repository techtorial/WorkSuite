Feature: Verify Company Information API Testing

  Scenario: Verify Company Information in API response
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password             |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200
    And User sets login authorization token "data.token"
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/company"
    And User sets valid Bearer token
    And User sets Content-type as JSON
    When User makes a GET request
    Then The API should respond with status code 200
    And The response "data.company_phone" should be "1234567891"
