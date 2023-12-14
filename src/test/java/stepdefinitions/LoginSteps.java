package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverHelper;

public class LoginSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("the user navigates to the {string}")
    public void the_user_navigates_to_the(String url) {
        driver.navigate().to(url);
    }

    @Then("the user enter email {string} password {string}")
    public void the_user_enter_email_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("the user validate the title {string}")
    public void the_user_validate_the_title(String title) {
        Assert.assertEquals(driver.getTitle(), title);

    }
}
