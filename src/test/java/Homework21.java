import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String playlistName = null;
    private WebElement driver;

    @Test
    public void renamePlaylist() throws InterruptedException {
        validLoginCredentials();
        choosePlaylist();        //let's comment these steps first and check the test behavior
        clickEditOptionButton();
        changePlaylistName();
        checkPlaylistExist();
    }

    public void choosePlaylist(){
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        actions.contextClick(playlistName).perform();
    }
    public void clickEditOptionButton(){
        WebElement editOptionButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")));
        editOptionButton.click();
    }
    public void changePlaylistName(){
        WebElement inputRenamePlaylistField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[name='name']")));
//      inputRenamePlaylistField.clear();//clear won't work since the playlist name field has an attribute of "required"
//work around will be using sendkeys CTRL + A then hitting backspace or delete to remove current playlist name and replace with new name
        inputRenamePlaylistField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        inputRenamePlaylistField.sendKeys("SNKim");
        inputRenamePlaylistField.sendKeys(Keys.ENTER);
     }
     public void checkPlaylistExist(){
        WebElement playlistExistElement = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        playlistExistElement.isDisplayed();
     }
}

