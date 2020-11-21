package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ShoppingCartTest extends BaseTest {

    @Test(description = "Validation that product could be removed from cart from Cart page")
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        productPageSteps
                .addItemToCart(productName);
        cartPageSteps
                .productDetailsShouldBeLike(productName, "1", "29.99")
                .removeItemFromCart(productName)
                .numberOfItemsInTheCartShouldBe(0);
    }
}