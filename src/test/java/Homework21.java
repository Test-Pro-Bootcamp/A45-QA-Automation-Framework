import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends  BaseTest{
    @Test
    public static void renamePlaylist(){

        logIn();
        choosePlaylist();
        editPlaylist();
        enterNewName();
        Assert.assertTrue();
    }

}
