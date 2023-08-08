package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By findPlaylist= By.xpath("//section[@id='playlists']//li[5]");
    private By playlistNameField= By.cssSelector("input[name='name']");

    public void assertAvatar() {
        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        //driver.findElement(By.cssSelector("img.avatar")); old code
        Assert.assertTrue(usersAvatar.isDisplayed());
    }
    public void doubleClickPlaylist(){
        doubleClick(findPlaylist);
    }
    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.ENTER));
    }

    public boolean doesPlaylistExist(String playlistName){
        By newPlaylist=By.xpath("//a[text()='"+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }
}
