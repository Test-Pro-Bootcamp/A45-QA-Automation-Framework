@Test
public void addSongToPlaylist() {
  // Set the path to the chromedriver executable
  System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

  // Create a new instance of the ChromeDriver
  WebDriver driver = new ChromeDriver();

  // Navigate to the webpage
  driver.get("https://bbb.testpro.io/");

  // Log in with your credentials
  WebElement usernameField = driver.findElement(By.id("username"));
  WebElement passwordField = driver.findElement(By.id("password"));
  WebElement loginButton = driver.findElement(By.xpath("//button[text()='LOGIN']"));

  usernameField.sendKeys("your_username");
  passwordField.sendKeys("your_password");
  loginButton.click();

  // Search for a song
  WebElement searchField = driver.findElement(By.id("searchBar"));
  WebElement searchButton = driver.findElement(By.id("searchButton"));

  searchField.sendKeys("song_name");
  searchButton.click();

  // Display all search results
  WebElement viewAllButton = driver.findElement(By.linkText("View All"));
  viewAllButton.click();

  // Click on the first song in the search results
  List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='list-group']/a"));
  WebElement firstSong = searchResults.get(0);
  firstSong.click();

  // Add the song to a playlist
  WebElement addToButton = driver.findElement(By.linkText("ADD TO..."));
  addToButton