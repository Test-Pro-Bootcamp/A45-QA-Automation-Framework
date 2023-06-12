package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {
    //String newPlaylistName;
    @FindBy(css = "li.playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(xpath = "//a[text()='kristina.matskaylo2']")
    private WebElement newPlaylist;
    @FindBy(css = "img.avatar")
    private WebElement userAvatar;
    @FindBy(xpath = "//span[@data-testid='play-btn']")
    private WebElement playButton;
    @FindBy(xpath = "//*[@data-testid='play-next-btn']")
    private WebElement playNextSongButton;
    @FindBy(xpath = "//button[@data-testid='toggle-visualizer-btn']")
    private WebElement soundBar;
    @FindBy(xpath = "//div[@data-test='song-list-controls']//button[@title='Delete this playlist']")
    private WebElement redBtnDeletePlaylist;
    @FindBy(css= "div.success.show")
    private WebElement getActualNotificationText;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage doubleClickFirstPlaylist() {
        doubleClickElement(firstPlaylist);
        return this;
    }
    public HomePage enterNewPLaylistName(String newPlaylistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesNewPlaylistexist(String newPlaylistName) {
        return findElement(newPlaylist).isDisplayed();
    }
    public boolean isUserAvatarDisplayed() {
        return findElement(userAvatar).isDisplayed();
    }
    public HomePage clickPlayButton() {
        findElement(playButton).click();
        return this;
    }
    public HomePage clickPlayNextSongButton() {
        playNextSongButton.click();
        return this;
    }

    public boolean songPlaying() {
        return findElement(soundBar).isDisplayed();
    }
    public HomePage navigateToFirstPlaylist(){
        findElement(firstPlaylist).click();
        return this;
    }
    public HomePage clickRedBtnPlaylist(){
        findElement(redBtnDeletePlaylist).click();
        return this;
    }
    public String actualNotificationText ()  {
        return findElement(getActualNotificationText).getText();
    }
}
