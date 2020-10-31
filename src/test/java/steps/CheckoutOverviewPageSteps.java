package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverviewPage;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewPageSteps {
    private CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutOverviewPageSteps(WebDriver driver) {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Step("Validate product '{productName}' details is quantity: '{quantity}', price: '{price}'")
    public CheckoutOverviewPageSteps productDetailsShouldBeLike(String productName, String quantity, String price) {
        checkoutOverviewPage
                .openPage()
                .isPageOpened();
        assertEquals(checkoutOverviewPage.getProductPrice(productName), price, "Price is not correct");
        assertEquals(checkoutOverviewPage.getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    @Step("Validate total product price is: '{totalPrice}'")
    public CheckoutOverviewPageSteps totalPriceShouldBeLike(Double totalPrice) {
        checkoutOverviewPage
                .openPage()
                .isPageOpened();
        assertEquals(checkoutOverviewPage.getSumOfAllItemsPrices(), totalPrice,
                "Total price is not correct");
        return this;
    }

    @Step("Click FINISH button")
    public CheckoutOverviewPageSteps finishButtonClick() {
        checkoutOverviewPage
                .isPageOpened()
                .finishButtonClick();
        return this;
    }
}
