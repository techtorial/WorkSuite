package stepdefinitions.apisteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiLoginSteps {
    private Response response;
    private RequestSpecification request;
    private String bearerToken;
    private String endpoint;

    @Given("User has API endpoint {string}")
    public void user_has_api_endpoint(String endpoint) {
        RestAssured.baseURI = endpoint;
        request = RestAssured.given().header("X-Requested-With", "XMLHttpRequest");
    }
    @When("User sends a POST request with the following details:")
    public void user_sends_a_post_request_with_the_following_details(DataTable dataTable) {
        // Convert the DataTable to a List of Maps
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);


        // Iterate through the List of Maps and add form parameters
        for (Map<String, String> row : data) {
            request.formParam("email",row.get("email")).formParam("password",row.get("password"));
        }

        response = request.post();
    }

    @When("User sends a GET request with the following details:")
    public void user_sends_a_get_request_with_the_following_details(DataTable dataTable) {
        // Convert the DataTable to a List of Maps
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Iterate through the List of Maps and add form parameters
        for (Map<String, String> row : data) {
            request.formParam("email",row.get("email")).formParam("password",row.get("password"));
        }
        response = request.get();
    }
    @Then("The API should respond with status code {int}")
    public void the_api_should_respond_with_status_code(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Actual code: "+actualStatusCode);
        Assert.assertTrue(actualStatusCode==expectedStatusCode);
    }
    @Then("The response should contain {string}")
    public void the_response_should_contain(String expectedText) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue("Response body does not contain the expected text", responseBody.contains(expectedText));

    }
    @Then("The response {string} should be {string}")
    public void the_response_should_be(String path, String expected) {
        String actual =response.jsonPath().getString(path);
        Assert.assertEquals(expected,actual);
    }

    @And("User sets login authorization token {string}")
    public void userSetsLoginToken(String path) {
        bearerToken = response.jsonPath().getString(path);
    }
    @Then("User sets valid Bearer token")
    public void setValidBearerToken() {
        request.header("Authorization:", "Bearer "+bearerToken);
    }
    @Then("User sets Content-type as JSON")
    public void userSetsContentTypeAsJSON() {
        request.contentType(ContentType.JSON);
    }
    @And("User sets Content-type as {string}")
    public void userSetsContentTypeAs(String contentType) {
        request.contentType(contentType);
    }
    @When("User makes a GET request")
    public void user_makes_a_GET_request() {
        response = request.get();
    }
    @And("User sets endpoint {string}")
    public void userSetsEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}