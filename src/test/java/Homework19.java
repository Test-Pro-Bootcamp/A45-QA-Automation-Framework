import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    String deletemsg = "Deleted playlist";
    @Test
    @Parameters
    public void deleteAPlaylist() throws InterruptedException {
        setupBrowser("baseURL");
        logIn("heavenmayhem@gmail.com","Everything2Me0628!");
        choosePlaylist();
        deleteButton();
        Assert.assertTrue(confirmDelete().contains(deletemsg));
    }



}
