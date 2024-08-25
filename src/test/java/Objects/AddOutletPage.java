package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class AddOutletPage {

	private WebDriver driver;

	// Constructor to initialize WebDriver
	public AddOutletPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By addButton = By.xpath("//span[normalize-space()='Add']");
	private By enterName = By.xpath("//*[@id=\"outlet-outlet-name-field\"]");
	private By merchantType = By.xpath("//*[@id=\"form-outlet-merchant-type-field\"]/div/div[2]/div");
	private By merchantTypeOpt = By.id("react-select-8-option-0");
	private By merchantName = By.xpath("//*[@id=\"outlet-merchant-id-field\"]/div/div[1]");
	private By merchantNameOpt = By.id("react-select-15-option-3");
	private By UploadImageBtn = By.xpath("//span[contains(text(),'Select an Image')]");
	private By MID = By.id("outlet-merchant-transaction-type-id-field");
	private By SAVE = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/form/div[3]/button[2]");
	private FluentWait<WebDriver> wait111;
	private FluentWait<WebDriver> wait11;
	
	// Method to navigate to the 'My Outlets' page and click the 'Add' button
	public void clickAddButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButtonElement.click();
	}

	// Method to fill the form with a sample name
	public void fillTheForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// ---------------Enter the name-------------------
		WebElement enterNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
		enterNameElement.sendKeys("Automation Test");

		// ----------------Click on the Merchant Type dropdown----------------
		WebElement merchantTypeElement = wait.until(ExpectedConditions.elementToBeClickable(merchantType));
		merchantTypeElement.click();

		// Wait for the options to be visible
		WebElement merchantTypeOptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantTypeOpt));

		// Scroll the option into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantTypeOptElement);

		// Remove potential overlays
		((JavascriptExecutor) driver)
				.executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
						+ "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");

		// Click on the option
		merchantTypeOptElement.click();

		Thread.sleep(3000);
//		-----------------------------------------------------------------------------------------------------------------------
		// ------------Verify the option was
		// selected------------------------------------------
		WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantType));
		selectedOption.getText().contains("Expected Option Text");
		selectedOption.click();
		Thread.sleep(3000);

		System.out.println("Option selected successfully: " + selectedOption.getText());

		
		
		
		
//		// ----------------Click on the Merchant Name dropdown----------------
		WebElement merchanNameElement = wait.until(ExpectedConditions.elementToBeClickable(merchantName));
		merchanNameElement.click();
//
//		// Wait for the options to be visible
		WebElement merchanNameElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantNameOpt));
//
//		// Scroll the option into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchanNameElement1);
//
//		// Remove potential overlays
		((JavascriptExecutor) driver)
				.executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
						+ "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");
//
//		// Click on the option
		merchanNameElement1.click();
		
		Thread.sleep(3000);
		wait11 = null;
//		// ------------Verify the option was
//		// selected------------------------------------------
		WebElement selectedOption1 = wait11.until(ExpectedConditions.visibilityOfElementLocated(merchantName));
		selectedOption1.getText().contains("Expected Option Text");
		selectedOption1.click();
//
		System.out.println("Option selected successfully: " + selectedOption.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(3000);
//		---------------------------------------------------------------------------------------------------------------

		 wait111 = null;
		WebElement fileInputElement = wait111.until(ExpectedConditions.visibilityOfElementLocated(UploadImageBtn));
	     fileInputElement.sendKeys("\"C:\\Users\\USER\\Downloads\\signature.png\"");  // Replace with the correct file path

	     System.out.println("Image uploaded successfully.");
		
//		-------------------------------------------------------------------------------------------------------------------
	     Thread.sleep(3000);
	     WebElement enterMID = wait111.until(ExpectedConditions.visibilityOfElementLocated(MID));
	     enterMID.sendKeys("12345678");
	
	     System.out.println("Enter MID successfully.");
	     
	     
	     WebElement ClickSaveBtn = wait111.until(ExpectedConditions.elementToBeClickable(SAVE));
	     ClickSaveBtn.click();
	     System.out.println("Save Add Outlet Details Successfully");

	}
}
