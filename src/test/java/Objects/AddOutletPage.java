package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddOutletPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public AddOutletPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the 'Add' button
    private By addButton = By.xpath("//span[normalize-space()='Add']");
            By enterName = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
            By OutletCategory = By.xpath("//*[@id=\"outlets-outlet-category-field\"]/div/div[1]");
            By MerchantType = By.xpath("//*[@id=\"form-outlet-merchant-type-field\"]/div/div[1]");
    

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
    
    public void FillTheForm() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set a reasonable timeout
    	 WebElement enterNames = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNames.sendKeys("Test Name");
    	  	
    	
    }
    
    
}
//    	driver.findElement(OutletCategory).sendKeys("Thilaka");
//    	((WebElement) OutletCategory).sendKeys(Keys.ENTER);
//    	
//    	Select objSelect =new Select(driver.findElement(MerchantType));
//    	objSelect.selectByIndex(1);
//    }
    
