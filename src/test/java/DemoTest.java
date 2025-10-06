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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU for headless
        options.addArguments("--no-sandbox");  // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        driver = new ChromeDriver(options);
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://github.com/devanshsingh15");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("devanshsingh15"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }





}

