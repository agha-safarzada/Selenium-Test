package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileFormPage extends BasePage {

    private By usernameBy = By.name("username");
    private By radioButtonBy = By.id("radio-button-id"); // Adjust ID accordingly
    private By checkBoxBy = By.id("check-box-id"); // Adjust ID accordingly
    private By saveButtonBy = By.cssSelector(".save-button");

    public ProfileFormPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.trendyol.com/user/profile"); // Adjust URL accordingly
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
