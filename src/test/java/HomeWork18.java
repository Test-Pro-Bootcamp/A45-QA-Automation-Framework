import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {

        login("yuliia.tkachenko@testpro.io", "te$t$tudent");
        playSong();
        Assert.assertTrue(songPlying());


    }

    public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        emailField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();


    }

    public void playSong (){

        WebElement playNextSong = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("///span[@data-testid]"));

        playNextSong.click();
        playButton.click();
    }
    public boolean songPlying(){

        WebElement soundBar = driver.findElement(By.xpath("//div[@data-test='soundbars']"));
        return soundBar.isDisplayed();
    }



}
