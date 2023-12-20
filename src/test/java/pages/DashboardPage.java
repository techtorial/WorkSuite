package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DashboardPage {
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[contains(text(),'Week Timelogs')]")
    WebElement weeklyTimeLogs;

    @FindBy(xpath = "//h5[.='Tasks']")
    WebElement tasks;

    @FindBy(xpath = "//h5[contains(text(),'Projects')]")
    WebElement projects;

    @FindBy(xpath = "//h4[contains(text(),'Shift Schedule')]")
    WebElement workSchedule; //shift schedule

    public void validateFeatures(String expectedWeeklyTimeLogs, String expectedTasks, String expectedProjects, String expectedWorkSchedule) {
        Assert.assertTrue(BrowserUtils.getText(weeklyTimeLogs).contains(expectedWeeklyTimeLogs));
        Assert.assertEquals(expectedTasks,BrowserUtils.getText(tasks));
        Assert.assertEquals(expectedProjects,BrowserUtils.getText(projects));
        Assert.assertEquals(expectedWorkSchedule,BrowserUtils.getText(workSchedule));

    }
}
