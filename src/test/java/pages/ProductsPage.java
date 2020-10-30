package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends AbstractPage {
    public final static String PRODUCTS_PAGE_URL = "inventory.html";
    public final static By ITEMS_NAMES = By.className("inventory_item_name");
    public final static By ITEMS_PRICES = By.className("inventory_item_price");
    public final static By PRODUCTS_LABEL = By.cssSelector(".product_label");
    String addRemoveToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    String itemNameLocator = "//div[contains(text(),'%s')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Products page")
    public ProductsPage openPage() {
        driver.get(URL + PRODUCTS_PAGE_URL);
        return this;
    }

    @Step("Verify Products page is opened")
    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_LABEL));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Label has not been found by locator " + PRODUCTS_LABEL);
        }
        return this;
    }

    public ItemInfoPage openItemInfo(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemNameLocator, itemName)));
        item.click();
        return new ItemInfoPage(driver);
    }

    public List<WebElement> itemsNamesList() {
        return driver.findElements(ITEMS_NAMES);
    }

    public List<String> getAllItemsNames() {
        List<WebElement> items = itemsNamesList();
        List<String> names = new ArrayList<>();
        for (WebElement element : items) {
            names.add(element.getText());
        }
        return names;
    }

    public List<WebElement> itemsPricesList() {
        return driver.findElements(ITEMS_PRICES);
    }

    public List<Double> getAllItemsPrices() {
        List<WebElement> items = itemsPricesList();
        List<Double> prices = new ArrayList<>();
        for (WebElement element : items) {
            prices.add(Double.parseDouble(element.getText().substring(1)));
        }
        return prices;
    }

    @Step("Finding product and click ADD button")
    public ProductsPage addItemToCart(String itemName) {
        driver.findElement(By.xpath(String.format(addRemoveToCartLocator, itemName))).click();
        return this;
    }

    @Step("Finding product '{itemName}' and click REMOVE button")
    public ProductsPage removeItemFromCart(String itemName) {
        driver.findElement(By.xpath(String.format(addRemoveToCartLocator, itemName))).click();
        return this;
    }

    public void printAllItemsNamesWithPrices() {
        List<WebElement> names = itemsNamesList();
        List<WebElement> prices = itemsPricesList();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).getText() + " - " + prices.get(i).getText());
        }
    }
}
