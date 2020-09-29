package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class AbstractPage {
    public final static By OPEN_MENU_BUTTON = By.xpath("//button[contains(text(),'Open Menu')]");
    public final static By SHOPPING_CART = By.cssSelector("[data-icon='shopping-cart']");
    WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    abstract public void openPage();

    public MenuPage clickOpenMenuButton() {
        driver.findElement(OPEN_MENU_BUTTON).click();
        return new MenuPage(driver);
    }

    public CartPage openShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
        return new CartPage(driver);
    }
}