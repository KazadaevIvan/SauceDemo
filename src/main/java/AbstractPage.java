import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class AbstractPage {
    WebDriver driver;
    By openMenuButton = By.xpath("//button[text()='Open Menu']");
    By shoppingCart = By.cssSelector("[data-icon='shopping-cart']");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public MenuPage clickOpenMenuButton() {
        driver.findElement(openMenuButton).click();
        return new MenuPage(driver);
    }

    public CartPage openShoppingCart() {
        driver.findElement(shoppingCart).click();
        return new CartPage(driver);
    }
}