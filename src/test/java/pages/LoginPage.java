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
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL + LOGIN_PAGE_URL);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + LOGIN_BUTTON);
        }
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
