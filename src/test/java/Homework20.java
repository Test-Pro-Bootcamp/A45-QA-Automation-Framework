import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

        @Test

            public void deleteThePlaylist()  {

                String deletedPlaylistMsg = "Deleted playlist";//replace with the del
                provideEmail("pdr.deepthi@gmail.com");
                providePassword("te$t$tudent1");
                clickSubmit();
                openPlaylist();
                clickDeletePlaylistBtn();
                Assert.assertTrue(getdeletedPlaylistMsg().contains(deletedPlaylistMsg));
            }
        }

