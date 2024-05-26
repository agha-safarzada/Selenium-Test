package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LogoutPage extends BasePage {

    private By userMenuBy = By.xpath("//div[@class='user-wrapper menu-item']");
    private By logoutButtonBy = By.xpath("//span[text()='Sign out']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        WebElement userMenuElement = this.waitAndReturnElement(userMenuBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(userMenuElement).perform();
        WebElement logoutButton = this.waitAndReturnElement(logoutButtonBy);
        actions.moveToElement(logoutButton).click().perform();
    }
}

