package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test(description = "Validation of the correct calculation of the sum of products")
    public void sumOfItemsPricesShouldBeCorrect() {
        String firstProductName = "Sauce Labs Backpack";
        String quantity = "1";
        String firstProductPrice = "29.99";
        String secondProductName = "Sauce Labs Fleece Jacket";
        String secondProductPrice = "49.99";
        productPageSteps
                .addItemToCart(firstProductName)
                .addItemToCart(secondProductName);
        cartPageSteps
                .checkout();
        checkoutPageSteps
                .continueCheckout("Arnold", "Jackson", "29020");
        checkoutOverviewPageSteps
                .productDetailsShouldBeLike(firstProductName, quantity, firstProductPrice)
                .productDetailsShouldBeLike(secondProductName, quantity, secondProductPrice)
                .totalPriceShouldBeLike(checkoutOverviewPage.getItemsTotalPrice());
    }
}