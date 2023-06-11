import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchPage;

public class PlaylistTests extends BaseTest{

    @Test(priority = 1)
    public void addSongToPlaylist() {
        String expectedNotificationText = "Added 1 song into";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();

        searchPage.searchSong("Beautiful")
                .clickViewAllButton()
                .selectFirstSongFromSearchResult()
                .clickAddToButton()
                .choosePlaylistToAdd();

        Assert.assertTrue(homePage.actualNotificationText().contains(expectedNotificationText));
    }

    @Test(priority = 2)
    public void renamePlaylist(){
        String newPlaylistName = "kristina.matskaylo2";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();

        homePage.doubleClickFirstPlaylist()
                .enterNewPLaylistName(newPlaylistName);

        Assert.assertTrue(homePage.doesNewPlaylistexist(newPlaylistName));
    }

    @Test (priority = 3)
    public void deletePlaylist() {
        String expectedNotificationText = "Deleted playlist \"kristina.matskaylo.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();
        homePage.navigateToFirstPlaylist()
                .clickRedBtnPlaylist();
                //.clickOkDeleteButton();
        Assert.assertTrue(homePage.actualNotificationText().contains(expectedNotificationText));
    }



//        public void searchSong (String songname) throws InterruptedException {
//            WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
//            searchField.clear();
//            searchField.sendKeys(songname);
//            searchField.click();
//            Thread.sleep(2000);
//        }
//
//
//    public void clickViewAllButton()  throws InterruptedException  {
//        WebElement buttonViewAll = driver.findElement(By.cssSelector("section.songs h1 button"));
//        buttonViewAll.click();
//        Thread.sleep(2000);
//    }
//    public void selectFirstSongFromSearchResult()  throws InterruptedException {
//        WebElement firstSongFromList = driver.findElement(By.cssSelector("#songResultsWrapper td.title"));
//        firstSongFromList.click();
//        Thread.sleep(2000);
//    }
//
//    public void clickAddToButton() throws InterruptedException  {
//        WebElement buttonAddTo = driver.findElement(By.cssSelector("button.btn-add-to"));
//        buttonAddTo.click();
//        Thread.sleep(2000);
//    }
//
//    public void choosePlayListToAdd()  throws InterruptedException {
//        WebElement uniquePlayList = driver.findElement(By.xpath("// section[@id='songResultsWrapper']//li[contains(text(),'kristina.matskaylo')]"));
//        uniquePlayList.click();
//        Thread.sleep(2000);
//    }
//
//        public String actualNotificationText ()  {
//        WebElement getActualNotificationText = driver.findElement(By.cssSelector("div.success.show"));
//        return getActualNotificationText.getText();
//
//        }




}
