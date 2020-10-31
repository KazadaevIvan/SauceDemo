package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    public final static By ALL_ITEMS_OPTION = By.id("inventory_sidebar_link");
    public final static By ABOUT_OPTION = By.id("about_sidebar_link");
    public final static By LOGOUT_OPTION = By.id("logout_sidebar_link");
    public final static By RESET_APP_STATE_OPTION = By.id("reset_sidebar_link");
    public final static By CLOSE_BUTTON = By.xpath("//button[text()='Close Menu']");
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click All Items option")
    public ProductsPage clickAllItemsOption() {
        driver.findElement(ALL_ITEMS_OPTION).click();
        return new ProductsPage(driver);
    }

    @Step("Click About option")
    public void clickAboutOption() {
        driver.findElement(ABOUT_OPTION).click();
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
