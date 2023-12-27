package pages;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.io.File;
import java.time.Duration;
import java.util.*;


public class ProductsPage {


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


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

    @FindBy(xpath = "//*[@id=\"file-upload-dropzone-product\"]")
    WebElement uploadFileButton;

    @FindBy(xpath = "//button[@id=\"save-product\"]")
    WebElement saveButton;

    @FindBy(xpath = "//td[4]//a")
    List<WebElement> allProducts;

    @FindBy(xpath = "//button[@data-id='category_id']")
    WebElement categoryProduct;

    @FindBy(xpath = "//li/a[@role='option']")
    List<WebElement> categoryOptions;

    @FindBy(xpath = "//li/a[@class='dropdown-item']")
    List<WebElement> subCategoryOptions;

    @FindBy(xpath = "//*[@id=\"filter-form\"]/div/div[2]/div/div/button")
    WebElement subCategoryMenu;

    @FindBy(xpath = "/html/body/div[1]/section/div[4]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/div/div/a")
    WebElement actionButton;


    @FindBy(xpath = "/html/body/div[1]/section/div[4]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/div/div/div/a")
    List<WebElement> actionButtonOptions;

    @FindBy(xpath = "//*[@id=\"product-detail-section\"]/div/div/div/div[2]/div/div/div[6]/p[2]")
    WebElement productDetailsCategory;

    @FindBy(xpath = "//*[@id=\"product-detail-section\"]/div/div/div/div[2]/div/div/div[7]/p[2]")
    WebElement productDetailsSubCategory;

    @FindBy(xpath = "//button[@id='add-category']")
    WebElement addCategoryButton;

    @FindBy(xpath = "//input[@id='category_name']")
    WebElement newCategoryName;

    @FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[3]/a")
    WebElement cancelCategoryButton;

    @FindBy(xpath = "//*[@id=\"save-category\"]")
    WebElement saveCategoryButton;

    @FindBy(xpath = "//*[@id=\"save-product-form\"]/div/div[1]/div/div/div[3]/div/div[1]/button")
    WebElement categoryButton;

    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/form/div/div[1]/div/div/div[3]/div/div[1]/div/div[2]/ul/li")
    List<WebElement> categories;


    public void clickAddProductButtons() throws InterruptedException {

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

    public void uploadingPictureOfTheProduct() throws InterruptedException {
        Thread.sleep(2000);

        uploadFileButton.sendKeys("src/test/resources/crane.jpg");

    }

    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        saveButton.click();
        Thread.sleep(2000);
    }

    public void validationOfTheProduct(String product) throws InterruptedException {
        List<String> expectedInformation = Arrays.asList(product);
        for (int i = 0; i < allProducts.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(BrowserUtils.getText(allProducts.get(i)), expectedInformation.contains("Truck-Mounted" + " " + "Crane"));
        }
    }


    public void selectProductCategory(String category) {
        categoryProduct.click();
        for (WebElement option : categoryOptions) {
            if (option.getText().equals(category)) {
                option.click();
                break;
            }
        }
    }


    public void selectSubCategory(String subCategory) {
        subCategoryMenu.click();
        for (WebElement subOptions : subCategoryOptions) {
            if (subOptions.getText().equals(subCategory)) {
                subOptions.click();
                break;
            }
        }
    }


    public void clickActionButton() throws InterruptedException {
        Thread.sleep(3000);
        actionButton.click();

    }


    public void clickingOptions(String optionFromActionButton) throws InterruptedException {
        for (WebElement options : actionButtonOptions) {
            if (options.getText().equals(optionFromActionButton)) {
                options.click();
                Thread.sleep(5000);
                break;


            }

        }
    }

    public void categoryValidation(String expectedProductInCategory, String expectedSubCategoryInDetails) {
        String actualName = BrowserUtils.getText(productDetailsCategory);
        String actualName1 = BrowserUtils.getText(productDetailsSubCategory);
        Assert.assertTrue("Product Category is not matching", expectedProductInCategory.equals(actualName));
        Assert.assertTrue("Product Sub Category  is not matching", expectedSubCategoryInDetails.equals(actualName1));
    }


    public void clickAddCategoryButton() throws InterruptedException {
        Thread.sleep(3000);
        addCategoryButton.click();
        Thread.sleep(3000);
    }


    public void categoryName(String name) {
        newCategoryName.sendKeys(name);
    }

    public void saveNewCategory(String buttonName) throws InterruptedException {
        List<WebElement> webElementsList = new ArrayList<>();
        webElementsList.add(saveCategoryButton);
        webElementsList.add(cancelCategoryButton);
        for (WebElement option : webElementsList) {
            if (option.getText().equals(buttonName)) {
                option.click();
                Thread.sleep(5000);
                break;
            }
        }
    }


    public void validateCreatedCategory(String expectedName) throws InterruptedException {
        categoryButton.click();
        boolean categoryFaund = false;
        for (WebElement option1 : categories) {
            if (option1.getText().equals(expectedName)){
                categoryFaund = true;
                break;
            }

            }
        Assert.assertTrue("Product Category is not matching", categoryFaund);
        }
    }











