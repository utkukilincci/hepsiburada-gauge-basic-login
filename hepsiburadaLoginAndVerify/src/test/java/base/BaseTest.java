package base;

import com.thoughtworks.gauge.BeforeScenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {


    public static WebDriver driver;
    WebDriverWait wait;


    @BeforeScenario
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void waitUntilVisible(By by){
        this.wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickElement(By by){
        findElement(by).click();
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).click().build().perform();
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void assertElementText(By by, String expectedText){
        String actualText = findElement(by).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertText(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }


    public WebElement findElement(By by){
       return driver.findElement(by);
    }

    /*
    @AfterScenario
    public void teardown(){
        driver.quit();
    }
    */

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }
}
