package PageObjectRepository;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CKLoginPage {
	public WebDriver driver;

	// Constructor
	// Gets called when object of this page is created in MainClass.java
	// "this" keyword is used here to distinguish global and local variable "driver"
	//gets driver as parameter from MainClass.java and assigns to the driver instance in this class
	public CKLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'sign in')]")
	public WebElement getsigninbutton;
	
	public void clickSignIn() {
		getsigninbutton.click();
	}
	
	@FindBy(xpath = "//input[@name='login']")
	public WebElement getUsername;
	
	public void getusername(String setusername) {
		getUsername.sendKeys(setusername);
	}
	
	
	// Locator for Email Address
	//By getsigninbutton = By.xpath("//span[contains(text(),'sign in')]");

	// Locator for Username field
	//By Username = By.xpath("//input[@name='login']");
	
	

	// Locator for Password field
	//By Password = By.xpath("//input[@name='token']");
	
	
	
	@FindBy(xpath = "//input[@name='token']")
	public WebElement getPassword;
	
	public void getPassword(String setPassword) {
		getPassword.sendKeys(setPassword);
	}
	

	@FindBy(xpath = "//body/div[@id='sign-in-modal']/div[1]/div[3]/div[1]/div[1]/div[1]/input[4]")
	public WebElement getLoginsigninbutton;
	
	public void clickOnLoginSignIn() {
		getLoginsigninbutton.click();
	}

	// Locator for SignIn Button
	By LoginSignInButton = By.xpath("//div//following-sibling::input[@value='Sign In']");

	// Locator for SignIn Button
	By toastCloseButton = By.xpath("//div[@id='toast-close-button']");

	// Locator for SignIn Button
	By getClassesTab = By.xpath("//header/nav[1]/section[1]/ul[1]/li[2]/a[1]");

	// Locator for SignIn Button
	By getClassCode = By.xpath("//div[@id='app']//following::div[2]/div[4]/input[1]");


	// Locator for SignIn Button
	By librarybutton = By.xpath("//header/nav[1]/section[1]/ul[1]/li[3]/a[1]");
	public void clicklibrarybutton() {
		driver.findElement(librarybutton).click();
	}

	By createnew = By.xpath("//a[@id='dropdown-create']");
	public void clickcreatenew() {
		driver.findElement(createnew).click();
	}

	By quizbutton = By.xpath("//body/div[@id='content-container']/div[@id='content-area']/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");
	public void clickquizbutton() {
		driver.findElement(quizbutton).click();
	}

	By titlequiz = By.xpath("//input[@id='testTitle']");
	public void typetitlequiz(String settitlequiz) {
		driver.findElement(titlequiz).sendKeys(settitlequiz);
	}


	// Method to click SignIn Button
	public void clickClassesTab() {
		driver.findElement(getClassesTab).click();
	}

	// Method to type EmailId
	public void typeClassCode(String setClassCode) {
		driver.findElement(getClassCode).sendKeys(setClassCode);
	}

	

	// Method to click SignIn Button
	public void clickOnLoginSignInButton() {
		driver.findElement(LoginSignInButton).click();
	}

	/*
	 * // Method to type EmailId public void typeUsername(String setUsername) {
	 * driver.findElement(Username).sendKeys(setUsername); }
	 */

	/*
	 * // Method to type Password public void typePassword(String setPassword) {
	 * driver.findElement(Password).sendKeys(setPassword); }
	 */

	public void gettoastCloseButton() {
		if (driver.findElement(toastCloseButton).isDisplayed()) {
			driver.findElement(toastCloseButton).click();
		} else {
			System.out.println("No toastCloseButton is present");
		}
	}

	/*
	 * public void loggedInApplication(String setUsername, String setPassword) {
	 * clickSignIn(); typeUsername(setUsername); typePassword(setPassword);
	 * clickOnLoginSignInButton(); }
	 */


	public void VerifyTitle() {
		String titleApplication = driver.getTitle();
		System.out.println("Title of the page:  " + titleApplication);
	}

	public void TearDown() {
		driver.close();
	}

	public void SwitchToIframe() {
		driver.switchTo().frame(2);
	}

	public void FindIframe(String locator) {
		List<WebElement> Iframelist = driver.findElements(By.tagName("iframe"));
		int count = Iframelist.size();
		System.out.println("count of iframe : " +  count);
		for(int i=0;i<count;i++)
		{
			driver.switchTo().frame(i);
			driver.findElement(titlequiz).sendKeys(locator);
			driver.switchTo().defaultContent();
			break;
		}

	}

	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
