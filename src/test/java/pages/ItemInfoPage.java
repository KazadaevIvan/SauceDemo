package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ItemInfoPage extends AbstractPage {
    public final static By PRICE = By.className("inventory_details_price");
    public final static By ADD_TO_CART_BUTTON = By.xpath("//button[contains(text(),'ADD TO CART')]");
    public final static By BACK_BUTTON = By.className("inventory_details_back_button");
    public final static By PRODUCT_NAME = By.className("inventory_details_name");

    public ItemInfoPage(WebDriver driver) {
        super(driver);
    }

    public ItemInfoPage openPage() {
        System.out.println("Don't do this");
        return this;
    }

    @Override
    public ItemInfoPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(ADD_TO_CART_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + ADD_TO_CART_BUTTON);
        }
        return this;
    }

    public String getItemName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(PRICE).getText();
    }

    public ItemInfoPage clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public ProductsPage clickBackButton() {
        driver.findElement(BACK_BUTTON).click();
        return new ProductsPage(driver);
    }
}
