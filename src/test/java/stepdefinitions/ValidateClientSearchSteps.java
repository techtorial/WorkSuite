package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ClientPage;
import utils.DriverHelper;

public class ValidateClientSearchSteps {

    WebDriver driver = DriverHelper.getDriver();
    ClientPage clientPage = new ClientPage(driver);

    @Then("the user clicks Clients on the left side of the page")
    public void the_user_clicks_clients_on_the_left_side_of_the_page() throws InterruptedException {
        clientPage.clickClientsButton();
    }

    @Then("get the initial number of clients")
    public void get_the_initial_number_of_clients() throws InterruptedException {
        clientPage.countInitialClients();
    }
    @When("the user enters {string} in the search box")
    public void the_user_enters_in_the_search_box(String searchText) throws InterruptedException {
        clientPage.enterTextInSearchBox(searchText);
    }

    @Then("the user validates all names in the search result contain {string}")
    public void the_user_validates_all_names_in_the_search_result(String searchText) throws InterruptedException {
        clientPage.verifyName(searchText);
    }

    @Then("the user validates all emails in the search result contain {string}")
    public void the_user_validates_all_emails_in_the_search_result(String searchText) throws InterruptedException {
        clientPage.verifyEmail(searchText);
    }

    @Then("the user deletes text in search box")
    public void the_user_deletes_text_in_search_box() throws InterruptedException {
        clientPage.clearSearchBox();
    }

    @Then("the user verifies default list is displayed")
    public void the_user_verifies_default_list_is_displayed() throws InterruptedException {
        clientPage.verifyDefaultClients();
    }
}
