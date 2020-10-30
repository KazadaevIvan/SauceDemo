package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductPageSteps {
    private ProductsPage productsPage;

    public ProductPageSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Adding product '{productName}' into shopping cart")
    public ProductPageSteps addItemToCart(String productName) {
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(productName);
        return this;
    }

    @Step("Removing product '{productName}' from shopping cart")
    public ProductPageSteps removeProductFromCart(String productName) {
        productsPage
                .openPage()
                .isPageOpened()
                .removeItemFromCart(productName);
        return this;
    }
}