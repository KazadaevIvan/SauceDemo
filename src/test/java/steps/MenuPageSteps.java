package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;

@Log4j2
public class MenuPageSteps {
    MenuPage menuPage;

    public MenuPageSteps(WebDriver driver) {
        menuPage = new MenuPage(driver);
    }

    @Step("Logout")
    public MenuPageSteps logout() {
        log.info("Logout");
        menuPage
                .clickLogoutOption()
                .isPageOpened();
        return this;
    }

    @Step("Open About page")
    public MenuPageSteps openAboutPage() {
        log.info("Open About page");
        menuPage
                .clickAboutOption()
                .isPageOpened();
        return this;
    }
}
