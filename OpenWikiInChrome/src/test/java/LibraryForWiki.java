import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class LibraryForWiki {

    static WebDriver wd;
    private static long WAIT_TIME = 3000;

    @BeforeClass
    public void setUP(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.MICROSECONDS);
        wd.manage().window().maximize();
    }

    public static void openSite(String url) {
        wd.get(url);
    }

    public static void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public static void click(By locator) {
        wd.findElement(locator).click();
    }

    public static void clickSearchButton(By locator){
        click(locator);
    }

    public static void switchToNecessaryLanguage(By languageLocator) {
        click(languageLocator);
    }

    public static void clickLogIn(By loginLinkLocator) {
        click(loginLinkLocator);
    }

    public static void fillInFieldUniversal(By locator, String value) {
        click(locator);
        clear(locator);
        sendKeysUniversal(locator, value);
    }

    public static void sendKeysUniversal(By locator, String value) {
        wd.findElement(locator).sendKeys(value);
    }

    public static void addToWatchList(By locator) {
        click(locator);
    }

    protected void logInToWiki(String url,
                               By languageLocator,
                               By loginLinkLocator,
                               By userNameLocator,String userName,
                               By passwordLocator, String password,
                               By loginButtonLocator) {
        //Open necessary site
        openSite(url);
        //Switch to necessary language
        switchToNecessaryLanguage(languageLocator);
        //Click the LogIn button
        clickLogIn(loginLinkLocator);
        //Enter User Name
        fillInFieldUniversal(userNameLocator, userName);
        //Enter Password
        fillInFieldUniversal(passwordLocator, password);
        //Click the Log In button
        clickLogIn(loginButtonLocator);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(WAIT_TIME);
        wd.quit();
    }


    public boolean isUserLoggedIn(String url, By languageLocator, By elementLocator) {
        openSite(url);
        switchToNecessaryLanguage(languageLocator);
        return isElementPresent(elementLocator);
    }

    public boolean isElementPresent(By elementLocator) {
        try {
            wd.findElement(elementLocator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void logOutFromWiki(By logOutLocator) {
        click(logOutLocator);
    }
}
