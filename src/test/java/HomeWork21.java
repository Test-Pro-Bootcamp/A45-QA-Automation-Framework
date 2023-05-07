import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.time.Duration;

public class HomeWork21 extends BaseTest {

        String  newPlayListName="test pro edited playlist21";
        Actions actions;
        WebDriverWait wait;
    @Test
    public void renamePlaylist() {
            navigateToPage();
            provideEmail("mengi.gebremedhin@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            doubleClickPlaylist();
            addPlaylistName();
            Assert.assertTrue(isPlayListExist());
        }
    public   void doubleClickPlaylist()  {
                WebElement   playlistElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
                  actions.doubleClick(playlistElement).perform();
    }
    public  void addPlaylistName()  {
                WebElement  playlistInputField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=’name’]")));                  (
                    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
                    playlistInputField.sendKeys(newPlayListName);
                    playlistInputField.sendKeys(Keys.ENTER);

    public  Boolean isPlayListExist() {
                WebElement   playlistElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/a[text()=’\"+newPlayListName+\"']")));
                        return; playlistElement.isDisplayed();
                    }
    }





