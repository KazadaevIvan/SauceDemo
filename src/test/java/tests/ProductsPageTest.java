package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProductsPageTest extends BaseTest {

    @Test(description = "Validation that product could be added to cart from Products page")
    public void productShouldBeAddedToCart() {
        loginPageSteps
                .login(USERNAME, PASSWORD);
        productPageSteps
                .addItemToCart("Sauce Labs Backpack");
        cartPageSteps
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
    }

    @Test(description = "Validation that product could be removed from cart from Products page")
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        productPageSteps
                .addItemToCart(productName);
        cartPageSteps
                .productDetailsShouldBeLike(productName, "1", "29.99");
        productPageSteps
                .removeProductFromCart(productName);
        cartPageSteps
                .numberOfItemsInTheCartShouldBe(0);
    }
}