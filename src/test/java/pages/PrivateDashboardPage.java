package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;


import java.util.ArrayList;
import java.util.List;

public class PrivateDashboardPage {

    public PrivateDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"view-shifts\"]")
    WebElement employeeShiftButton;

    @FindBy(xpath = "//*[@id=\"example\"]/tbody/tr/td[5]/div/a")
    WebElement editButton;

    @FindBy(xpath = "//*[@id=\"shift_name\"]")
    WebElement shiftName;

    @FindBy(xpath = "//*[@id=\"open_6\"]")
    WebElement saturdayCheckbox;

    @FindBy(xpath = "//*[@id=\"open_0\"]")
    WebElement sundayCheckbox;

    @FindBy(xpath = "//*[@id=\"myModalXl\"]/div/div/div[3]/a")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"save-employee-shift\"]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"example\"]/tbody/tr/td[1]/span")
    WebElement shiftNameInEmployeeShiftSection;

    @FindBy(xpath = "//*[@id=\"example\"]/tbody/tr/td[3]/div[3]")
    WebElement officeOpenDaysInformation;


    public void clickEmployeeShiftButton() throws InterruptedException {
        employeeShiftButton.click();
        Thread.sleep(2000);
    }

    public void clickEditButton() throws InterruptedException {
        editButton.click();
        Thread.sleep(2000);

    }

    public void shiftName(String name) {
        shiftName.clear();
        shiftName.sendKeys(name);
    }

    public void workdays() {
        if (saturdayCheckbox.isSelected()) {
            saturdayCheckbox.click();
        }

        if (sundayCheckbox.isSelected()) {
            sundayCheckbox.click();
        }
        if (sundayCheckbox.isSelected()) {

        }


    }

    public void saveChanges(String button) throws InterruptedException {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(cancelButton);
        webElementList.add(saveButton);
        for (WebElement option : webElementList) {
            if (option.getText().equals(button)) {
                option.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public void verifiesChangesOnEmployeeShift(String expectedShiftName) throws InterruptedException {
        employeeShiftButton.click();
        Thread.sleep(2000);

        String actualShiftName = BrowserUtils.getText(shiftNameInEmployeeShiftSection);
        Assert.assertTrue("Shift Name is not matching", expectedShiftName.equals(actualShiftName));

    }

    public void verifiesWorkDays(String expectedDays) {
        String actualDays = BrowserUtils.getText(officeOpenDaysInformation);
        Assert.assertTrue("Office working days is not matching", expectedDays.equals(actualDays));
    }


}
