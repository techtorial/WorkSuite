package stepdefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.core.sym.Name;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ClientPage;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class AddNewClientSteps {

    WebDriver driver = DriverHelper.getDriver();
    ClientPage clientPage = new ClientPage(driver);

    @Then("the user clicks Clients and add client button")
    public void the_user_clicks_clients_and_add_client_button() throws InterruptedException {
        clientPage.clickClientsButtonAndAddClient();
    }

    @Then("the user enters personal information by map")
    public void the_user_enters_personal_information_by_map(io.cucumber.datatable.DataTable dataTable) {
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

    @Then("user delete created cli1ent after verification")
    public void user_delete_created_cli1ent_after_verification() throws InterruptedException {
        clientPage.removingClientFromTheList();
    }

}