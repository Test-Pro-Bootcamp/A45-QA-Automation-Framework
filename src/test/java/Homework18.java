import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest{

    @Test
    public static void playSong() {
        WebElement nextSongButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSongButton.click();

        WebElement playSongButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playSongButton.click();

        WebElement soundBar = driver.findElement(By.cssSelector("button[data-testid='toggle-visualizer-btn']"));

        Assert.assertTrue(soundBar.isDisplayed());
    }
}
