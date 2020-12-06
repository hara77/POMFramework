package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BrowserSetup;
import PageObjectRepository.CKLoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	CKLoginPage CKL;
	@BeforeMethod
	public void homenavigation() throws InterruptedException {
		
		String current = System.getProperty("user.dir");
		System.out.println("Current working directory in Java : " + current);
		File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	}
	
	@Test
    public void LoginPage() {
	    CKL = new CKLoginPage(driver);
		CKL.clickSignIn();
		CKL.pause(10000);
		CKL.getusername("chatterjeeamit42@gmail.com");
		CKL.pause(10000);
		CKL.getPassword("Testing123$");
		CKL.pause(10000);
		CKL.clickOnLoginSignIn();
		CKL.pause(10000);
	}
    
	@AfterMethod
    public void ClosBrowser() {
		CKL.TearDown();
   	}

}
