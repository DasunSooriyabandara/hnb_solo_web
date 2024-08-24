package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyOutletsPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public MyOutletsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the 'Add' button
    private By addButton = By.xpath("//span[normalize-space()='Add']");

    // Method to navigate to the 'My Outlets' page and click the 'Add' button
    public void ClickAddButton() {
        // Replace this placeholder with your actual navigation code
        // This could involve using driver.get("https://your-website.url") or
        // a framework-specific method for navigating within your application.

        // Explicitly wait for the 'Add' button to be visible before clicking
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set a reasonable timeout
        WebElement addButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        addButtonElement.click();
    }
}