package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends AbstractPage {
    public final static String LOGIN_PAGE_URL = "index.html";
    public final static By USERNAME_INPUT = By.id("user-name");
    public final static By PASSWORD_INPUT = By.id("password");
    public final static By LOGIN_BUTTON = By.id("login-button");
    public final static By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Login page")
    public LoginPage openPage() {
        driver.get(URL + LOGIN_PAGE_URL);
        return this;
    }

    @Step("Verify Login page is opened")
    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    @Step("Login with username '{username}' and password '{password}'")
    public LoginPage attemptToLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public ProductsPage login(String username, String password) {
        attemptToLogin(username, password);
        return new ProductsPage(driver);
    }

    @Step("Getting error message text")
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Verify error message is appeared")
    public LoginPage isErrorMessageAppeared() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        } catch (TimeoutException e) {
            Assert.fail("Message has not appeared. The message has not been found by locator " + ERROR_MESSAGE);
        }
        return this;
    }
}
