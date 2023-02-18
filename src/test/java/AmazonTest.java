import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AmazonTest {
    public WebDriver driver;
    //public String testURL = "http://www.amazon.com";
    AmazonHomePage objHomePage;
    AmazonSearchPage objSearchPage;
    AmazonProductPage objProductPage;
    AmazonCartPage objCartPage;
    AmazonFiltersPage objFiltersPage;
    AmazonSettingsPage objSettingsPage;

    @BeforeMethod
    @Parameters("Browser")
    public void Browserlaunch (String Browser) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        if (Browser.equals("chrome")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");

            ChromeOptions options = new ChromeOptions();
            options.merge(cap);

        } else if (Browser.equals("MicrosoftEdge")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("MicrosoftEdge");

            EdgeOptions options = new EdgeOptions();
            options.merge(cap);
        }

        driver = new RemoteWebDriver(new URL("http://192.168.0.11:4444"), cap);
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
    @Test
    public void productSearchTest() throws InterruptedException {
        Thread.sleep(4000);
        objHomePage = new AmazonHomePage(driver);
        objHomePage.searchProduct("fish tank");
        objSearchPage = new AmazonSearchPage(driver);
        objSearchPage.sortProducts();
        Thread.sleep(4000);
        objSearchPage.chooseProduct();
        Thread.sleep(4000);
    }

    @Test
    public void checkCartTest () throws InterruptedException {
        Thread.sleep(4000);
        objHomePage = new AmazonHomePage(driver);
        objHomePage.searchProduct("fish tank");
        objSearchPage = new AmazonSearchPage(driver);
        objSearchPage.chooseProduct();
        objProductPage = new AmazonProductPage(driver);
        objProductPage.addProductToCart("Added to Cart");
        Thread.sleep(4000);
    }

    @Test
    public void deleteProductTest () throws InterruptedException {
        Thread.sleep(4000);
        objHomePage = new AmazonHomePage(driver);
        objHomePage.searchProduct("fish tank");
        objSearchPage = new AmazonSearchPage(driver);
        objSearchPage.chooseProduct();
        objProductPage = new AmazonProductPage(driver);
        objProductPage.addProductToCart("Added to Cart");
        objCartPage = new AmazonCartPage(driver);
        //WebElement testDelete = driver.findElement(By.className("a-padding-medium"));
        objCartPage.deleteFromCart();
        Thread.sleep(4000);
    }

    @Test
    public void checkFiltersTest () throws InterruptedException {
        objHomePage = new AmazonHomePage(driver);
        objHomePage.checkAll();
        objFiltersPage = new AmazonFiltersPage(driver);
        objFiltersPage.tryFilters();
        objFiltersPage.chooseProduct();
    }

    @Test
    public void changeSettingsTest () throws InterruptedException{
        objHomePage = new AmazonHomePage(driver);
        objHomePage.changeSettings();
        objSettingsPage = new AmazonSettingsPage(driver);
        objSettingsPage.changeLanguage();
        objSettingsPage.changeCurrency();
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
