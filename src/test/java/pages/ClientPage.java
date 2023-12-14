package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ClientPage {

    public ClientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Clients']")
    WebElement clientsButton;

    @FindBy(xpath = "//*[@id=\"table-actions\"]/a[1]")
    WebElement addClientButton;

    @FindBy(xpath = "//input[@id='name']")
    WebElement clientName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id=\"save-client-data-form\"]/div/div[1]/div[1]/div/div[5]/div/div/button")
    WebElement country;

    @FindBy(xpath = "//*[@id=\"save-client-data-form\"]/div/div[1]/div[1]/div/div[5]/div/div/div/div[1]/input")
    WebElement countrySearchBar;

    @FindBy(xpath = "//input[@id='mobile']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='company_name']")
    WebElement companyName;

    @FindBy(xpath = "//input[@id='website']")
    WebElement companyWebsite;

    @FindBy(xpath = "//input[@id='office']")
    WebElement companyPhone;

    @FindBy(xpath = "//textarea[@id='address']")
    WebElement companyAddress;

    @FindBy(xpath = "//textarea[@id='shipping_address']")
    WebElement shippingAddress;

    @FindBy(xpath = "//button[@id='save-client-form']")
    WebElement saveButton;

    @FindBy(xpath = "//h5")
    List<WebElement> allClients;


    public void clickClientsButtonAndAddClient() throws InterruptedException {
        clientsButton.click();
        Thread.sleep(2000);
        addClientButton.click();
        Thread.sleep(2000);
    }

    public void clientInformation(String name, String email, String phone) throws InterruptedException {
        clientName.sendKeys(name);
        emailAddress.sendKeys(email);
        phoneNumber.sendKeys(phone);
    }

    public void countrySelection() throws InterruptedException {
        country.click();
        countrySearchBar.click();
        countrySearchBar.sendKeys("United States");
        countrySearchBar.sendKeys(Keys.ENTER);

    }

    public void companyInformation(String Name, String Website, String Phone, String Address, String ShippingAddress) {
        companyName.sendKeys(Name);
        companyWebsite.sendKeys(Website);
        companyPhone.sendKeys(Phone);
        companyAddress.sendKeys(Address);
        shippingAddress.sendKeys(ShippingAddress);

    }

    public void clickingSaveButton() throws InterruptedException {
        saveButton.click();
        Thread.sleep(2000);
    }

    public void clientName(String lastName) throws InterruptedException {
        Thread.sleep(2000);
        List<String> expectedInformation = Arrays.asList(lastName);
        for (int i = 0; i < allClients.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(BrowserUtils.getText(allClients.get(i)), expectedInformation.contains("John" + " " + "Doe"));

        }


    }


}
