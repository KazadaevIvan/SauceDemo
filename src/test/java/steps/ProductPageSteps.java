package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

@Log4j2
public class ProductPageSteps {
    private ProductsPage productsPage;

    public ProductPageSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Add product '{productName}' to the shopping cart")
    public ProductPageSteps addItemToCart(String productName) {
        log.info(String.format("Add product '%s' to the shopping cart", productName));
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(productName);
        return this;
    }

    @Step("Remove product '{productName}' from shopping cart")
    public ProductPageSteps removeProductFromCart(String productName) {
        log.info(String.format("Remove product '%s' from shopping cart", productName));
        productsPage
                .openPage()
                .isPageOpened()
                .removeItemFromCart(productName);
        return this;
    }

    @Step("Open product '{productName}' info")
    public ProductPageSteps openItemInfo(String productName) {
        log.info(String.format("Open product '%s' info", productName));
        productsPage
                .openPage()
                .isPageOpened()
                .openItemInfo(productName);
        return this;
    }

    @Step("Get product '{productName}' price")
    public String getProductPrice(String productName) {
        log.info(String.format("Get product '%s' price", productName));
        return productsPage
                .openPage()
                .isPageOpened()
                .getProductPrice(productName);
    }

    @Step("Open Menu")
    public ProductPageSteps openMenu() {
        log.info("Open Menu");
        productsPage
                .openPage()
                .isPageOpened()
                .clickMenuIcon()
                .isPageOpened();
        return this;
    }
}