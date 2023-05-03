
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Daria45";//moved the string initializatioion outside @Test method
    @Test
        public void renamePlaylist () {
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();
            doubleClickPlaylist();
            enterNewPlaylistName();
            Assert.assertTrue(doesPlaylistExist());
        }

        public void doubleClickPlaylist() {
            WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));//added 1 closing parenthesis
//WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//*[@id="playlists"]/ul/li[3]/a)));
            actions.doubleClick(playlistElement).perform();
        }

public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));//removed extra paraenthesis
    playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
    playlistInputField.sendKeys(newPlaylistName);
    playlistInputField.sendKeys(Keys.ENTER);

    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//a*[@id="playlists"]/ul/li[3]/input)))
        return playlistElement.isDisplayed();

    }
}

