package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutOverviewPage extends AbstractPage {
    public final static String CHECKOUT_OVERVIEW_PAGE_URL = "checkout-step-two.html";
    public final static By CANCEL_BUTTON = By.xpath("//button[@contains(text(),'CANCEL']");
    public final static By FINISH_BUTTON = By.xpath("//button[@contains(text(),'FINISH']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL + CHECKOUT_OVERVIEW_PAGE_URL);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(FINISH_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + FINISH_BUTTON);
        }
    }

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void finishButtonClick() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
