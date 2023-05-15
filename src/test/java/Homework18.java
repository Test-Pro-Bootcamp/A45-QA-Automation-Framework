import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        provideEmail("rishkodaria@gmail.com");
        providePassword("2743782dasha!");
        clickSubmit();
        Thread.sleep(4000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
// public static void provideEmail(String email){
//     WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
//     emailField.clear();
//     emailField.sendKeys(email);
// }
//public static void providePassword(String password){
//    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//    passwordField.clear();
//    passwordField.sendKeys(password);
//}
//
//public static void clickSubmit(){
//     WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
//     submit.click();
//}

    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));//xpath syntax fix
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']" ));

        playNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();


    }


}



