import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class HomeWorkTest17 extends MyBaseTest {
    @Test
public void navigatePage(){
    /*ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://bbb.testpro.io/";
    driver.get(url);*/

    // Steps
    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
    emailField.click();//not needed
    emailField.clear();
    emailField.sendKeys("mengi.gebremedhin@testpro.io");

    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
    passwordField.click();//not needed
    passwordField.clear();
    passwordField.sendKeys("te$t$tudent");
    WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
    submit.click();

}
@Test
     public void searchSong () {
    WebElement searchResult = driver.findElement(By.cssSelector(".content"));
    WebElement searchField = driver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
         searchField.clear();
         searchField.sendKeys("my baby");
         Assert.assertEquals("my baby",searchResult);
     }
     @Test
     public void addSong()  {
         WebElement addSong = driver.findElement(By.cssSelector("i[title='Create a new playlist']")).click();
         WebElement newPlaylist= driver.findElement(By.cssSelector("input[name='name']"));
         newPlaylist.sendKeys("my baby");
         //searchField.clear();
         //newPlaylist.sendKeys("my baby");

         WebElement fillbox=driver.findElement(By.cssSelector("select[name='operator[]']"));
        fillbox.sendKeys("is");
         WebElement fillTitle=driver.findElement(By.cssSelector("select[name='model[]']"));
         fillTitle.sendKeys("title");
         WebElement fillText=driver.findElement(By.cssSelector("input[name='value[]']"));
         fillText.sendKeys("good");
         WebElement saveSong=driver.findElement(By.cssSelector("form[data-testid='create-smart-playlist-form'] button[type='submit']"));
         saveSong.click();

     }

     @Test
     public void verifySongPlaylist(){

WebElement verifySong=driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > section:nth-child(2) > section:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).
     Assert.assertEquals( driver.getTitle(),"Added 1 song into playlist");
}
}
