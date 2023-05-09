package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePreferencesPage extends BasePage{
    public ProfilePreferencesPage(WebDriver givenDriver) {super(givenDriver);}
    @FindBy(css = "[name='name']")
    WebElement profileName;
    @FindBy(css = "[name='current_password']")
    WebElement currentPassword;
    public ProfilePreferencesPage provideProfileName(String randomName) {
        profileName.clear();
        profileName.sendKeys(randomName);
        return this;}
    public ProfilePreferencesPage provideCurrentPassword(String password) {currentPassword.sendKeys(password);
        return this;}
}
