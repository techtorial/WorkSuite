package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import utils.DriverHelper;

public class ProductFiltersValidationSteps {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);

    @Then("the user clicks the Products from menu option")
    public void the_user_clicks_the_products_from_menu_option() throws InterruptedException {
        productsPage.clickProducts();
    }

    @Then("the user selects product category Lifting and Material Handling Equipment")
    public void the_user_selects_product_category_lifting_and_material_handling_equipment() throws InterruptedException {
        productsPage.selectCategoryFromTheList();
    }

    @Then("the user selects the sub Category: Mobile Cranes")
    public void the_user_selects_the_sub_category_mobile_cranes() {
        productsPage.selectSubCategoryFromTheList();
    }

    @Then("the user clicks three dots for the first product and clicks view button")
    public void the_user_clicks_three_dots_for_the_first_product_and_clicks_view_button() throws InterruptedException {
        productsPage.selectViewFromMenu();

    }

    @Then("the user verifies that product {string}")
    public void the_user_verifies_that_product(String ExpectedCategory) {
        Assert.assertEquals(ExpectedCategory,productsPage.validationProductDetails());
    }
    @Then("the user verifies {string}")
    public void the_user_verifies(String ExpectedSubCategory) {
        Assert.assertEquals(ExpectedSubCategory, productsPage.validateSubProductDetails());
    }
}
