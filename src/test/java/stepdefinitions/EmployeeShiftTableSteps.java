package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PrivateDashboardPage;
import utils.DriverHelper;

public class EmployeeShiftTableSteps {

    WebDriver driver = DriverHelper.getDriver();
    PrivateDashboardPage privateDashboardPage = new PrivateDashboardPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("the user clicks the {string}")
    public void the_user_clicks_the(String subCategoryButton) {
        homePage.clickDashboardSubCategory(subCategoryButton);
    }

    @Then("the user click Employee Shift Button")
    public void the_user_click_employee_shift_button() throws InterruptedException {
        privateDashboardPage.clickEmployeeShiftButton();
    }

    @Then("the user clicks Edit button")
    public void the_user_clicks_edit_button() throws InterruptedException {
        privateDashboardPage.clickEditButton();
    }

    @Then("the user change Shift Name to {string}")
    public void the_user_change_shift_name_to(String name) {
        privateDashboardPage.shiftName(name);
    }

    @Then("the user select only weekdays")
    public void the_user_select_only_weekdays() {
        privateDashboardPage.workdays();
    }

    @Then("the user clicks {string} button")
    public void the_user_clicks_button(String buttonName) throws InterruptedException {
        privateDashboardPage.saveChanges(buttonName);
    }


    @Then("the user verifies name is changed to {string}")
    public void the_user_verifies_name_is_changed_to(String shiftName) throws InterruptedException {
        privateDashboardPage.verifiesChangesOnEmployeeShift(shiftName);
    }


    @Then("the user verifies after click Employee Shift button you can see text {string}")
    public void the_user_verifies_after_click_employee_shift_button_you_can_see_text(String schedule) {
        privateDashboardPage.verifiesWorkDays(schedule);
    }
}
