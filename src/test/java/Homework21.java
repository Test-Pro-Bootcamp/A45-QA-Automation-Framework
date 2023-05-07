import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist (){
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        click(".playlist:nth-child(3)");
        addPlaylist("[name='name']", "Test");
        Assert.assertTrue(playListExist("//a[text()='Test']"));
    }

    public void click(String element) {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        actions.doubleClick(submit).perform();
    }

    public void addPlaylist(String element, String playList) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        input.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        input.sendKeys(playList);
        input.sendKeys(Keys.ENTER);
    }

    public boolean playListExist(String path) {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return submit.isDisplayed();
    }
}
