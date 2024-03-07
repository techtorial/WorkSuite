package pages.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement errorMessage;

    public void login(String email, String password){
        this.email.sendKeys(ConfigReader.readProperty("employee_username"));
        this.password.sendKeys(ConfigReader.readProperty("employee_password"));
        submitButton.click();
    }

    public String getSubmitButtonText(){
        return BrowserUtils.getText(submitButton);
    }
    public void verifyButtonName(String buttonName) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(submitButton), buttonName);
    }
    public void verifyMessage(String message) {
        Assert.assertEquals(BrowserUtils.getText(errorMessage), message);
        String color=errorMessage.getCssValue("color");
        color=color.replace("rgba(","");
        color=color.replace(")","");
        String[] RGBA=color.split(",");
        Assert.assertTrue(Integer.parseInt(RGBA[0])>210);
    }
}
