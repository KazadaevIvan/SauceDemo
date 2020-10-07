package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(productName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike(productName, "1", "29.99")
                .removeItemFromCart(productName)
                .isCartEmpty();
    }
}