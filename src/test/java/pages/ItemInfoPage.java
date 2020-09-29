package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemInfoPage extends AbstractPage {
    public final static By PRICE = By.className("inventory_details_price");
    public final static By ADD_TO_CART_BUTTON = By.xpath("//button[contains(text(),'ADD TO CART')]");
    public final static By BACK_BUTTON = By.className("inventory_details_back_button");
    public final static By PRODUCT_NAME = By.className("inventory_details_name");

    public ItemInfoPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        System.out.println("Don't do this");
    }

    public String getItemName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(PRICE).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickBackButton() {
        driver.findElement(BACK_BUTTON).click();
    }
}
