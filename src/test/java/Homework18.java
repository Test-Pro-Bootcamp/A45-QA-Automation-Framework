import org.junit.Assert;
import org.junit.Test;

public class Homework18 {

    @Test
    public void playSong() {
        // Helper methods
        // ...

        // Navigate to "https://bbb.testpro.io/"
        navigateTo("https://bbb.testpro.io/");

        // Log in with your credentials
        login("deimante.juskyte@testpro.com", "te$t$tudent");

        // Click "Play next song" and then the Play button
        clickPlayNextSong();
        clickPlayButton();

        // Validate that a song is playing
        boolean isSongPlaying = isSoundBarDisplayed() || isPauseButtonDisplayed();
        Assert.assertTrue("A song is not playing.", isSongPlaying);

        // Retrieve the name of the currently playing song
        String songName = getSongName();

        // Validate the song name
        String expectedSongName = "Your expected song name";
        Assert.assertEquals("Song name is not as expected.", expectedSongName, songName);
    }

    // Helper methods
    private void navigateTo(String url) {
        // Implementation
    }

    private void login(String username, String password) {
        // Implementation
    }

    private void clickPlayNextSong() {
        // Implementation
    }

    private void clickPlayButton() {
        // Implementation
    }

    private boolean isSoundBarDisplayed() {
        // Implementation
        return false;
    }

    private boolean isPauseButtonDisplayed() {
        // Implementation
        return false;
    }

    private String getSongName() {
        // Implementation to retrieve the name of the currently playing song
        return "Song Name";
    }
}

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Homework18 Suite">
<test name="Homework18 Test">
<classes>
<class name="pages.Homework18">
<methods>
<include name="playSong"/>
</methods>
</class>
</classes>
</test>
</suite>
