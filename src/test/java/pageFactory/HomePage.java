package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private @FindBy(css = "i[title='Create a new playlist']")
    WebElement createAnewPlaylistButton;
    private @FindBy(css = "#playlists > nav > ul > li:nth-child(1)")
    WebElement dropMenuNewPlaylistOption;
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
    private @FindBy(css = "button[class='ok']")
    WebElement okToDeletePlaylistOption;
    private @FindBy(xpath = "//*[@id='sidebar']/section[1]/ul/li[3]/a")
    WebElement playlistAllSongs;
    private @FindBy(xpath = "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
    WebElement firstSongInList;
    private @FindBy(css = "button[class='btn-add-to']")
    WebElement addToPlaylistButton;
    private @FindBy(xpath = "//*[@id='songsWrapper']/header/div[3]/div/section[2]/form/input")
    WebElement addToPlaylistNameInputField;
    public @FindBy(css = "div[class='alertify-logs top right']")
    WebElement notificationElement;
    public @FindBy(css = "div[data-testid='sound-bar-play']")
    WebElement theSoundBar;
    public HomePage(WebDriver givenDriver) {super(givenDriver);}
    public HomePage createAnewPlaylist(){
        findElement(createAnewPlaylistButton).click();
        return this;
    }
    public HomePage chooseDropMenuNewPlaylistOption(){
        findElement(dropMenuNewPlaylistOption).click();
        return this;
    }
    public HomePage enterPlaylistName(){
        findElement(playlistNameField).sendKeys("Svyeta");
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage chooseFirstPlaylist() {
        findElement(firstPlaylist).click();
        return this;
    }
    public HomePage rightClickFirstPlaylist() {
        contextClick(firstPlaylist);           //right click
        return this;
    }
    public HomePage deletePlaylistButton() {
        findElement(deletePlaylist).click();
        return this;
    }
    public HomePage clickOkToDeletePlaylist() {
        findElement(okToDeletePlaylistOption).click();
        return this;
    }
    public HomePage getNotificationText(){
        findElement(notificationElement).isDisplayed();
        return this;
    }
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

    public HomePage clickAllSongs() {
        findElement(playlistAllSongs).click();
        return this;
    }
    public HomePage selectFirstSongInAllSongs() {
        findElement(firstSongInList).click();
        return this;
    }
    public HomePage playFirstSongInAllSongs() {
        doubleClick(firstSongInList);
        return this;
    }
    public HomePage validateTheSoundBar() {
        findElement(theSoundBar).isDisplayed();
        return this;
    }
    public HomePage addToPlaylist() {
        findElement(addToPlaylistButton).click();
        return this;
    }
    public HomePage enterPlaylistNameInDropMenu() {
        findElement(addToPlaylistNameInputField).sendKeys("student");
        findElement(addToPlaylistNameInputField).sendKeys(Keys.ENTER);
        return this;
    }
}



