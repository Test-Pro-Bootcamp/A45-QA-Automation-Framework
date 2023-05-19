import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist (){
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);

        login.login();
        home.click();
        home.addPlaylist();
        Assert.assertTrue(home.playListExist());
    }
}
