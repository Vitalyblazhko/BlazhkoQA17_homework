import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameOfThronesToWatchList extends LibraryForWiki{

    private static String URL_PAR = "http://wikipedia.org";
    private static final String USER_NAME = "VitalyBlazhko";
    private static final String USER_PASSWORD = "7504241";
    private static final String SEARCH_PARAMETER = "game of thrones";

    @Test
    public void addGameOfThronesToWatchListTest(){
        //Log in to wiki
        logInToWiki(URL_PAR,
                By.cssSelector("#js-link-box-en"),
                By.cssSelector("li [accesskey=o]"),
                By.cssSelector("#wpName1"), USER_NAME,
                By.cssSelector("#wpPassword1"), USER_PASSWORD,
                By.cssSelector("div #wpLoginAttempt"));
        //Enter what you are looking for
        fillInFieldUniversal(By.cssSelector("input#searchInput"), SEARCH_PARAMETER);
        //Click the Search button
        clickSearchButton(By.cssSelector("input#searchButton"));
        //Add desired page to watch list
        addToWatchList(By.cssSelector("[accesskey=w]"));
    }
}
