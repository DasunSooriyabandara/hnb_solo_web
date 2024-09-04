package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FilterOutlet {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public FilterOutlet(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait time
    }

    // Locators
    private By filterBtn = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div/button"); 
    private By merchantName = By.xpath("//*[@id=\"outlet-filter-merchantId-field\"]/div/div[1]");
    private By merchantNameSelect = By.cssSelector("#react-select-2-option-12");
    private By mid = By.id("outlet-filter-mid-field");
    private By setFilterButton = By.xpath("//button[@type='submit']");
    private By filterResult = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr");
    private By status = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div");
    private By name = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[1]/div/p");
    private By merchant = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr/td[4]/div/text()");
    private By Okbtn = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[4]/button");

    // Method to click the filter button, apply filter, and verify status, name, and merchant
    public void clickFilterButton() {
        // Click the filter button
        WebElement filterButtonElement = wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
        filterButtonElement.click();

        // Click on the merchant name dropdown and select the specified option
        WebElement merchantNameField = wait.until(ExpectedConditions.elementToBeClickable(merchantName));
        merchantNameField.click();

        // Wait for the merchant name option to be visible and click it
        WebElement merchantNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantNameSelect));
        merchantNameElement.click();
        System.out.println("Successfully selected Merchant Name.");

        // Enter the MID
        WebElement enterMid = wait.until(ExpectedConditions.elementToBeClickable(mid));
        enterMid.sendKeys("60501111");
        System.out.println("Successfully entered MID.");

        // Click the 'Set Filter' button
        WebElement clickSetFilterButton = wait.until(ExpectedConditions.elementToBeClickable(setFilterButton));
        clickSetFilterButton.click();
        System.out.println("Successfully clicked Set Filter Button.");

        // Click on the filtered result to open the item details
        WebElement clickFilterTable = wait.until(ExpectedConditions.elementToBeClickable(filterResult));
        clickFilterTable.click();
        System.out.println("Successfully opened filtered item details.");
        
     // Click on the OK Button result to open the item details
        WebElement clickOKButton = wait.until(ExpectedConditions.elementToBeClickable(Okbtn));
        clickOKButton.click();
        System.out.println("Successfully Click Ok Button after filter items.");

        // Get the status text and print it
        WebElement getStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(status));
        String status1 = getStatus.getText();
        System.out.println("Successfully retrieved the status: " + status1);

        // Get the name text and print it
        WebElement getName = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        String name1 = getName.getText();
        System.out.println("Successfully retrieved the name: " + name1);

        // Get the merchant text and print it
        WebElement getMerchant = wait.until(ExpectedConditions.visibilityOfElementLocated(merchant));
        String merchant1 = getMerchant.getText();
        System.out.println("Successfully retrieved the merchant: " + merchant1);
    }
}
