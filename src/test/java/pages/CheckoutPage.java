package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CONTINUE_BUTTON);
        }
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

    public void isErrorMessageAppeared() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_MESSAGE));
        } catch (TimeoutException e) {
            Assert.fail("Сообщение не появилось. Не найдено сообщение по локатору " + ERROR_MESSAGE);
        }
    }
}
