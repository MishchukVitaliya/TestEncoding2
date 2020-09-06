import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SearchButton = By.xpath("//div[contains(@placeholder,'Search')]");
    private By SearchString = By.xpath("//input[@type='search']");
    private By GetStatus = By.xpath("//div[@title='(GET) GetStatus (extended)']");
    private By ResponseJSON = By.xpath("//*[@id=\"page-responses-getstatus-extended\"]/div[2]/div[1]/div/div[2]/div[1]/button[2]");
    private By TableJSON = By.xpath("//div[@id=\"page-responses-getstatus-extended\"]//div[@class=\"CodeTabs\"][2]//code[contains(@data-lang, \"json\")]");

    public MainPage clickSearchButton() {
        driver.findElement(SearchButton).click();
        return this;
    }

    public MainPage sendGetStatus() {
        driver.findElement(SearchString).sendKeys("GetStatus");
        return this;
    }

    public MainPage clickGetStatus() {
        driver.findElement(GetStatus).click();
        return this;
    }

    public MainPage CurrentURL() {
        Assert.assertEquals("https://api.encoding.com/reference#responses-getstatus-extended", driver.getCurrentUrl());
        return this;
    }
}
