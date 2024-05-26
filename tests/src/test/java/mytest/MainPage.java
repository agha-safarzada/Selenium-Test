package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    private By footerBy = By.className("footer");
    private By searchBarBy = By.className("search-bar-wrapper");
    private By searchInputBy = By.className("search-bar");
    private By userMenuBy = By.className("user-wrapper");  
    private By logoutButtonBy = By.xpath("//span[text()='Sign out']");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.trendyol.com/");
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarBy).click();
        this.waitAndReturnElement(searchInputBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }
    public void logout() {
        WebElement userMenuElement = this.waitAndReturnElement(userMenuBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(userMenuElement).perform();
        
        // Use JavascriptExecutor to click the logout button
        WebElement logoutButton = this.waitAndReturnElement(logoutButtonBy);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutButton);
    }

}
