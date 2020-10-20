package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class CartPage extends AbstractPage {
    public final static String CART_PAGE_URL = "cart.html";
    public final static By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[contains(text(),'Continue')]");
    public final static By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public final static By CART_ITEM = By.cssSelector(".cart_item");
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";
    String removeItemFromCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openPage() {
        driver.get(URL + CART_PAGE_URL);
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + CHECKOUT_BUTTON);
        }
        return this;
    }

    public ProductsPage continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CheckoutOverviewPage clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    public CartPage productDetailsShouldBeLike(String productName, String quantity, String price) {
        assertEquals(getProductPrice(productName), price, "Price is not correct");
        assertEquals(getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
    }

    public CartPage isCartEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(CART_ITEM, 0));
        } catch (TimeoutException e) {
            Assert.fail("Cart is not empty. Number of elements in the cart : " + driver.findElements(CART_ITEM).size());
        }
        return this;
    }

    public CartPage removeItemFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeItemFromCartLocator, productName))).click();
        return this;
    }
}
