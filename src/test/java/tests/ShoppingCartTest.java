package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void userShouldBeAbleToCheckout() {
        cartPage
                .openPage()
                .isPageOpened();
    }

    @Test
    public void productShouldBeRemovedFromCart() {
        String itemName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(itemName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99")
                .removeItemFromCart(itemName)
                .isCartEmpty();
    }
}
