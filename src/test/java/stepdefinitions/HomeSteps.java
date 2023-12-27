package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverHelper;

public class HomeSteps {
    WebDriver driver= DriverHelper.getDriver();
    HomePage homePage=new HomePage(driver);

    @Then("the user clicks main menu {string}")
    public void the_user_clicks_main_menu(String buttonName) {
        homePage.clickMainMenu(buttonName);
    }

}
