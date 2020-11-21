package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class EndToEndTest extends BaseTest {

    @Test(description = "Validation that user can successfully go through the path" +
            " from logging in to finishing the checkout")
    public void pathFromLoginToFinishShouldBeSuccessful() {
        String productName = "Sauce Labs Backpack";
        String quantity = "1";
        String price = "29.99";
        loginPageSteps
                .login(USERNAME, PASSWORD);
        productPageSteps
                .addItemToCart(productName);
        cartPageSteps
                .productDetailsShouldBeLike(productName, quantity, price)
                .checkout();
        checkoutPageSteps
                .continueCheckout("Arnold", "Jackson", "29020");
        checkoutOverviewPageSteps
                .productDetailsShouldBeLike(productName, quantity, price)
                .totalPriceShouldBeLike(checkoutOverviewPage.getItemsTotalPrice())
                .finishButtonClick();
        finishPageSteps
                .completeHeaderShouldBeLike("THANK YOU FOR YOUR ORDER");
    }
}