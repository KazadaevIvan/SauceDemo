package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends AbstractPage {
    public final static String PRODUCTS_PAGE_URL = "https://www.saucedemo.com/inventory.html";
    public final static By ITEMS_NAMES = By.className("inventory_item_name");
    public final static By ITEMS_PRICES = By.className("inventory_item_price");
    public final static By SORTING_METHOD = By.className("product_sort_container");
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    String itemNameLocator = "//div[contains(text(),'%s')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PRODUCTS_PAGE_URL);
    }

    public ItemInfoPage openItemInfo(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemNameLocator, itemName)));
        item.click();
        return new ItemInfoPage(driver);
    }

    public void getAllItemsNames() {
        List<WebElement> items = driver.findElements(ITEMS_NAMES);
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
    }

    public void getAllItemsPrices() {
        List<WebElement> items = driver.findElements(ITEMS_PRICES);
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
    }

    public void addItemToCart(String itemName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, itemName))).click();
    }

    public void chooseSortingMethod(String value) {
        Select sortingMethodSelector = new Select(driver.findElement(SORTING_METHOD));
        sortingMethodSelector.selectByVisibleText(value);
    }

    public void getAllItemsNamesWithPrices() {
        List<WebElement> names = driver.findElements(ITEMS_NAMES);
        List<WebElement> prices = driver.findElements(ITEMS_PRICES);
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).getText() + " - " + prices.get(i).getText());
        }
    }
}
