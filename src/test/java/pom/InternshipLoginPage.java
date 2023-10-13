package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternshipLoginPage extends BasePage {

    public InternshipLoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[Type='password']");
    private By submitBtn = By.cssSelector("button[Type='submit']");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void loginInitialPassword() {
        provideEmail("esther.martinez32@gmail.com");
        providePassword("Proverbs99!");
        clickSubmit();
    }
    public void loginNewPassword() {
        provideEmail("esther.martinez32@gmail.com");
        providePassword("IwillSing99!");
        clickSubmit();
    }

    public WebElement submitBtn() {
        return findElement(submitBtn);
    }
}

