import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

        @Test
        public void playSong() throws InterruptedException {

            navigateToPage();
            provideEmail("anton.prymak@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            Thread.sleep(2000);

            WebElement nextSongButton = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
            nextSongButton.click();
            Thread.sleep(1100);
            nextSongButton.click();

            WebElement resumeSongButton = driver.findElement(By.xpath("//span[@title='Play or resume']"));
            resumeSongButton.click();
            Thread.sleep(300);

            WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
            Assert.assertTrue(visualizer.isDisplayed());
        }
    }

