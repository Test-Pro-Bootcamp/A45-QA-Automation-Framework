import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String newPlName = "AlekseiZZZ";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
        doubleClickPl();
        enterNewPlName(newPlName);
        Assert.assertTrue(doesPlExists(newPlName));
    }

}
