package tests.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utils.CapabilitiesGenerator;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

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

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
    }

    @Step("Open browser")
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkoutOverviewPage= new CheckoutOverviewPage(driver);
        productPageSteps = new ProductPageSteps(driver);
        cartPageSteps = new CartPageSteps(driver);
        loginPageSteps = new LoginPageSteps(driver);
        checkoutOverviewPageSteps = new CheckoutOverviewPageSteps(driver);
        checkoutPageSteps = new CheckoutPageSteps(driver);
        finishPageSteps = new FinishPageSteps(driver);
        itemInfoPageSteps = new ItemInfoPageSteps(driver);
        menuPageSteps = new MenuPageSteps(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}