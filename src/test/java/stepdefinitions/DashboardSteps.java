package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utils.DriverHelper;

public class DashboardSteps {

    WebDriver driver = DriverHelper.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("the user navigates to the main dashboard and sees details like {string},{string},{string},{string}")
    public void the_user_navigates_to_the_main_dashboard_and_sees_details_like(String weekTimeLogs, String tasks, String projects, String workShedule) {
        dashboardPage.validateFeatures(weekTimeLogs,tasks,projects,workShedule);
    }
}
