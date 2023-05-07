import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{
        String playlistName = "zaikov-HW19";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
        createPl(playlistName); // verifications are inside functions
        deletePl(playlistName);
    }

}
