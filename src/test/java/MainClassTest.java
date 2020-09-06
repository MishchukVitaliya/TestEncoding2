import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\VITA\\IdeaProjects\\TestAPI\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://api.encoding.com/");
        mainPage=new MainPage(driver);
    }

    @Test
    public void Test(){
        MainPage page = mainPage.clickSearchButton();
        MainPage page2 =  mainPage.sendGetStatus();
        MainPage page3 =  mainPage.clickGetStatus();
       Assert.assertEquals("https://api.encoding.com/reference#responses-getstatus-extended",driver.getCurrentUrl());
    }

    @After
    public void  tearDown(){
        driver.quit();
    }

}
