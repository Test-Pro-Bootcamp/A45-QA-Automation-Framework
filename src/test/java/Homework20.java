import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;



public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";

        login("demo@class.com","te$t$tudent");
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }



    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
       // WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
        //Thread.sleep(2000);
    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }



    public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }

}


