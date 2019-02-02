import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindInWiki extends LibraryForWiki{

    public static String URL_PAR = "http://wikipedia.org" ;
    private static final String SEARCH_PARAMETER = "java";

    @Test
    public void findInWikiInChromeBrowserTest(){
        //Open wikipedia.org
        openSite(URL_PAR);
        //Enter what you are looking for
        fillInFieldUniversal(By.cssSelector("[name=search]"), SEARCH_PARAMETER);
        //Click the Search button
        clickSearchButton(By.cssSelector(".pure-button.pure-button-primary-progressive"));
    }


}
