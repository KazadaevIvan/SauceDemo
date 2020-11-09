package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckoutPageTest extends BaseTest {

    @Test(description = "Validation that correct message appears when checkout with invalid credentials",
            dataProvider = "testDataForCheckout")
    public void errorMessageShouldBeShownWhenCheckout(String firstName, String lastName, String postalCode, String errorMessage) {
        checkoutPageSteps
                .attemptToContinueCheckout(firstName, lastName, postalCode)
                .errorMessageShouldBeLike(errorMessage);
    }

    @DataProvider(name = "testDataForCheckout")
    public Object[][] testDataForCheckout() {
        return new Object[][]{
                {"", "Ivanov", "22-04", "Error: First Name is required"},
                {"Ivan", "", "22-04", "Error: Last Name is required"},
                {"Ivan", "Ivanov", "", "Error: Postal Code is required"}
        };
    }

    @Test(description = "Validation that user could checkout with valid credentials")
    public void userShouldBeAbleToContinueCheckout() {
        checkoutPageSteps
                .continueCheckout("Arnold", "Jackson", "29020");
        checkoutOverviewPage
                .isPageOpened();
    }
}
