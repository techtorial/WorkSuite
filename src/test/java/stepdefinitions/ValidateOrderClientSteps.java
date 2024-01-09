package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ClientPage;
import utils.DriverHelper;

public class ValidateOrderClientSteps {
    WebDriver driver = DriverHelper.getDriver();
    ClientPage clientPage = new ClientPage(driver);

    @When("the user clicks Up and Down arrow next to the ID on Client list")
    public void the_user_clicks_Up_and_Down_arrow_next_to_the_ID_on_Client_list() throws InterruptedException {
        clientPage.clickUpDownArrow();
    }

    @Then("Validate all IDs are listed in ascending order")
    public void validateAllIDsAreListedInAscendingOrder() throws InterruptedException {
        clientPage.validateIdAscOrder();
    }
}
