Feature: Verify Product Price API Testing

  Scenario: Verify Product Price in API response
    Given User has API endpoint "https://techtorialwork.com/worksuit/public/api/v1/auth/login"
    When User sends a POST request with the following details:
      | email                             |   password             |
      | dev_techtorial@example.com        |   123456789            |
    Then The API should respond with status code 200
    And User sets login authorization token "data.token"
    And User sets endpoint "https://techtorialwork.com/worksuit/public/api/v1/product/7"
    And User sets parameter name "fields"
    And User sets parameter value "price"
    Given User has API endpoint
    And User sets valid Bearer token
    And User sets Content-type as JSON
    When User makes a GET request
    Then The API should respond with status code 200
    And The response "data.id" should be "7"
    And The response "data.price" should be "78000"