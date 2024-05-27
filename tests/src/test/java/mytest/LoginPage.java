package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    private By emailInputBy = By.id("login-email-input"); 
    private By passwordInputBy = By.id("login-password-input"); 
    private By loginButtonBy = By.className("login-button"); 

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.trendyol.com/en/login?cb=%2F");  // URL for the login page
    }

    public MainPage login(String email, String password) {
        System.out.println("Navigated to login page");
        WebElement emailElement = this.waitAndReturnElement(emailInputBy);
        System.out.println("Email input found");
        emailElement.sendKeys(email);
        WebElement passwordElement = this.waitAndReturnElement(passwordInputBy);
        System.out.println("Password input found");
        passwordElement.sendKeys(password);
        WebElement loginButton = this.waitAndReturnElement(loginButtonBy);
        System.out.println("Login button found");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);
        return new MainPage(this.driver);  
    }
}

