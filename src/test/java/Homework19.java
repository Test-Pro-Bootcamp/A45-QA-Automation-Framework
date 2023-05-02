import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    String deletemsg = "Deleted playlist";

    @Test
    public void deleteAPlaylist(){
      //given
        logIn("heavenmayhem@gmail.com", "Everything2Me0628!");
        //when
        choosePlaylist();
        deleteButton();
        okDelete();
      //then
        Assert.assertTrue(confirmDelete().contains("Deleted playlist"));
    }


}
