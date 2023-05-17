import org.testng.annotations.Test;

public class Homework24 extends BaseTest{
   @Test
           public void standAloneTest(){

    logIn("heavenmayhem@gmail.com","Everything2Me0628!");
   searchSong("memoria");
   clickViewAll();
   selectSong();
   clickAddTo();
   choosePlaylist();

}
}