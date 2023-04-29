import org.testng.annotations.Test;

public class Homework19 extends BaseTest{


    @Test
    public void deletePlaylist() throws InterruptedException{

        String playlistName = "zaikov-HW19";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
        createPl(playlistName); // verifications are inside functions
        deletePl(playlistName);


        //Click the playlist you want to delete.
        //We should see a red button "x PLAYLIST" on the top right part of the page, and click on it.
        //Note: If the red button is not displayed, let's create a new playlist and click it.
        //Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".



    }

}
