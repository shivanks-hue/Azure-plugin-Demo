import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DemoTest {
    RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "dev");
        capabilities.setCapability("platformName", "Windows 10");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Selenium-Sample-Assignment");
        ltOptions.put("name",method.getName() + " - " + "chrome" + " - " + "Windows 10");
        ltOptions.put("network", true);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("console", true);
        ltOptions.put("tunnel", true);
        ltOptions.put("tunnelName", "azure-lambdatest-tunnel-Job");
        capabilities.setCapability("lt:options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://shivanks:LT_V6UEGtFRGiIPH4QcUdNKQv4RIetJjVfXKKIEkrP3Sk15opJ@hub.lambdatest.com/wd/hub"), capabilities
        );
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://localhost/web1/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-section']/button")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}













