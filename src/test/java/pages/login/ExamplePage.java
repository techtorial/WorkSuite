package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamplePage {

    // ExamplePage should be inside this class with initelements methods bc without initelements method, my elements will not be instantiated.
    public ExamplePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "xxxx")
    List<WebElement> clients;

}
