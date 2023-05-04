package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;
public class LoginPage extends BasePage {

    By submitButtonLocator = By.cssSelector("button[type='submit']");
    By emailField = By.cssSelector("input[type='email']");
    By passwordFieldBox = By.cssSelector("input[type='password']");

    public LoginPage (WebDriver givenDriver) {

        super(givenDriver);
    }

    public void clickSubmitBtn () {
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail (String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void providePassword (String password) {
        WebElement passwordField = driver.findElement(passwordFieldBox);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void login () {
    provideEmail("asdASD@mail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    }
}
