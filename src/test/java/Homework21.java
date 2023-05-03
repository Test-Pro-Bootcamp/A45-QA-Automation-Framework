import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException {
        validLoginCredentials();
        clickAllSongs();
        choosePlaylist();
        doubleClickPlaylistSvyeta();
        enterRenamedPlaylistName();
    }

    public void choosePlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("ul>li>a[href='#!/playlist/55770']"))).click();
    }
    public void doubleClickPlaylistSvyeta(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul>li>a[href='#!/playlist/55770']")));
        WebElement playlistSvyeta = driver.findElement(By.cssSelector("ul>li>a[href='#!/playlist/55770']"));
        actions.doubleClick(playlistSvyeta).perform();
    }
     public void enterRenamedPlaylistName(){
         WebElement inputRenamePlaylistField = driver.findElement(By.cssSelector
               ("input[name='name']"));
         inputRenamePlaylistField.clear();
         inputRenamePlaylistField.sendKeys("SNKim");
         inputRenamePlaylistField.sendKeys(Keys.ENTER);
     }
}

