package pages;

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

    public LoginPage openPage() {
        driver.get(URL + LOGIN_PAGE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + LOGIN_BUTTON);
        }
        return this;
    }

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

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage isErrorMessageAppeared() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        } catch (TimeoutException e) {
            Assert.fail("Сообщение не появилось. Не найдено сообщение по локатору " + ERROR_MESSAGE);
        }
        return this;
    }
}
