package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends AbstractPage {
    public final static By ALL_ITEMS_OPTION = By.id("inventory_sidebar_link");
    public final static By ABOUT_OPTION = By.id("about_sidebar_link");
    public final static By LOGOUT_OPTION = By.id("logout_sidebar_link");
    public final static By RESET_APP_STATE_OPTION = By.id("reset_sidebar_link");
    public final static By CLOSE_BUTTON = By.xpath("//button[text()='Close Menu']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuPage openPage() {
        System.out.println("Don't do this");
        return this;
    }

    @Override
    public MenuPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_OPTION));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button has not been found by locator " + LOGOUT_OPTION);
        }
        return this;
    }

    @Step("Click All Items option")
    public ProductsPage clickAllItemsOption() {
        driver.findElement(ALL_ITEMS_OPTION).click();
        return new ProductsPage(driver);
    }

    @Step("Click About option")
    public AboutPage clickAboutOption() {
        driver.findElement(ABOUT_OPTION).click();
        return new AboutPage(driver);
    }

    @Step("Click Logout option")
    public LoginPage clickLogoutOption() {
        driver.findElement(LOGOUT_OPTION).click();
        return new LoginPage(driver);
    }

    @Step("Click Reset App State option")
    public MenuPage clickResetAppStateOption() {
        driver.findElement(RESET_APP_STATE_OPTION).click();
        return this;
    }

    @Step("Click Close button")
    public ProductsPage clickCloseButton() {
        driver.findElement(CLOSE_BUTTON).click();
        return new ProductsPage(driver);
    }
}
