import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{

    @Test

    public void playSong () throws InterruptedException {

        navigateToPage();
        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();
        Thread.sleep(2000);

        WebElement playMenu = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
        playMenu.click();
        Thread.sleep(1000);
        playMenu.click();

        WebElement playOrResume = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        playOrResume.click();
        Thread.sleep(200);

        WebElement marvelousVisualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(marvelousVisualizer.isDisplayed());
    }
}
