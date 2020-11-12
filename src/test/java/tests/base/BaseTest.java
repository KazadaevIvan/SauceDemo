package tests.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CheckoutOverviewPage;
import steps.*;
import utils.CapabilitiesGenerator;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    public static final String USERNAME = System.getenv().getOrDefault("username", PropertyReader.getProperty("username"));
    public static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    public WebDriver driver;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected ProductPageSteps productPageSteps;
    protected CartPageSteps cartPageSteps;
    protected LoginPageSteps loginPageSteps;
    protected CheckoutOverviewPageSteps checkoutOverviewPageSteps;
    protected CheckoutPageSteps checkoutPageSteps;
    protected FinishPageSteps finishPageSteps;
    protected ItemInfoPageSteps itemInfoPageSteps;
    protected MenuPageSteps menuPageSteps;

    @BeforeMethod(description = "Open browser")
    public void setUp() {
        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (IllegalStateException e) {
            log.fatal(e.getLocalizedMessage());
            Assert.fail("Driver has not been initialized. Please, check if driver version is correct");
        }
        driver.manage().window().maximize();
        int implicitlyWaitTimer = 10;
        log.debug(String.format("Set implicit wait for %s seconds", implicitlyWaitTimer));
        driver.manage().timeouts().implicitlyWait(implicitlyWaitTimer, TimeUnit.SECONDS);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        productPageSteps = new ProductPageSteps(driver);
        cartPageSteps = new CartPageSteps(driver);
        loginPageSteps = new LoginPageSteps(driver);
        checkoutOverviewPageSteps = new CheckoutOverviewPageSteps(driver);
        checkoutPageSteps = new CheckoutPageSteps(driver);
        finishPageSteps = new FinishPageSteps(driver);
        itemInfoPageSteps = new ItemInfoPageSteps(driver);
        menuPageSteps = new MenuPageSteps(driver);
    }

    @AfterMethod(description = "Close browser", alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}