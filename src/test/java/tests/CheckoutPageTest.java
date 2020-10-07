package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutPageTest extends BaseTest {

    @Test(dataProvider = "testDataForCheckout")
    public void errorMessageShouldBeShownWhenCheckout(String firstName, String lastName, String postalCode, String errorMessage) {
        checkoutPage
                .openPage()
                .isPageOpened()
                .attemptToContinueCheckout(firstName, lastName, postalCode)
                .isErrorMessageAppeared();
        String actualResult = checkoutPage.getErrorMessageText();
        assertEquals(actualResult, errorMessage, "Error error message should be '" + errorMessage + "'");
    }

    @DataProvider(name = "testDataForCheckout")
    public Object[][] testDataForCheckout() {
        return new Object[][]{
                {"", "Ivanov", "22-04", "Error: First Name is required"},
                {"Ivan", "", "22-04", "Error: Last Name is required"},
                {"Ivan", "Ivanov", "", "Error: Postal Code is required"}
        };
    }
}
