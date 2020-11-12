package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AboutPage extends AbstractPage {
    public final static String ABOUT_PAGE_URL = "https://saucelabs.com/";
    public final static By SAUCELABS_ICON = By.cssSelector(".nav-image");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open About page")
    @Override
    public AboutPage openPage() {
        driver.get(ABOUT_PAGE_URL);
        return this;
    }

    @Step("Verify About page is opened")
    @Override
    public AboutPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAUCELABS_ICON));
        } catch (TimeoutException e) {
            log.error(e.getLocalizedMessage());
            Assert.fail("The page has not been loaded. Button not found by locator " + SAUCELABS_ICON);
        }
        return this;
    }
}
