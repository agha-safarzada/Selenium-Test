package mytest;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch() {
        MainPage mainPage = new MainPage(this.driver);
        SearchResultPage searchResultPage = mainPage.search("shoes");
        Assert.assertTrue(searchResultPage.isProductDisplayed("shoes"));
    }

    @Test
    public void testFooterText() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("2024")); // Adjust based on actual footer content
    }

    @Test
    public void testStaticPage() {
        driver.get("https://www.trendyol.com/en/s/shipping-return");
//        Assert.assertTrue(driver.getTitle().contains("Shipping & Delivery"));
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Shipping & Delivery"));
    }

    @Test
    public void testMultipleStaticPages() {
        String[] urls = {
                "https://www.trendyol.com/en/help",
                "https://www.trendyol.com/en/s/meet-us",
        };

        for (String url : urls) {
            driver.get(url);
            Assert.assertTrue(driver.getTitle().contains("Trendyol"));
        }
    }
    @Test
    public void testLoginAndLogout() {
        LoginPage loginPage = new LoginPage(this.driver);
        MainPage mainPage = loginPage.login("agha.safarzade@gmail.com", "Eyciey03$");


        Assert.assertTrue(driver.getPageSource().contains("Trendyol")); 
        LogoutPage logoutPage = new LogoutPage(this.driver);
        logoutPage.logout();


        Assert.assertTrue(driver.getCurrentUrl().contains("/")); 
    }


    @Test
    public void testPageTitle() {
        driver.get("https://www.trendyol.com/en");
        String expectedTitle = "Trendyol | Shop for Latest Fashion Trends & Accessories";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
