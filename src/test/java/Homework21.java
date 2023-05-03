import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Homework21 extends BaseTest {

    public void renamePlaylist() {
        //GIVEN
        provideEmail("andrei.bryliakov@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        //WHEN
        doubleClickChoosePlaylist();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement inputPlaylistNameField = driver.findElement(By.cssSelector("input[name='name']"));
        actions.doubleClick(inputPlaylistNameField).perform();
        //inputPlaylistNameField.clear();
        inputPlaylistNameField.sendKeys("Homework21");
        inputPlaylistNameField.sendKeys(Keys.ENTER);

        //THEN
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        WebElement successMessage = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertEquals(successMessage.getText(), "Updated playlist \"Homework21.\"");
    }
}
