package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ItemInfoPageTest extends BaseTest {

    @Test(description = "Validation that product could be added to cart from Items info page")
    public void productShouldBeAddedToCart() {
        String productName = "Sauce Labs Backpack";
        String price = productPageSteps
                .getProductPrice(productName);
        productPageSteps
                .openItemInfo(productName);
        itemInfoPageSteps
                .productDetailsShouldBeLike(price)
                .clickAddToCartButton()
                .openShoppingCart();
        cartPageSteps
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
    }

    @Test(description = "Validation that product could be removed from cart from Items info page")
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        String price = productPageSteps
                .getProductPrice(productName);
        productPageSteps
                .openItemInfo(productName);
        itemInfoPageSteps
                .productDetailsShouldBeLike(price)
                .clickAddToCartButton()
                .openShoppingCart();
        cartPageSteps
                .productDetailsShouldBeLike(productName, "1", "29.99")
                .continueShopping();
        productPageSteps
                .openItemInfo(productName);
        itemInfoPageSteps
                .removeProductFromCart()
                .openShoppingCart();
        cartPageSteps
                .cartShouldBeEmpty();
    }
}