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
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL + CART_PAGE_URL);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CHECKOUT_BUTTON);
        }
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
