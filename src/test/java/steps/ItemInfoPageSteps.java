package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ItemInfoPage;

import static org.testng.Assert.assertEquals;

public class ItemInfoPageSteps {
    private ItemInfoPage itemInfoPage;

    public ItemInfoPageSteps(WebDriver driver) {
        itemInfoPage = new ItemInfoPage(driver);
    }

    @Step("Add product to the shopping cart")
    public ItemInfoPageSteps clickAddToCartButton() {
        itemInfoPage
                .isPageOpened()
                .clickAddToCartButton();
        return this;
    }

    @Step("Open shopping cart")
    public ItemInfoPageSteps openShoppingCart() {
        itemInfoPage
                .clickShoppingCartIcon();
        return this;
    }

    @Step("Remove product from shopping cart")
    public ItemInfoPageSteps removeProductFromCart() {
        itemInfoPage
                .clickRemoveFromCartButton();
        return this;
    }

    @Step("Validate product price is '{price}'")
    public ItemInfoPageSteps productDetailsShouldBeLike(String price) {
        assertEquals(itemInfoPage.getItemPrice(), price, "Price is not correct");
        return this;
    }
}
