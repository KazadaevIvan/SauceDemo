package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractPage {
    public final static String URL = "https://www.saucedemo.com/";
    public final static By OPEN_MENU_BUTTON = By.xpath("//button[contains(text(),'Open Menu')]");
    WebDriver driver;
    WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    abstract public AbstractPage openPage();

    abstract public AbstractPage isPageOpened();

    @Step("Click Menu icon")
    public MenuPage clickMenuIcon() {
        driver.findElement(OPEN_MENU_BUTTON).click();
        return new MenuPage(driver);
    }
}