import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends AbstractPage {
    By itemsNames = By.className("inventory_item_name");
    By itemsPrices = By.className("inventory_item_price");
    By sortingMethod = By.className("product_sort_container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ItemInfoPage openItemInfo(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format("//div[text()='%s']", itemName)));
        item.click();
        return new ItemInfoPage(driver);
    }

    public void getAllItemsNames() {
        List<WebElement> items = driver.findElements(itemsNames);
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
    }

    public void getAllItemsPrices() {
        List<WebElement> items = driver.findElements(itemsPrices);
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
    }

    public void addItemToCart(String itemName) {
        WebElement addToCartButton = driver.findElement(By.xpath(String.format("//div[text()='%s']/../../following-sibling::div/button", itemName)));
        addToCartButton.click();
    }

    public void chooseSortingMethod(String value) {
        Select sortingMethodSelector = new Select(driver.findElement(this.sortingMethod));
        sortingMethodSelector.selectByVisibleText(value);
    }

    public void getAllItemsNamesWithPrices() {
        List<WebElement> names = driver.findElements(itemsNames);
        List<WebElement> prices = driver.findElements(itemsPrices);
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).getText() + " - " + prices.get(i).getText());
        }
    }
}
