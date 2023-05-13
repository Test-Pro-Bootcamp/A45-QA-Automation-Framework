import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaylistTestsPreHmk22 extends BaseTest {

        @Test(priority=1)
        public void deletePlaylist() {
            // This method only works if the playlist being selected to delete is empty
            String deletedPlaylistMsg = "Deleted playlist";

            login("demo@class.com", "te$t$tudent");
            openPlaylist();
            clickDeletePlaylistBtn();
            Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
        }

        @Test(priority=3)
        public void addSongToPlaylist() throws InterruptedException {
            // Must be a playlist namedTest Pro edited Playlist and song being added can not be in playlist
            String newSongAddedNotificationText = "Added 1 song into";

            login("demo@class.com", "te$t$tudent");
            searchSong("Pluto");
            clickViewAllBtn();
            selectFirstSongResult();
            clickAddToBtn();
            choosePlaylist();

            Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
        }


        @Test(priority=2)
        public void renamePlaylist() {
            // Prerequisite - at least one user-created playlist

            login("demo@class.com", "te$t$tudent");
            doubleClickPlaylist();
            enterNewPlayListName();
            Assert.assertTrue(doesPlaylistExist());
        }

    }

