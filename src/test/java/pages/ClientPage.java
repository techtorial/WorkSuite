package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;


import javax.naming.Name;
import java.util.*;
import java.util.logging.XMLFormatter;

public class ClientPage {

    public ClientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    int defaultClientsCount;
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


    @FindBy(xpath = "(//h5)[1]")
    WebElement firstClientName;
  
    @FindBy(xpath = "//input[@id='search-text-field']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@id='reset-filters']")
    WebElement clearButton;

    @FindBy(xpath = "//td[4]")
    List<WebElement> allEmails;

    @FindBy(xpath = "//tr")
    List<WebElement> clients;
    @FindBy(xpath = "//button[@data-id='quick-action-type']")
    WebElement actionButton;

    @FindBy(xpath = "/html/body/div[1]/section/div[4]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]/input")
    WebElement checkBox;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    WebElement deleteFromOption;

    @FindBy(xpath = "//button[@id='quick-action-apply']")
    WebElement applyButton;

    @FindBy(xpath = "//button[contains(text(),'Yes, delete')]")
    WebElement deleteConfirmationButton;


    public void clickClientsButton() throws InterruptedException {
        clientsButton.click();
        Thread.sleep(2000);
    }

    public void countInitialClients() {
        defaultClientsCount = clients.size();
        //System.out.println("Clients: "+defaultClientsCount);
    }

    @FindBy(xpath = "//li[@class=\"accordionItem closeIt\"]/a/span")
    List<WebElement> homeMenuButton;

    @FindBy(xpath = "//*[@id=\"table-actions\"]")
    WebElement clientsOptions;

    @FindBy(xpath = "//td[2]")
    List<WebElement> idSorting;

    @FindBy(xpath = "//th[@class=\"sorting_asc\"]")
    WebElement upArrow;

    //@FindBy(xpath = "//thead/tr/th[2]")
    @FindBy(xpath = "//th[contains(text(),'Id')]")
    WebElement downArrow;

    public void addClient(String clientOptions){
        addClientButton.click();
        if (clientsOptions.getText().equals(clientOptions)){
            clientsOptions.click();
        }
    }


    public void userInformation(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> userDataMap : userData) {
            Thread.sleep(2000);
            clientName.sendKeys(userDataMap.get("Name"));
            emailAddress.sendKeys(userDataMap.get("Email"));
            phoneNumber.sendKeys(userDataMap.get("Phone number"));

        }

    }

    public void countrySelection() throws InterruptedException {
        country.click();
        countrySearchBar.click();
        countrySearchBar.sendKeys("United States");
        countrySearchBar.sendKeys(Keys.ENTER);

    }

    public void companyInformation(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> companyData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> companyDataMap : companyData) {
            companyName.sendKeys(companyDataMap.get("Company name"));
            companyWebsite.sendKeys(companyDataMap.get("Website"));
            companyPhone.sendKeys(companyDataMap.get("Telephone number"));
            companyAddress.sendKeys(companyDataMap.get("Address"));
            shippingAddress.sendKeys(companyDataMap.get("Shipping address"));
        }
    }

    public void clickingSaveButton() throws InterruptedException {
        saveButton.click();
        Thread.sleep(2000);
    }


    public void validationOfNewClient(String expectedName) {

    String actualName=BrowserUtils.getText(firstClientName);

           Assert.assertTrue("Client name is not matching", expectedName.equals(actualName));

    }

    public void removingClientFromTheList() throws InterruptedException {
        checkBox.click();
        actionButton.click();
        Thread.sleep(2000);
        deleteFromOption.click();
        applyButton.click();
        Thread.sleep(2000);
        deleteConfirmationButton.click();
    }

    public void enterTextInSearchBox(String searchText) {
        searchBox.sendKeys(searchText);
    }

    public void verifyName(String searchText) throws InterruptedException {
        Thread.sleep(2000);
        List<String> expectedInformation = Arrays.asList(searchText);
        for (int i = 0; i < allClients.size(); i++) {
            //System.out.println(BrowserUtils.getText(allClients.get(i)));
            Thread.sleep(2000);
            Assert.assertTrue(BrowserUtils.getText(allClients.get(i)), expectedInformation.contains(searchText));

        }
    }

    public void verifyEmail(String searchText) throws InterruptedException {
        Thread.sleep(2000);
        List<String> expectedInformation = Arrays.asList(searchText);
        for (int i = 0; i < allEmails.size(); i++) {
            //System.out.println(BrowserUtils.getText(allEmails.get(i)));
            Thread.sleep(2000);
            Assert.assertTrue(BrowserUtils.getText(allEmails.get(i)), expectedInformation.contains(searchText));
        }
    }

    public void clearSearchBox() {
        clearButton.click();
    }

    public void verifyDefaultClients() {
        assert clients.size() == defaultClientsCount : "Expected: " + defaultClientsCount + "  " + clients.size();
    }

    public void clickUpDownArrow() throws InterruptedException {
        downArrow.findElement(By.className("sorting_asc"));
        System.out.println(downArrow.getText());
    }

    public void validateIdAscOrder() throws InterruptedException {
        Thread.sleep(2000);
        Boolean condition;
        for (int i = 0; i < idSorting.size()-1; i++) {
            //System.out.println(BrowserUtils.getText(idSorting.get(i)));
            condition = Integer.parseInt(BrowserUtils.getText(idSorting.get(i))) >Integer.parseInt(BrowserUtils.getText(idSorting.get(i+1)));
            Assert.assertTrue(condition);
        }
    }
}



