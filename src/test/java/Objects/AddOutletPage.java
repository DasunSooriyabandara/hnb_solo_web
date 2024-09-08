package Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class AddOutletPage {

	private WebDriver driver;
	private static final String OUTLET_NAME = "Automation Outlet Testing one "; // Use a constant for the outlet name

	// Constructor to initialize WebDriver
	public AddOutletPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By addButton = By.xpath("//span[normalize-space()='Add']");
	private By enterName = By.xpath("//*[@id=\"outlet-outlet-name-field\"]");
	private By merchantType = By.xpath("//*[@id=\"form-outlet-merchant-type-field\"]/div/div[2]/div");
	private By merchantTypeOpt = By.id("react-select-13-option-0");
	private By merchantName = By.xpath("//*[@id=\"outlet-merchant-id-field\"]/div/div[1]");
	private By merchantNameOpt = By.id("react-select-20-option-9");
//    private By merchantNameOpt = By.xpath("//*[@id=\"react-select-20-option-0\"]");
	private By uploadImageBtn = By
			.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/form/div[1]/div[17]/div/div/div/div[1]/label/span");
	private By midField = By.id("outlet-merchant-transaction-type-id-field");
	private By saveButton = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/form/div[3]/button[2]");
	private By successMessageLocator = By.xpath("//*[@id=\"app\"]/div[2]/div"); // xpath= //*[@id="client-snackbar"]
	// *[@id="app"]/div[2]/div
	private By errorMessageLocator = By.xpath("//*[@id=\"app\"]/div[2]/div"); // xpath = //*[@id="client-snackbar"]
	private By searchBox = By.xpath("//*[@id=\"user-first-name-field\"]");
	private By verifySearchItem = By
			.xpath("//*[@id=\"app\"]/div[3]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr/td[1]/div");

	// *[@id="app"]/div[2]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr/td[1]
//    #app > div:nth-child(2) > div > div > div.ui-main-wr > div > div:nth-child(2) > div.MuiPaper-root.MuiPaper-elevation1.ui-table.MuiPaper-rounded > table > tbody > tr > td:nth-child(1) > div
	// Method to navigate to the 'My Outlets' page and click the 'Add' button
	public void clickAddButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButtonElement.click();
	}

	// Method to fill the form with a sample name and verify the result
	public void fillTheForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Enter the name
		WebElement enterNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
		enterNameElement.sendKeys(OUTLET_NAME);

		// Click on the Merchant Type dropdown and select the option
		WebElement merchantTypeElement = wait.until(ExpectedConditions.elementToBeClickable(merchantType));
		merchantTypeElement.click();

		WebElement merchantTypeOptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantTypeOpt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantTypeOptElement);
		((JavascriptExecutor) driver)
				.executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
						+ "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");
		merchantTypeOptElement.click();
		Thread.sleep(3000);

		WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantType));
		selectedOption.getText().contains("Expected Option Text");
		selectedOption.click();
		Thread.sleep(3000);
		System.out.println("Merchant Type selected successfully: " + selectedOption.getText());

		// Click on the Merchant Name dropdown and select the option
		WebElement merchantNameElement = wait.until(ExpectedConditions.elementToBeClickable(merchantName));
		merchantNameElement.click();

		WebElement merchantNameOptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantNameOpt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantNameOptElement);
		((JavascriptExecutor) driver)
				.executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
						+ "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");
		String merchantType = merchantNameOptElement.getText();
		merchantNameOptElement.click();
		Thread.sleep(3000);

		WebElement selectedOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantName));
		selectedOption1.getText().contains("Expected Option Text");
		selectedOption1.click();
		System.out.println("Merchant Name selected successfully: " + selectedOption1.getText());

		// Upload the image
		WebElement fileInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadImageBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInputElement);
		fileInputElement.sendKeys("C:\\Users\\USER\\Downloads\\signature.png");
		System.out.println("Image uploaded successfully.");

		// Enter MID
		WebElement enterMID = wait.until(ExpectedConditions.elementToBeClickable(midField));
		enterMID.sendKeys("13794830");
		System.out.println("Enter MID successfully.");

		// Click Save button
		WebElement clickSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		clickSaveBtn.click();
		System.out.println("Save Add Outlet Details Successfully");

		wait.until(ExpectedConditions.urlToBe("https://solo-admin-sit.hnb.lk/app/outlets/my-outlets"));

		System.out.println("URL changed to: " + driver.getCurrentUrl());

		// Verify success or error alert, if any

		System.out.println(driver.getPageSource());

		// Proceed with searching for the newly created outlet

	}

	// Method to verify success message in the custom snackbar notification
	public void verifySnackbarMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// Adjust the locator to target the snackbar message based on the provided HTML
			By snackbarMessageLocator = By.xpath("//span[@id='client-snackbar']"); // Use the correct ID from your
																					// screenshot

			// Wait until the snackbar message is visible
			WebElement snackbarMessageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(snackbarMessageLocator));

			// Get the text of the message
			String message = snackbarMessageElement.getText();

			// Validate the message
			if (message.contains("Outlet successfully added")) {
				System.out.println("Outlet creation verification passed: " + message);
			} else {
				System.out.println("Outlet creation verification failed. Message: " + message);
			}

		} catch (NoSuchElementException e) {
			System.out.println("Snackbar message element not found.");
		}
	}

	// Method to search for the created outlet
	public void searchOutlet() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		searchBoxElement.sendKeys(OUTLET_NAME);
		Thread.sleep(5000);

		WebElement verifySearchItemElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(verifySearchItem));
		String searchResult = verifySearchItemElement.getText();

		if (searchResult.contains(OUTLET_NAME)) {
			System.out.println("Search result displayed successfully: " + searchResult);
		} else {
			System.out.println("Search result not found.");
		}
	}
}