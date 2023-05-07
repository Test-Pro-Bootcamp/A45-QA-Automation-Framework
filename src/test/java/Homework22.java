import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BasePage{
    @Test
    public void renamePlaylist (){
        LoginPage login = new LoginPage();
        HomePage home = new HomePage();

        login.login();
        home.click();
        home.addPlaylist();
        Assert.assertTrue(home.playListExist());
    }
}
