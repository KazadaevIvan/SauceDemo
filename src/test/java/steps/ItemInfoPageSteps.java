package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ItemInfoPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ItemInfoPageSteps {
    private ItemInfoPage itemInfoPage;

    public ItemInfoPageSteps(WebDriver driver) {
        itemInfoPage = new ItemInfoPage(driver);
    }

    @Step("Add product to the shopping cart")
    public ItemInfoPageSteps clickAddToCartButton() {
        log.info("Add product to the shopping cart");
        itemInfoPage
                .isPageOpened()
                .clickAddToCartButton();
        return this;
    }

    @Step("Remove product from shopping cart")
    public ItemInfoPageSteps removeProductFromCart() {
        log.info("Remove product from shopping cart");
        itemInfoPage
                .clickRemoveFromCartButton();
        return this;
    }

    @Step("Validate product price is '{price}'")
    public ItemInfoPageSteps productDetailsShouldBeLike(String price) {
        log.info(String.format("Validate product price is '%s'", price));
        assertEquals(itemInfoPage.getItemPrice(), price, "Price is not correct");
        return this;
    }
}
