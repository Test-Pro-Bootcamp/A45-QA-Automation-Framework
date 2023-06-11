import org.testng.annotations.Test;

public class RandomTests extends BaseTest {

    @Test
    public void actionMethods() {
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickChoosePlaylist();

//        chooseAllSongsList();


//        hoverPlay();
//        contextClickFirstSong();
    }

    @Test
    public void listOfSongsWebElements() {
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        displayAllSongs();
    }
}
