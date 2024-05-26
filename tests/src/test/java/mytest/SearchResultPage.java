package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {

    private By searchResultsBy = By.xpath("//input[@class='search-bar']"); ;  // Adjust the selector based on actual search result element

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed(String searchQuery) {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsBy));
        return searchResults.getText().toLowerCase().contains(searchQuery.toLowerCase());
    }
}
