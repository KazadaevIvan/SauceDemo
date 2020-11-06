package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;

public class MenuPageSteps {
    MenuPage menuPage;

    public MenuPageSteps(WebDriver driver) {
        menuPage = new MenuPage(driver);
    }

    @Step("Logout")
    public MenuPageSteps logout() {
        menuPage
                .clickLogoutOption()
                .isPageOpened();
        return this;
    }

    @Step("Open About page")
    public MenuPageSteps openAboutPage() {
        menuPage
                .clickAboutOption()
                .isPageOpened();
        return this;
    }
}
