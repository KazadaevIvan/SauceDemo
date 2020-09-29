import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;
    By allItemsOption = By.id("inventory_sidebar_link");
    By aboutOption = By.id("about_sidebar_link");
    By logoutOption = By.id("logout_sidebar_link");
    By resetAppStateOption = By.id("reset_sidebar_link");
    By closeButton = By.xpath("//button[text()='Close Menu']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickAllItemsOption() {
        driver.findElement(allItemsOption).click();
        return new HomePage(driver);
    }

    public void clickAboutOption() {
        driver.findElement(aboutOption).click();
    }

    public LoginPage clickLogoutOption() {
        driver.findElement(logoutOption).click();
        return new LoginPage(driver);
    }

    public void clickResetAppStateOption() {
        driver.findElement(resetAppStateOption).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}
