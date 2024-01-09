package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public void login(String email, String password){

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submitButton.click();

    }
}
