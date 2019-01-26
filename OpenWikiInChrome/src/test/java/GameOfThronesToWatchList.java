import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GameOfThronesToWatchList{

    private static final String SEARCH_PARAMETER = "game of thrones";

    @BeforeMethod
    public void setUP(){
        LibraryForWiki.setUpPrepare();
    }

    @Test
    public void addGameOfThronesToWishListTest(){

        //Log in to wiki
        LogInToWiki.logInToWikiInChromeTest();

        //Enter what you are looking for
        LibraryForWiki.fillInSearchBar(SEARCH_PARAMETER);

        //Click the Search button
        LibraryForWiki.clickSearchButtonWhenLoggedIn();

        //Add desired page to watch list
        LibraryForWiki.addToWatchList();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        LibraryForWiki.quitBrowser();
    }
}
