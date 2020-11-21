package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverviewPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CheckoutOverviewPageSteps {
    private CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutOverviewPageSteps(WebDriver driver) {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Step("Validate product '{productName}' details is quantity: '{quantity}', price: '{price}'")
    public CheckoutOverviewPageSteps productDetailsShouldBeLike(String productName, String quantity, String price) {
        log.info(String.format("Validate product '%s' details is quantity: '%s', price: '%s'",
                productName, quantity, price));
        checkoutOverviewPage
                .openPage()
                .isPageOpened();
        assertEquals(checkoutOverviewPage.getProductPrice(productName), price, "Price is not correct");
        assertEquals(checkoutOverviewPage.getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    @Step("Validate total product price is: '{totalPrice}'")
    public CheckoutOverviewPageSteps totalPriceShouldBeLike(Double totalPrice) {
        log.info(String.format("Validate total product price is: '%s'", totalPrice));
        checkoutOverviewPage
                .openPage()
                .isPageOpened();
        assertEquals(checkoutOverviewPage.getSumOfAllItemsPrices(), totalPrice,
                "Total price is not correct");
        return this;
    }

    @Step("Click FINISH button")
    public CheckoutOverviewPageSteps finishButtonClick() {
        log.info("Click FINISH button");
        checkoutOverviewPage
                .isPageOpened()
                .finishButtonClick();
        return this;
    }
}
