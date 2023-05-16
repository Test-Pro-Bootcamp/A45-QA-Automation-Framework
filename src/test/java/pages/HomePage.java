package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(css = "button.btn-submit")
    WebElement saveButton;
    @FindBy(css = "[data-testid='play-btn']")
    WebElement playButton;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement inputPlaylistNameField;
    @FindBy(xpath = "//a[text()=\"playlistName\"]")
    WebElement playlistElement;
    public WebElement userAvatar () {return userAvatarIcon;}
    public HomePage clickAvatarIcon () {userAvatarIcon.click();return this;}
    public HomePage clickSaveButton() {saveButton.click();return this;}
    public  HomePage clickPlayButton(){playButton.click();return this;}
    public void doubleClickFirstPlaylist() {doubleClick(firstPlaylist);}
    public HomePage enterPlaylistName(String playlistName){
        inputPlaylistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputPlaylistNameField.sendKeys(playlistName);
        inputPlaylistNameField.sendKeys(Keys.ENTER);
        return this;
    }
    public boolean playlistExists(String playlistName){
        WebElement playlistElement = findElementBy(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
}

