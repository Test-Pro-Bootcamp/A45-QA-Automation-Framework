package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By inputPlaylistNameField = By.cssSelector("input[name='name']");

    By avatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public  void doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
    }
    public void enterPlaylistName(String playlistName){
        WebElement playlistNameField = findElement(inputPlaylistNameField);
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }
    public boolean playlistExists(String playlistName){
        WebElement playlistElement = findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
    public void clickAvatarIcon() {
        WebElement avatarIcon = findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}
