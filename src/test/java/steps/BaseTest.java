package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected static WebDriver driver;

    public static void setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            String headless = System.getProperty("headless");
            if (headless != null && headless.equals("true")) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920x1080");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    public static void teardownDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
