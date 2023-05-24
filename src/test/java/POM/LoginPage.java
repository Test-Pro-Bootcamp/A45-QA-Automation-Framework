package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    By clickSubmit = By.xpath("//button[@type='submit']");
    By provideEmail = By.xpath("//input[@type='email']");
    By providePassword = By.xpath("//input[@type='password']");


    public LoginPage( WebDriver givenDriver){
        super(givenDriver);
    }
    public void clickSubmit (){
        driver.findElement(clickSubmit).click();
    }
    public void provideEmail( String email){
        WebElement emailElement = driver.findElement(provideEmail);
        emailElement.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordElement = driver.findElement(providePassword);
        passwordElement.sendKeys(password);
    }
    public void login(){
        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();

    }
}