package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // Use ThreadLocal to ensure WebDriver is thread-safe for parallel execution
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public void LaunchBrowser() {
        String browser = System.getProperty("browser", "chrome").toLowerCase(); // Fetch from system properties, default to Chrome

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
        }

        // Maximize browser window
        driver.get().manage().window().maximize();
    }

    // Method to get the driver instance
    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void CloseBrowser() {
        if (driver.get() != null) {
//            driver.get().quit();  // Ensures the driver is properly closed
            driver.remove();  // Removes the ThreadLocal value
            System.out.println("Successfully closed the browser");
        }
    }
}
