Feature: Verify Product Information API Testing

  Scenario: Verify Product Information in API response
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password             |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200
    And User sets endpoint "/product"
    And User sets login authorization token "data.token"
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/product"
    And User sets valid Bearer token
    And User sets Content-type as "application/x-www-form-urlencoded"
    When User makes a GET request
    Then The API should respond with status code 200
    And The response "data.id[0]" should be "5"
    And The response "data.name[0]" should be "Rear Discharge Concrete Mixer"
