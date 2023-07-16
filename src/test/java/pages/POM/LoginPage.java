package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //locators
    By clickSubmit = By.xpath("//button[@type='submit']");
    By provideEmail = By.xpath("//input[@type='email']");
    By providePassword = By.xpath("//input[@type='password']");

    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }
    public void clickSubmit (){
        driver.findElement(clickSubmit).click();
    }
    public void provideEmail (String email){
        WebElement emailElement = driver.findElement(provideEmail);
        emailElement.sendKeys(email);
    }
    public void providePassword (String password){
    WebElement passwordElement = driver.findElement(providePassword);
    passwordElement.sendKeys(password);
    }
    public void login(){
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}

