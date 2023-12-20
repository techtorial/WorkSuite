package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class ProductsPage {


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Products']")
    WebElement productsButton;

    @FindBy(xpath = "//*[@id=\"table-actions\"]/a")
    WebElement addProductButton;

    @FindBy(xpath = "//input[@id='name']")
    WebElement productName;

    @FindBy(xpath = "//input[@id='price']")
    WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"save-product-form\"]/div/div[1]/div/div/div[3]/div/div[1]/button")
    WebElement productCategorySelect;

    @FindBy(xpath = "//span[contains(text(),'Handling Equipment')]")
    WebElement productCategory;

    @FindBy(xpath = "//*[@id=\"save-product-form\"]/div/div[1]/div/div/div[4]/div/div[1]/button")
    WebElement productSubCategorySelect;

    @FindBy(xpath = "//*[@id=\"bs-select-7-1\"]")
    WebElement productSubCategory;

    @FindBy(xpath = "//*[@id=\"save-product-form\"]/div/div[1]/div/div/div[5]/div/div[1]/button")
    WebElement tax;

    @FindBy(xpath = "//*[@id=\"save-product-form\"]/div/div[1]/div/div/div[5]/div/div[1]/div/div[1]/input")
    WebElement taxSearchBar;

    @FindBy(xpath = "//input[@name='purchase_allow']")
    WebElement checkBoxCanPurchase;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//*[@id=\"file-upload-box\"]")
    WebElement uploadFileButton;

    @FindBy(xpath = "//button[@id=\"save-product\"]")
    WebElement saveButton;

    @FindBy(xpath = "//td[4]//a")
    List<WebElement> allProducts;


    public void clickProductAndAddProductButtons() throws InterruptedException {
        productsButton.click();
        Thread.sleep(2000);
        addProductButton.click();
    }

    public void enterProductNameAndPrice(String Name, String price) throws InterruptedException {
        Thread.sleep(3000);
        productName.sendKeys(Name);
        productPrice.clear();
        productPrice.sendKeys(price);

    }

    public void selectionOfCategoryAndTax() throws InterruptedException {

        productCategorySelect.click();

        productCategory.click();

        productSubCategorySelect.click();

        productSubCategory.click();

        checkBoxCanPurchase.click();

        tax.click();
        Thread.sleep(2000);
        taxSearchBar.sendKeys("Federal Tax");
        Thread.sleep(2000);
        taxSearchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);


    }

    public void addingTextToDescription(String description) {
        descriptionField.sendKeys(description);

    }

//    public void uploadingPictureOfTheProduct() throws InterruptedException {
//        Thread.sleep(50000);
//
//
//        uploadFileButton.sendKeys("C:\\Users\\Gytis\\Desktop\\crane.jpg");
//
//    }

    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        saveButton.click();
        Thread.sleep(2000);
    }

    public void validationOfTheProduct(String product) throws InterruptedException {
        List<String> expectedInformation = Arrays.asList(product);
        for (int i =0; i<allProducts.size();i++){
            Thread.sleep(2000);
            Assert.assertTrue(BrowserUtils.getText(allProducts.get(i)), expectedInformation.contains("Truck-Mounted" + " "+"Crane"));
        }
    }


}







