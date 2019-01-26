import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindInWiki{

    private static final String SEARCH_PARAMETER = "java";

    @BeforeMethod
    public void setUP(){
        LibraryForWiki.setUpPrepare();

    }

    @Test
    public void findInWikiInChromeBrowserTest(){
        //Open wikipedia.org
        LibraryForWiki.openSite(LibraryForWiki.URL_PAR);

        //Enter what you are looking for
        LibraryForWiki.fillInSearchBar(SEARCH_PARAMETER);

        //Click the Search button
        LibraryForWiki.clickSerchButtonInHomePage();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        LibraryForWiki.quitBrowser();
    }

}
