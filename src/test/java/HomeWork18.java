import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest18 {
    @Test
    public void playSong() {
        provideEmail("mengi.gebremedhin@testpro.io");
        providePassword("te$tStudent");
        clickSubmit();
        timeLapse(10);

        WebElement allSongs = driver.findElement(By.cssSelector(".songs.active"));
        allSongs.click();

        WebElement selectSong = driver.findElement(By.cssSelector("tr[class='song-item playing selected'] td[class='title']"));
        selectSong.click();

        WebElement playSong = driver.findElement(By.cssSelector(".side.player-controls"));
        playSong.click();

        Actions reaTex=new Actions(driver);
        reaTex.moveToElement(driver.findElement(By.cssSelector("tr[class='song-item playing selected'] td[class='title']"))).contextClick().build().perform();
        Select select=new Select(driver.findElement(By.cssSelector("//select")));
        WebElement option=select.getFirstSelectedOption();
        String defaultItem=option.getText();

        Assert.assertEquals(defaultItem,"pause");
    }
}
