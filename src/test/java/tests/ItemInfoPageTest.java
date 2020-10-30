package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ItemInfoPageTest extends BaseTest {

    @Test(description = "Validation that product could be added to cart from Items info page")
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

    @Test(description = "Validation that product could be removed from cart from Items info page")
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .openItemInfo(productName)
                .clickAddToCartButton()
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike(productName, "1", "29.99")
                .continueShopping();
        productsPage
                .isPageOpened()
                .openItemInfo(productName)
                .clickRemoveFromCartButton()
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .numberOfItemsInTheCart(0);
    }
}