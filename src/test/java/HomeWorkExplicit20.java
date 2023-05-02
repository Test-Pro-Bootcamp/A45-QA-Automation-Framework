import  org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.Assert;

public class HomeWorkExplicit20 extends BaseTest20 {
    @Test
    public void addSongToPlayList()throws InterruptedException{

        String newSongAddedNotificationText="Added 1 song into";
        navigateToPage();
        provideEmail("mengi.gebremedhin@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSongl("pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickViewAllBtn();
        playListAdded();
        Assert.assertTrue(getNotifictionText().contains(newSongAddedNotificationText));


    }



}










