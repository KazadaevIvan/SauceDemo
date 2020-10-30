package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test(description = "Validation of the correct calculation of the sum of products")
    public void sumOfItemsPricesShouldBeCorrect() {
        String firstProductName = "Sauce Labs Backpack";
        String quantity = "1";
        String firstProductPrice = "29.99";
        String secondProductName = "Sauce Labs Fleece Jacket";
        String secondProductPrice = "49.99";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(firstProductName)
                .addItemToCart(secondProductName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .clickCheckoutButton();
        checkoutPage
                .isPageOpened()
                .continueCheckout("Arnold", "Jackson", "29020");
        checkoutOverviewPage
                .isPageOpened()
                .productDetailsShouldBeLike(firstProductName, quantity, firstProductPrice)
                .productDetailsShouldBeLike(secondProductName, quantity, secondProductPrice);
        assertEquals(checkoutOverviewPage.getSumOfAllItemsPrices(), checkoutOverviewPage.getItemsTotalPrice(),
                "Total price is not correct");
    }
}