package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CheckoutPageSteps {
    private CheckoutPage checkoutPage;

    public CheckoutPageSteps(WebDriver driver) {
        checkoutPage = new CheckoutPage(driver);
    }

    @Step("Attempt to continue checkout with first name '{firstName}', last name '{lastName}' and postal code '{postalCode}'")
    public CheckoutPageSteps attemptToContinueCheckout(String firstName, String lastName, String postalCode) {
        log.info(String.format("Attempt to continue checkout with first name '%s', last name '%s' and postal code '%s'",
                firstName, lastName, postalCode));
        checkoutPage
                .openPage()
                .isPageOpened()
                .attemptToContinueCheckout(firstName, lastName, postalCode);
        return this;
    }

    @Step("Continue checkout with first name '{firstName}', last name '{lastName}' and postal code '{postalCode}'")
    public CheckoutPageSteps continueCheckout(String firstName, String lastName, String postalCode) {
        log.info(String.format("Continue checkout with first name '%s', last name '%s' and postal code '%s'",
                firstName, lastName, postalCode));
        checkoutPage
                .openPage()
                .isPageOpened()
                .continueCheckout(firstName, lastName, postalCode);
        return this;
    }

    @Step("Validate error message is: '{errorMessage}'")
    public CheckoutPageSteps errorMessageShouldBeLike(String errorMessage) {
        log.info(String.format("Validate error message is: '%s'", errorMessage));
        String actualResult = checkoutPage
                .isErrorMessageAppeared()
                .getErrorMessageText();
        assertEquals(actualResult, errorMessage, "Error error message should be '" + errorMessage + "'");
        return this;
    }
}
