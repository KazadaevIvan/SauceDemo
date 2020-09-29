package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public final static String LOGIN_PAGE_URL = "https://www.saucedemo.com/index.html";
    public final static By USERNAME_INPUT = By.id("user-name");
    public final static By PASSWORD_INPUT = By.id("password");
    public final static By LOGIN_BUTTON = By.id("login-button");
    public final static By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(LOGIN_PAGE_URL);
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
