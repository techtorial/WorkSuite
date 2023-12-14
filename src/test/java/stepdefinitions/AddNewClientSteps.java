package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ClientPage;
import utils.DriverHelper;

public class AddNewClientSteps {

    WebDriver driver = DriverHelper.getDriver();
    ClientPage clientPage = new ClientPage(driver);

    @Then("the user clicks Clients and add client button")
    public void the_user_clicks_clients_and_add_client_button() throws InterruptedException {
        clientPage.clickClientsButtonAndAddClient();
    }

    @Then("the user enters personal information:  {string}, {string}, {string}")
    public void the_user_enters_personal_information(String name, String email, String phone) throws InterruptedException {
        clientPage.clientInformation(name, email, phone);
    }

    @Then("the user select country")
    public void the_user_select_country() throws InterruptedException {
        clientPage.countrySelection();
    }


    @Then("the user enters company information:{string}, {string}, {string} {string}, {string};")
    public void the_user_enters_company_information(String companyName, String companyWebsite, String companyPhone, String companyAddress, String shippingAddress) {
        clientPage.companyInformation(companyName, companyWebsite, companyPhone, companyAddress, shippingAddress);
    }


    @Then("the user clicks save button")
    public void the_user_clicks_save_button() throws InterruptedException {
        clientPage.clickingSaveButton();
    }

    @Then("user verify new client was created")
    public void user_verify_new_client_was_created() throws InterruptedException {
        clientPage.clientName("John" + " " + "Doe");
    }
}
