package stepdefinitions.apisteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiLoginSteps {
    private Response response;
    private RequestSpecification request;

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
    @Then("The API should respond with status code {int}")
    public void the_api_should_respond_with_status_code(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
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

}
