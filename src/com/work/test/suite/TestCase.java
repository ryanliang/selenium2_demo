package com.work.test.suite;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.work.test.core.pages.HomePage;
import com.work.test.core.pages.LandingPage;
import com.work.test.core.pages.LoginPage;

public class TestCase {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
	
//		driver = new HtmlUnitDriver();
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		DesiredCapabilities dc = DesiredCapabilities.firefox();
//		dc.setCapability(, value)
		
//		System.setProperty("webdriver.chrome.driver", "C:\\qa-tools\\chrome\\chromedriver.exe");		
//		
//		driver = new ChromeDriver();
//		
		
		
	}
	
	@After
	public void tearDown() {
//		driver.close();
//		driver.quit();
	}
	
	@Test
	@Ignore
	public void shouldGoToLandingPage() {
		LandingPage page = new LandingPage(driver);
	}
	
	@Test
	@Ignore
	public void shouldGoToLoginPage() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();		
	}
	
	@Test	
	@Ignore
	public void shouldToggleKeepMeLogin() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		loginPage.toggleKeepMeLogin();
		
		assertFalse(loginPage.getKeepMeLoginChkBox().isSelected());		
	}
	
	@Test	
	@Ignore
	public void shouldLoginSuccessfully() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		loginPage.login("zliang@mrs.com", "Test1234");
	}
	
	@Test	
	@Ignore
	public void shouldGoToResetPasswordPage() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		loginPage.clickResetPwdLink();
	}
	
	@Test
	@Ignore
	public void shouldPostNewText() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		HomePage homePage = loginPage.login("zliang@mrs.com", "Test1234");
		homePage.clickUpdateRaidoBtn();
		homePage.setUpdateMessage("new post 123");
		homePage.clickPostButton();		
	}
	
	@Test	
	@Ignore
	public void shouldHaveMultiplePosts() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		HomePage homePage = loginPage.login("zliang@mrs.com", "Test1234");
		
		System.out.println(homePage.getPosts().size());
		assertTrue(homePage.getPosts().size() > 2);
	}
	
	@Test
	public void shouldCount() {
		System.out.println(countOccurance("1234123312", "12"));
		
	}
	
	private int countOccurance(String input, String check) {
		
		if (input == null || input.length() == 0) return 0;
		if (check == null || check.length() == 0) return 0;
		if (check.length() > input.length())      return 0;
		
		char[] inputC = input.toCharArray();
		char[] checkC = check.toCharArray();
		
		int count = 0;
		int j = 0;
		
		for (int i = 0; i < inputC.length; i++) {
			if (inputC[i] == checkC[j]) {
				j++;
			} else {
				j = 0;
			}
			
			if (j == checkC.length -1) { // match found
				count++;
				j=0;
			}
		}		
		
		return count;		
	}

}
