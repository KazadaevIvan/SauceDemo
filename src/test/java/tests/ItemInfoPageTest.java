package tests;

import org.testng.annotations.Test;

public class ItemInfoPageTest extends BaseTest {

    @Test
    public void productShouldBeRemovedFromCart() {
        String itemName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart("Sauce Labs Bike Light")
                .openItemInfo(itemName)
                .clickAddToCartButton()
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99")
                .continueShopping();
        productsPage
                .isPageOpened()
                .openItemInfo(itemName)
                .clickRemoveFromCartButton()
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .isCartEmpty();
    }
}