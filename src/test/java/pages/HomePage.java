package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String newPlaylistName = null;
    //locator
    @FindBy(css = "li.playlist:nth-child(3)")
    private WebElement firstPlaylist;
    //private By firstPlaylist = By.cssSelector("li.playlist:nth-child(3)");
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    //private By playlistNameField = By.cssSelector("[name='name']");
    @FindBy(xpath = "//a[text()='kristina.matskaylo2']")
    private WebElement newPlaylist;
    @FindBy(css = "img.avatar")
    private WebElement userAvatar;


    @FindBy(xpath = "//span[@data-testid='play-btn']")
//#1 maybe need to be in other page, because this we can see in all pages
    private WebElement playButton;
    @FindBy(xpath = "//*[@title='Play next song']") //#1
    private WebElement playNextSongButton;
    @FindBy(xpath = "//button[@data-testid='toggle-visualizer-btn']")//#1
    private WebElement soundBar;


    @FindBy(css = "input[type='search']")
    private WebElement searchField;


    @FindBy(xpath = "//section[@id='playlists']/ul/li[3]")
    private WebElement openMyPlaylist;
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
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesNewPlaylistexist(String newPlaylisrtName) {
        //By newPlaylist = By.xpath("//a[text()='kristina.matskaylo2']");
        // return findElement(newPlaylist).isDisplayed();
        return newPlaylist.isDisplayed();
    }

    public boolean isUserAvatarDisplayed() {
        return userAvatar.isDisplayed();
    }


    public HomePage clickPlayButton() {
        playButton.click();
        return this;
    }

    public HomePage clickPlayNextSongButton() {
        playNextSongButton.click();
        return this;
    }

    public boolean songPlaying() {
        return soundBar.isDisplayed();
    }

    public HomePage searchSong(String songname) {
        // WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songname);
        searchField.click();
        return this;
    }
    public HomePage navigateToPlaylist(){
       // WebElement openMyPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]"));
        openMyPlaylist.click();
        return this;
    }
    public HomePage clickRedBtnPlaylist(){
       // WebElement redBtnDeletePlaylist = driver.findElement(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']"));
        redBtnDeletePlaylist.click();
        return this;
    }
    public String actualNotificationText ()  {
        //WebElement getActualNotificationText = driver.findElement(By.cssSelector("div.success.show"));
        return getActualNotificationText.getText();
    }
}
