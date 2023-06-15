package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage{

    By saveButton = By.cssSelector("button.btn-submit");
    By profileNameField = By.cssSelector("[name='name']");
    By currentPasswordField = By.cssSelector("[name='current_password']");

    By actualProfileName = By.cssSelector("a.view-profile>span");

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public  void clickSaveButton() {
        findElement(saveButton).click();
    }
    public void provideProfileName(String randomName) {
        findElement(profileNameField).clear();
        findElement(profileNameField).sendKeys(randomName);
    }
    public void provideCurrentPassword(String password) {
        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(password);
    }
    public  String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getCurrentProfileName(){
        return findElement(actualProfileName).getText();
    }

}
