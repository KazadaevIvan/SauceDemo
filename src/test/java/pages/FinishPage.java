package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FinishPage extends AbstractPage {
    public final static String FINISH_PAGE_URL = "checkout-complete.html";
    public final static By COMPLETE_HEADER = By.className("complete-header");
    public final static By COMPLETE_TEXT = By.className("complete-text");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Finish page")
    public FinishPage openPage() {
        driver.get(URL + FINISH_PAGE_URL);
        return this;
    }

    @Step("Verify Finish page is opened")
    @Override
    public FinishPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE_HEADER));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + COMPLETE_HEADER);
        }
        return this;
    }

    @Step("Get Complete header text")
    public String getCompleteHeaderText() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    @Step("Get Complete text")
    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }
}
