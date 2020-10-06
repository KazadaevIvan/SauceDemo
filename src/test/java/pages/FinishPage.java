package pages;

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

    public FinishPage openPage() {
        driver.get(URL + FINISH_PAGE_URL);
        return this;
    }

    @Override
    public FinishPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(COMPLETE_HEADER));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + COMPLETE_HEADER);
        }
        return this;
    }

    public String getCompleteHeaderText() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }
}
