package stepdefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.core.sym.Name;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ClientPage;
import pages.HomePage;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class AddNewClientSteps {

    WebDriver driver = DriverHelper.getDriver();
    ClientPage clientPage = new ClientPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("the user clicks {string} from main menu")
    public void the_user_clicks_from_main_menu(String buttonName) throws InterruptedException {
        homePage.clickMainMenu(buttonName);
    }

    @Then("user click {string} button")
    public void user_click_button(String addClient) {
        clientPage.addClient(addClient);
    }

    @Then("the user enters personal information by map")
    public void the_user_enters_personal_information_by_map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        clientPage.userInformation(dataTable);
    }


    @Then("the user select country")
    public void the_user_select_country() throws InterruptedException {
        clientPage.countrySelection();
    }


    @Then("the user enters company information by map")
    public void the_user_enters_company_information_by_map(io.cucumber.datatable.DataTable dataTable) {
        clientPage.companyInformation(dataTable);
    }


    @Then("the user clicks save button")
    public void the_user_clicks_save_button() throws InterruptedException {
        clientPage.clickingSaveButton();
    }

    @Then("user verify new client was created {string}")
    public void user_verify_new_client_was_created(String expectedName) {
        clientPage.validationOfNewClient(expectedName);
    }

    @Then("user delete created client after verification")
    public void user_delete_created_client_after_verification() throws InterruptedException {
        clientPage.removingClientFromTheList();
    }

}