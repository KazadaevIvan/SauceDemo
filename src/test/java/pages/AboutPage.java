package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutPage extends AbstractPage {
    public final static String ABOUT_PAGE_URL = "https://saucelabs.com/";
    public final static By SIGN_IN_BUTTON = By.cssSelector("[data-tc='Header CTA Secondary']");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open About page")
    @Override
    public AboutPage openPage() {
        driver.get(ABOUT_PAGE_URL);
        return this;
    }

    @Step("Verify Cart page is opened")
    @Override
    public AboutPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SIGN_IN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + SIGN_IN_BUTTON);
        }
        return this;
    }
}
