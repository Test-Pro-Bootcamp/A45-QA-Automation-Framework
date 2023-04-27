import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    String deletemsg = "Deleted playlist";
    private String baseURL;

    @Test
    @Parameters
    public void deleteAPlaylist(String baseURL) throws InterruptedException {
        this.baseURL = baseURL;
        navigateToPage();
        logIn("heavenmayhem@gmail.com","Everything2Me0628!");
        choosePlaylist();
        deleteButton();
        Assert.assertTrue(confirmDelete().contains(deletemsg));
    }



}
