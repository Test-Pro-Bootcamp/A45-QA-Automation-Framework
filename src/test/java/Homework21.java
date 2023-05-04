import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String playlistName = null;
    @Test
    public void renamePlaylist() throws InterruptedException {
        validLoginCredentials();
        clickRecentlyPlayed();
        choosePlaylist();
        editOptionButton();
        checkPlaylistExist();
    }
    public void clickRecentlyPlayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("a[href='#!/recently-played']"))).click();
    }
    public void choosePlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='playlists']/ul/li[3]/a"))).click();
        WebElement playlistName = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        actions.contextClick(playlistName).perform();
    }
    public void editOptionButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath(" //*[@id='playlists']/ul/li[3]/nav/ul/li[1]"))).click();
    }
    public void changePlaylistName(){
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("a[href='#!/playlist/55914']>input")));
         WebElement inputRenamePlaylistField = driver.findElement(By.cssSelector
                         ("a[href='#!/playlist/55914']>input"));
         inputRenamePlaylistField.clear();
         inputRenamePlaylistField.sendKeys("SNKim");
         inputRenamePlaylistField.sendKeys(Keys.ENTER);
     }
     public boolean checkPlaylistExist(){
        WebElement playlistExistElement = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        return playlistExistElement.isDisplayed();
     }
}

