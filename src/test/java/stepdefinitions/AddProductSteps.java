package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverHelper;

public class AddProductSteps {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);


    @Then("the user clicks the Products from menu option and AddProduct button")
    public void the_user_clicks_the_products_from_menu_option_and_add_product_button() throws InterruptedException {
        productsPage.clickProductAndAddProductButtons();

    }

    @Then("the user enter {string} price {string}")
    public void the_user_enter_price(String name, String price) throws InterruptedException {
        productsPage.enterProductNameAndPrice(name, price);
    }

    @Then("the user select product from the product category, product Sub category, tax, and select client can purschase")
    public void the_user_select_product_from_the_product_category_product_sub_category_tax_and_select_client_can_purschase() throws InterruptedException {
        productsPage.selectionOfCategoryAndTax();
    }

    @Then("user add product description for the product")
    public void user_add_product_description_for_the_product() {
        productsPage.addingTextToDescription("very good product");
    }

    //   @Then("user upload picture of the product")
    //   public void user_upload_picture_of_the_product() throws InterruptedException {
    //       productsPage.uploadingPictureOfTheProduct();
    //   }
    @Then("then user clicks save button")
    public void then_user_clicks_save_button() throws InterruptedException {
        productsPage.clickSaveButton();
    }

    @Then("user validates the product name on the page")
    public void user_validates_the_product_name_on_the_page() throws InterruptedException {
        productsPage.validationOfTheProduct("Truck-Mounted" +" "+"Crane");
    }


    }

