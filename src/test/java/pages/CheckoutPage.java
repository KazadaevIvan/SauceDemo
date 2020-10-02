package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends AbstractPage {
    public final static String CHECKOUT_PAGE_URL = "checkout-step-one.html";
    public final static By FIRST_NAME_INPUT = By.id("first-name");
    public final static By LAST_NAME_INPUT = By.id("last-name");
    public final static By POSTAL_CODE_INPUT = By.id("postal-code");
    public final static By CONTINUE_BUTTON = By.xpath("//*[@value = 'CONTINUE']");
    public final static By CANCEL_BUTTON = By.xpath("//button[@contains(text(),'CANCEL']");
    public final static By ERROR_MESSAGE = By.cssSelector("[data-test = 'error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL + CHECKOUT_PAGE_URL);
    }

    public void inputFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
    }

    public void continueButtonClick() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void inputPersonalData(String firstName, String lastName, String postalCode) {
        inputFirstName(firstName);
        inputLastName(lastName);
        inputPostalCode(postalCode);
        continueButtonClick();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
