package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

//    private @FindBy(css = "a[href='#!/playlist/55914']")
//    WebElement firstPlaylist;

    private @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")
    WebElement playlistEditButton;

    private @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    private @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    private @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    WebElement firstPlaylist;
    private @FindBy(css = "button[class='del btn-delete-playlist']")
    WebElement deletePlaylist;
    public @FindBy(css = "div[class='alertify-logs top right']")
    WebElement notificationElement;

    public HomePage(WebDriver givenDriver) {super(givenDriver);}
    public HomePage chooseFirstPlaylist() {
        findElement(firstPlaylist).click();
        return this;
    }
    public HomePage deletePlaylistButton() {
        findElement(deletePlaylist).click();
        return this;
    }
    public boolean getNotificationText(Object By){
        return findElement(notificationElement).isDisplayed();
    }
//        WebElement notificationElement = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
//        return notificationElement.getText();
//    public boolean seeMessageTopRightAppeared() {
//        findElement(messageTopRightAppeared).getText();
//        return this.seeMessageTopRightAppeared();
//    }
    public HomePage doubleClickFirstPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage clickEditPlaylistButton(){
        findElement(playlistEditButton).click();
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys("");
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys("SNKim");
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage retrievePlaylistName() {
        findElement(firstPlaylist).getText();
        return this;
    }

    public boolean getUserAvatar() {
        return findElement(avatarIcon).isDisplayed();
    }

}




