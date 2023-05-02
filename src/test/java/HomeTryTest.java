import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTryTest extends BaseHomeTest{
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
        additionalplaylist();
        Assert.assertTrue(getNotifictionText().contains(newSongAddedNotificationText));


    }



}





