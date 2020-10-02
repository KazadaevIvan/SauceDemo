package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void finishButtonClick() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
