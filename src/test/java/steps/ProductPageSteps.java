package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductPageSteps {
    private ProductsPage productsPage;

    public ProductPageSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Add product '{productName}' to the shopping cart")
    public ProductPageSteps addItemToCart(String productName) {
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(productName);
        return this;
    }

    @Step("Remove product '{productName}' from shopping cart")
    public ProductPageSteps removeProductFromCart(String productName) {
        productsPage
                .openPage()
                .isPageOpened()
                .removeItemFromCart(productName);
        return this;
    }

    @Step("Open Shopping cart")
    public ProductPageSteps openShoppingCart() {
        productsPage
                .isPageOpened()
                .clickShoppingCartIcon();
        return this;
    }

    @Step("Open product '{productName}' info")
    public ProductPageSteps openItemInfo(String productName) {
        productsPage
                .openPage()
                .isPageOpened()
                .openItemInfo(productName);
        return this;
    }

    @Step("Get product '{productName}' price")
    public String getProductPrice(String productName) {
        return productsPage
                .openPage()
                .isPageOpened()
                .getProductPrice(productName);
    }
}