package tests;

import org.testng.annotations.Test;

public class ItemInfoPageTest extends BaseTest {

    @Test
    public void productShouldBeAddedToCart() {
        String itemName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .openItemInfo(itemName)
                .clickAddToCartButton()
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
    }

    @Test
    public void productShouldBeRemovedFromCart() {
        String itemName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
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