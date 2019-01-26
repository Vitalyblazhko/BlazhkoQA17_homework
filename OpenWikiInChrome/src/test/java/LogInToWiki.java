import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInToWiki {

    private static final String USER_NAME = "VitalyBlazhko";
    private static final String USER_PASSWORD = "7504241";

    @BeforeMethod
    public void setUP(){
        LibraryForWiki.setUpPrepare();
    }

    @Test
    public static void logInToWikiInChromeTest(){
        //Open wikipedia.org
        LibraryForWiki.openSite(LibraryForWiki.URL_PAR);

        //Switch to English
        LibraryForWiki.switchToEnglish();

        //Click the LogIn button
        LibraryForWiki.clickLogIn();

        //Enter User Name
        LibraryForWiki.enterUsername(USER_NAME);

        //Enter Password
        LibraryForWiki.enterPassword(USER_PASSWORD);

        //Click the Log in button
        LibraryForWiki.clickTheLogInButton();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        LibraryForWiki.quitBrowser();
    }
}