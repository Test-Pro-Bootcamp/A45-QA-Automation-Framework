package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage (WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy (xpath = "//section[@id='playlists']//li[5]")
    private WebElement findPlaylist;
    @FindBy (css = "input[name='name']")
    private WebElement playlistNameField;

    public HomePage doubleClickPlaylist(){
        doubleClick((By) findPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName (String playlistName) {
        findElement((By) playlistNameField).sendKeys(playlistName);
        findElement((By) playlistNameField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        findElement((By) playlistNameField).sendKeys(playlistName);
        findElement((By) playlistNameField).sendKeys((Keys.ENTER));
        return this;
    }
    public boolean doesPlaylistExist (String playlistName){
            By newPlaylist = By.xpath("//a[text()='" + playlistName + "']");
            return findElement(newPlaylist).isDisplayed();
        }
    public boolean assertAvatar() {
        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        //driver.findElement(By.cssSelector("img.avatar"));
        return usersAvatar.isDisplayed();

    }}


