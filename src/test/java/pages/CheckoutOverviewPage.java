package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewPage extends AbstractPage {
    public final static String CHECKOUT_OVERVIEW_PAGE_URL = "checkout-step-two.html";
    public final static By CANCEL_BUTTON = By.cssSelector(".btn_secondary");
    public final static By FINISH_BUTTON = By.cssSelector(".btn_action");
    public final static By CART_ITEM_PRICE = By.cssSelector(".inventory_item_price");
    public final static By ITEM_TOTAL_PRICE = By.className("summary_subtotal_label");
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='summary_quantity']";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Checkout Overview page")
    public CheckoutOverviewPage openPage() {
        driver.get(URL + CHECKOUT_OVERVIEW_PAGE_URL);
        return this;
    }

    @Step("Verify Checkout Overview page is opened")
    @Override
    public CheckoutOverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + FINISH_BUTTON);
        }
        return this;
    }

    @Step("Clicking CANCEL button")
    public CheckoutOverviewPage cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    @Step("Clicking FINISH button")
    public FinishPage finishButtonClick() {
        driver.findElement(FINISH_BUTTON).click();
        return new FinishPage(driver);
    }

    public CheckoutOverviewPage productDetailsShouldBeLike(String productName, String quantity, String price) {
        assertEquals(getProductPrice(productName), price, "Price is not correct");
        assertEquals(getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    @Step("Getting product price")
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(priceLocator, productName))).getText().substring(1);
    }

    @Step("Getting product quantity")
    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
    }

    @Step("Getting sum of all products in the cart")
    public Double getSumOfAllItemsPrices() {
        List<WebElement> items = driver.findElements(CART_ITEM_PRICE);
        double sum = 0;
        for (WebElement element : items) {
            sum += Double.parseDouble(element.getText().substring(1));
        }
        return sum;
    }

    @Step("Getting products total price")
    public Double getItemsTotalPrice() {
        return Double.parseDouble(driver.findElement(ITEM_TOTAL_PRICE).getText().substring(13));
    }
}