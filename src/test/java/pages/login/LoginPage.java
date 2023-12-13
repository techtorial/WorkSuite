package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="submit-login")
    WebElement submitButton;

    public void login(String email, String password){

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submitButton.click();
    }

}
