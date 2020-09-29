import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends AbstractPage {
    By continueShoppingButton = By.className("btn_secondary");
    By checkoutButton = By.xpath("//a[@href='./checkout-step-one.html']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
