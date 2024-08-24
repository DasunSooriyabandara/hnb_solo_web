package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor initializes the driver and wait
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait time
    }

    // Locators for the search box and search button
    By searchbox = By.name("q");
    By searchbutton = By.name("btnK");
    By drawifySearchResultLink = By.xpath("//h3[contains(text(),'Drawify')]");

    // Method to perform Google search
    public void searchGoogle(String searchInput) {
        try {
            WebElement searchBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
            searchBoxElement.sendKeys(searchInput);

            WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
            searchButtonElement.click();
        } catch (Exception e) {
            System.out.println("Exception Caught during search: " + e.getMessage());
        }
    }

    // Method to click on Drawify link from search results
    public void clickDrawifyLink() {
        try {
            // Wait for the Drawify link to be clickable and click it
            WebElement resultLinkElement = wait.until(ExpectedConditions.elementToBeClickable(drawifySearchResultLink));
            resultLinkElement.click();
        } catch (Exception e) {
            System.out.println("Exception Caught while clicking Drawify link: " + e.getMessage());
        }
    }
}