package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ClientPage;
import pages.OrderPage;
import utils.DriverHelper;

public class ValidateOrderStatusSteps {
    WebDriver driver = DriverHelper.getDriver();
    OrderPage orderPage = new OrderPage(driver);

    @Then("the user clicks Add New Order button")
    public void the_user_clicks_Add_New_Order_button() throws InterruptedException {
        orderPage.clickAddOrderButtons();
    }

    @When("the user clicks Status button")
    public void the_user_clicks_Status_button() throws InterruptedException {
        orderPage.getStatus();
    }

    @Then("the user validates the Status options by map")
    public void the_user_validates_the_Status_options_by_map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        orderPage.verifyStatus(dataTable);
    }

}
