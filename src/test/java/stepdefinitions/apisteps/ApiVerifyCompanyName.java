package stepdefinitions.apisteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiVerifyCompanyName {

    private Response response;
    private RequestSpecification request;

    @Then("a GET request is made to {string} endpoint")
    public void makeGetRequest(String endpoint) {
        RestAssured.baseURI = endpoint;
        request = RestAssured.given().header("X-Requested-With", "XMLHttpRequest");
        //response = (Response) RestAssured.get(baseUrl + endpoint);
        response=request.get();
        System.out.println(response);
    }

    @Then("the API response is received")
    public void verifyApiResponse() {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
    }

    @Then("the company name in the response is {string}")
    public void verifyCompanyName(String expectedCompanyName) {
        String actualCompanyName=response.jsonPath().getString("data.user.company.company_name");
        Assert.assertEquals(expectedCompanyName, actualCompanyName);
    }

}
