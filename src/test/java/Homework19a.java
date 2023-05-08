import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19a extends BaseTest{
    @Test

  public void Homework19test(){
    String deletedMsg = "Deleted Playlist";

        logIn("heavenmayhem@gmail.com","Everything2Me0628!");
        searchSong("Dark Days");
        clickViewAll();
        selectSong();
        clickAddTo();
        choosePlaylist();
        choosePlaylistToDelete();
        deleteButton();
        clickOK();
        Assert.assertTrue(confirmDelete().contains(deletedMsg));

    }

}
