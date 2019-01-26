import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class OpenWikiInChrome {
    WebDriver wd;

    @BeforeClass
    public void setUP(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void chromeBrowserTest(){
        wd.get("http://en.wikipedia.org");

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        wd.quit();
    }
}