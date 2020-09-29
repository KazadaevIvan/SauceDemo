package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends AbstractPage {
    public static final String FINISH_PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";
    public final static By COMPLETE_HEADER = By.className("complete-header");
    public final static By COMPLETE_TEXT = By.className("complete-text");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(FINISH_PAGE_URL);
    }

    public String getCompleteHeaderText() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }
}
