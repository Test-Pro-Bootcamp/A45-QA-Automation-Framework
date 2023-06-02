import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Homework21 extends BaseTest {

    @Test

    public void renamePlaylist() {

        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
        doubleClickChoosePlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
}
