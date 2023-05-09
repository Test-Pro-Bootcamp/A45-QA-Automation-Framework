import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends  BaseTest{
    @Test
    public void renamePlaylist(){

        logIn("heavenmayhem@gmail.com","Everything2Me0628!");
        choosePlaylist();
        editPlaylist();
        enterNewName();
        Assert.assertTrue(doesPlaylistExist());
    }

    public boolean doesPlaylistExist() {
        WebElement playlistCreated = driver.findElement(By.xpath("//a[text()='"+newPlaylistName+"']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        return playlistCreated.isDisplayed();
    }

}
