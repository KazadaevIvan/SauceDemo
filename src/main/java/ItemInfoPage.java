import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemInfoPage extends AbstractPage {
    By price = By.className("inventory_details_price");
    By addToCartButton = By.xpath("//button[text()='ADD TO CART']");

    public ItemInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getItemPrice() {
        return driver.findElement(price).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}
