package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ItemInfoPage extends AbstractPage {
    public final static By PRICE = By.className("inventory_details_price");
    public final static By ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary");
    public final static By REMOVE_FROM_CART_BUTTON = By.cssSelector(".btn_secondary");
    public final static By BACK_BUTTON = By.className("inventory_details_back_button");
    public final static By PRODUCT_NAME = By.className("inventory_details_name");

    public ItemInfoPage(WebDriver driver) {
        super(driver);
    }

    public ItemInfoPage openPage() {
        log.error("Don't do this");
        return this;
    }

    @Step("Verify page with product info is opened")
    @Override
    public ItemInfoPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getLocalizedMessage());
            Assert.fail("The page has not been loaded. Button not found by locator " + ADD_TO_CART_BUTTON);
        }
        return this;
    }

    @Step("Get product name")
    public String getItemName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Get product price")
    public String getItemPrice() {
        return driver.findElement(PRICE).getText().substring(1);
    }

    @Step("Click ADD button")
    public ItemInfoPage clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    @Step("Click REMOVE button")
    public ItemInfoPage clickRemoveFromCartButton() {
        driver.findElement(REMOVE_FROM_CART_BUTTON).click();
        return this;
    }

    @Step("Click BACK button")
    public ProductsPage clickBackButton() {
        driver.findElement(BACK_BUTTON).click();
        return new ProductsPage(driver);
    }
}
