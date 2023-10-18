package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.UUID;

public class InternshipProfilePreferences extends BasePage {
    public InternshipProfilePreferences(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By emailField = By.cssSelector("input[type='email']");
    private By newPasswordField = By.cssSelector("input[id='inputProfileNewPassword']");
    private By avatar = By.xpath("//span//img[@class='avatar']");
    private By provideCurrentPassword = By.cssSelector("input[name='current_password']");
    private By inputName = By.xpath("//*[@id='inputProfileName']");
    private By submit = By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']");
    private By newProfileName = By.xpath("//span[@class='name']");
    private By popUpMessage = By.cssSelector("div[class='success show']");
    WebElement popup = driver.findElement(By.cssSelector("div[class='success show']"));
    String success = "Profile updated.";

    public String getRandomString() {
        return UUID.randomUUID().toString().replace("", "");
    }

    public void openUserProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(avatar));
        //waitForLoadingBarToDisappear();//found in basepage as an option instead of above wait
        findElement(avatar).click();
    }
    //    *Add an explicit wait for the loading bar to become invisible or disabled before attempting to click the user avatar image. This ensures that the desired element is clickable once the loading bar is no longer in the way.
//            *Alternatively, you can add a wait for the user avatar element to become clickable. Hope it helps
    public void provideTestEmail(String email) {
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void provideCurrentPassword(String password) {
        findElement(provideCurrentPassword).sendKeys(password);
    }

    public void setNewPassword(String password) {
        findElement(newPasswordField).clear();
        findElement(newPasswordField).sendKeys(password);
    }

    public void setNewName(String newName) {
        findElement(inputName).clear();
        findElement(inputName).sendKeys(newName);
    }

    public void saveProfile() {
        findElement(submit).click();
    }

    public String profileUpdateSuccess() {
        findElement(popUpMessage);
        return findElement(newProfileName).getText();
    }
public String getNotificationMessage(){//trying this
        findElement(popUpMessage);
        return findElement(popUpMessage.getText);
}
}


