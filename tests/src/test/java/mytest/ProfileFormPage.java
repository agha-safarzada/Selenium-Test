package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileFormPage extends BasePage {

    private By usernameBy = By.name("username");
    private By radioButtonBy = By.id("radio-button-id"); 
    private By checkBoxBy = By.id("check-box-id"); 
    private By saveButtonBy = By.cssSelector(".save-button");

    public ProfileFormPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.trendyol.com/user/profile"); 
    }

    public void fillForm(String username, boolean selectRadio, boolean checkCheckbox) {
        this.waitAndReturnElement(usernameBy).clear();
        this.waitAndReturnElement(usernameBy).sendKeys(username);

        if (selectRadio) {
            this.waitAndReturnElement(radioButtonBy).click();
        }

        if (checkCheckbox) {
            this.waitAndReturnElement(checkBoxBy).click();
        }

        this.waitAndReturnElement(saveButtonBy).click();
    }
}
