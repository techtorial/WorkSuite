package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import utils.DriverHelper;

public class ValidateFilterForProductSteps {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);


    @Then("the user select product category {string}")
    public void the_user_select_product_category(String productCategory) {
        productsPage.selectProductCategory(productCategory);

    }

    @Then("the user select sub category {string}")
    public void the_user_select_sub_category(String productSubCategory) {
        productsPage.selectSubCategory(productSubCategory);

    }

    @Then("the user click action button and select {string} from the option")
    public void the_user_click_action_button_and_select_from_the_option(String actionOption) throws InterruptedException {
        productsPage.clickActionButton();
        productsPage.clickingOptions(actionOption);


    }

    @Then("the user verify product Category {string} and Product Sub Category {string} is matching selection")
    public void the_user_verify_product_category_and_product_sub_category_is_matching_selection(String category, String subcategory) {
        productsPage.categoryValidation(category,subcategory);
    }
}
