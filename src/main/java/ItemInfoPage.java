import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemInfoPage {
    WebDriver driver;
    By price = By.className("inventory_details_price");
    By addToCartButton = By.xpath("//button[text()='ADD TO CART']");

    public ItemInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemPrice() {
        return driver.findElement(price).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}
