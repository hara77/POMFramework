package BaseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;

public class BrowserSetup {

	public static WebDriver driver;

	public static WebDriver StartBrowser(String browsername, String url) throws InterruptedException {
		// If the browser is Firefox
		if (browsername.equalsIgnoreCase("Firefox")) {
			// Set the path for geckodriver.exe
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.gecko.driver",path+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}

		// If the browser is Chrome
		else if (browsername.equalsIgnoreCase("Chrome")) {
			// Set the path for chromedriver.exe
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		// If the browser is IE
		else if (browsername.equalsIgnoreCase("IE")) {
			// Set the path for IEdriver.exe
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.ie.driver",path+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
		}

		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.get(url);
		return driver;
	}
	
	
	public void failed()
	{
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(srcFile, new File("/CucumberSelenium/Screenshots"
	+ "ScreenshotsTaken/tests.jpg"));
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	 
	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "//Screenshots//" + s + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}