public class XpathLocators {


    String search = "//input[@type='search']";

    String logout = "//a[@class='logout control']";

    String favorites = "//section[@id='playlists']//li[@class='playlist favorites']";

    String lyrics = "//button[@id='extraTabLyrics']";

    String howdy = "//section[@id='homeWrapper']/header//h1";

    String mostPlayed = "//h1[contains(text(), 'Most Played')]";

    String volumeRange = "//span[@id='volume']";

    String playButton = "//span[@title='Play or resume']";

    String playNextSongButton = "//*[@data-testid='play-next-btn']"; // "//*[@title='Play next song']"   //body[1]/div[1]/div[1]/footer[1]/div[1]/i[2]


}
