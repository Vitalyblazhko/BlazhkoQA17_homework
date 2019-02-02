import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInToWiki extends LibraryForWiki {

    private static String URL_PAR = "http://wikipedia.org";
    private static final String USER_NAME = "VitalyBlazhko";
    private static final String USER_PASSWORD = "7504241";

    @BeforeMethod
    public void ensurePrecondition(){
       if(isUserLoggedIn(URL_PAR, By.cssSelector("#js-link-box-en"), By.cssSelector("[title='Log out']"))){
           logOutFromWiki(By.cssSelector("[title='Log out']"));
       }
    }

    @Test
    public void logInToWikiInChromeTest(){
        //Open wikipedia.org
        openSite(URL_PAR);
        //Switch to English
        switchToNecessaryLanguage(By.cssSelector("#js-link-box-en"));
        //Click the LogIn button
        clickLogIn(By.cssSelector("li [accesskey=o]"));
        //Enter User Name
        fillInFieldUniversal(By.cssSelector("#wpName1"), USER_NAME);
        //Enter Password
        fillInFieldUniversal(By.cssSelector("#wpPassword1"), USER_PASSWORD);
        //Click the Log in button
        clickLogIn(By.cssSelector("div #wpLoginAttempt"));

        Assert.assertTrue(isUserLoggedIn(URL_PAR,
                By.cssSelector("#js-link-box-en"),
                By.cssSelector("[title='Log out']")));
    }

}