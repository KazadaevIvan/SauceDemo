package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CartPage extends AbstractPage {
    public static final String CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
    public final static By CONTINUE_SHOPPING_BUTTON = By.className("btn_secondary");
    public final static By CHECKOUT_BUTTON = By.xpath("//a[@href='./checkout-step-one.html']");
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(CART_PAGE_URL);
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void productDetailsShouldBeLike(String productName, String quantity, String price) {
        assertEquals(getProductPrice(productName), price, "Price is not correct");
        assertEquals(getProductQuantity(productName), quantity, "Quantity is not correct");
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
    }
}
