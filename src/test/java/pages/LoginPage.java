package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //locators

    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void provideEmail(String email){
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement emailElement = driver.findElement(passwordField);
        emailElement.clear();
        emailElement.sendKeys(password);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }
    public void login(){
        provideEmail("kristina.matskaylo@testpro.io");
        providePassword("11111111*a");
        clickSubmitBtn();
    }

}
