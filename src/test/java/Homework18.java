import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

  @Test
  public void playSong() throws InterruptedException {
   navigateToPage();
   provideEmail("amanda.martins@testpro.io");
   providePassword("te$t$tudent");
   clickSubmit();
   Thread.sleep(2000);

   WebElement clickPlayNextSong = driver.findElement(By.cssSelector(".next.fa.fa"));
   clickPlayNextSong.click();
   Thread.sleep(2000);

   WebElement clickPlaySong = driver.findElement(By.cssSelector("[title='Play or resume']"));
   clickPlaySong.click();
   Thread.sleep(2000);

   WebElement verifySongPlaying = driver.findElement(By.cssSelector("span.pause"));
   Assert.assertTrue(verifySongPlaying.isDisplayed());
   Thread.sleep(2000);

 }



}
