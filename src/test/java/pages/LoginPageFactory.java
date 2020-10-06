package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPageFactory extends AbstractPage {

    public final static String LOGIN_PAGE_URL = "index.html";
    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory openPage() {
        driver.get(URL + LOGIN_PAGE_URL);
        return this;
    }

    @Override
    public LoginPageFactory isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась.");
        }
        return this;
    }

    public ProductsPage login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void isErrorMessageAppeared() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
        } catch (TimeoutException e) {
            Assert.fail("Сообщение не появилось.");
        }
    }
}
