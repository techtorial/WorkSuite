package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.File;

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

    @FindBy(xpath = "//button[@class=\"btn btn-secondary buttons-excel\"]")
    WebElement exportButton;


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

    public void clickExportButton() throws InterruptedException {
        Thread.sleep(1000);
        exportButton.click();
        Thread.sleep(1000);
    }

    public void validateExcelFileDownloaded(String fileName, String downloadPath) {
        //String downloadPath = "C:\\Users\\Cristina\\Downloads\\";
        //String fileName = "orders-2024";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().contains(fileName)) {
                    System.out.println(dirContents[i].getName());
                    List<String> expectedInformation = Arrays.asList(dirContents[i].getName());
                    Assert.assertTrue(dirContents[i].getName().contains(fileName));

                    // File has been found, it can now be deleted:
                    dirContents[i].delete();
                    break;
                }
        }

    }
}
