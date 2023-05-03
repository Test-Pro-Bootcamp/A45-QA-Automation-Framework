import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){

        navigateToPage();
        provideEmail("amanda.martins@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        rightClickOnPlaylist();
        selectEdit();
        changeName();
    }

    public void rightClickOnPlaylist () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper #sidebar #playlists li:nth-child(3)")));
        actions.contextClick(driver.findElement(By.cssSelector("#mainWrapper #sidebar #playlists li:nth-child(3)"))).perform();
    }

    public void selectEdit () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu.playlist-item-menu li:nth-child(1)")));
        actions.click(driver.findElement(By.cssSelector(".menu.playlist-item-menu li:nth-child(1)"))).perform();
    }

    public void changeName () {
        WebElement editField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys("MyPlaylist");
        editField.sendKeys(Keys.ENTER);

        WebElement upDatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper #sidebar #playlists a.active")));
        Assert.assertEquals(upDatedName.getText(),"MyPlaylist");
    }
}
