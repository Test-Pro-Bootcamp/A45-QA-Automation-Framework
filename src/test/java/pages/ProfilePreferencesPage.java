package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePreferencesPage extends BasePage {
    public ProfilePreferencesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By currentPassword = By.cssSelector("[name='current_password']");
    By profileName = By.cssSelector("[name='name']");

    public void provideCurrentPassword(String password) {
        findElement(currentPassword).sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void provideProfileName(String randomName){
        findElement(profileName).sendKeys(randomName);
    }

}