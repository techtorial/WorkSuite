package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrderPage {

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"table-actions\"]/a")
    WebElement addOrderButton;

    @FindBy(xpath = "//*[@id=\"status\"]")
    List<WebElement> status;

    @FindBy(xpath = "//*[@title=\"Pending\"]")
    WebElement statusButton;

    public void clickAddOrderButtons() throws InterruptedException {
        addOrderButton.click();
    }

    public void getStatus(){
        statusButton.click();
    }

    public void verifyStatus(io.cucumber.datatable.DataTable dataTable){
        List<Map<String, String>> statusData = dataTable.asMaps(String.class, String.class);
        String statusItem;
        int i=1;
        for (Map<String, String> statusDataMap : statusData) {
            for (WebElement el:status){
                statusItem = statusDataMap.get("Status"+(i++));
                List<String> expectedInformation = Arrays.asList(statusItem);
                Assert.assertTrue(BrowserUtils.getText(el), expectedInformation.contains(statusItem));
            }
        }
    }
}
