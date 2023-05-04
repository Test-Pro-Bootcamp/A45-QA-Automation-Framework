import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21  extends BaseTest{
    String newNameForPlaylist = "kristina.matskaylo2";
    @Test
    public void renamePlaylist(){
       // String newNameForPlaylist = "kristina.matskaylo2";
        enterEmail("kristina.matskaylo@testpro.io");
        enterPassword("11111111*a");
        submitLogIn();
        //double click by mouse on playlist
        doubleClickOnPlaylist("kristina.matskaylo");
        //clean field and set new name for playlist
        setNewPLaylistName();
        //"Then"- expected result: that new playlist is displayed
        Assert.assertTrue(appearNewPlaylist());
    }

    public void setNewPLaylistName() {
        WebElement playlistTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        playlistTextField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistTextField.sendKeys(newNameForPlaylist);
        playlistTextField.sendKeys(Keys.ENTER);
    }
    public void doubleClickOnPlaylist(String name) {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']//li[3]")));
        actions.doubleClick(myPlaylist).perform();
    }
    public boolean appearNewPlaylist(){
        WebElement myNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newNameForPlaylist+"']")));
        return myNewPlaylist.isDisplayed();
    }
    }



