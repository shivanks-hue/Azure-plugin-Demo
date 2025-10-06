import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://github.com/devanshsingh15");
        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }





}
