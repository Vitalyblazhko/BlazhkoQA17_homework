import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LibraryForWiki {

    static WebDriver wd;
    public static String URL_PAR = "http://wikipedia.org" ;
    private static long WAIT_TIME = 3000;


    public static void setUpPrepare() {

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.MICROSECONDS);
        wd.manage().window().maximize();
    }

    public static void openSite(String url) {
        wd.get(url);
    }

    public static void fillInSearchBar(String searchParameter) {
        wd.findElement(By.id("searchInput")).click();
        wd.findElement(By.id("searchInput")).clear();
        wd.findElement(By.id("searchInput")).sendKeys(searchParameter);
    }

    public static void clickSerchButtonInHomePage(){
        wd.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive")).click();
    }

    public static void clickSearchButtonWhenLoggedIn() {
        wd.findElement(By.id("searchButton")).click();
    }

    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(WAIT_TIME);
        wd.quit();
    }

    public static void switchToEnglish() {
        wd.findElement(By.id("js-link-box-en")).click();
    }

    public static void clickLogIn() {
        wd.findElement(By.linkText("Log in")).click();
    }

    public static void enterUsername(String username) {
        wd.findElement(By.id("wpName1")).click();
        wd.findElement(By.id("wpName1")).clear();
        wd.findElement(By.id("wpName1")).sendKeys(username);
    }

    public static void enterPassword(final String password) {
        wd.findElement(By.id("wpPassword1")).click();
        wd.findElement(By.id("wpPassword1")).clear();
        wd.findElement(By.id("wpPassword1")).sendKeys(password);
    }

    public static void clickTheLogInButton() {
        wd.findElement(By.id("wpLoginAttempt")).click();
    }

    public static void addToWatchList() {
        wd.findElement(By.cssSelector("[accesskey=w]")).click();
    }

}
