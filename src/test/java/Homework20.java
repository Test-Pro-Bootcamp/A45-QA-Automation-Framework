import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist(){
        navigateToPage();
        provideEmail("bolormaa.zanabaatar@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        click(".playlist:nth-child(3)");
        click(".btn-delete-playlist");
        Assert.assertTrue(getNotification("div.success.show").contains("Deleted"));
    }

    public void click(String element) {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
        submit.click();
    }

    public String getNotification(String element) {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
        return submit.getText();
    }

}