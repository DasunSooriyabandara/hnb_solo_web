package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class ClickMyOutletLink {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public ClickMyOutletLink(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the 'My Outlets' link
    private By myOutletLink = By.linkText("My Outlets");

    // Method to navigate to the URL and use Fluent Wait
    public void navigateToMyOutletLink() {
        // Navigate to the URL (replace with your navigation code)
        // For example:
        // driver.get("https://your_website_url");

        // Set up Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20)) // Maximum wait time
            .pollingEvery(Duration.ofMillis(500)) // Frequency of checking the condition
            .ignoring(Exception.class); // Exceptions to ignore during wait

        // Wait for the 'My Outlets' link to be clickable
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(myOutletLink));

        // Click the link
        linkElement.click();
    }
}