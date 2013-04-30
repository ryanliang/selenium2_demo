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
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
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
		loginPage.login("dummy@dummy.com", "dummypw");
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
		HomePage homePage = loginPage.login("dummy@dummy.com", "dummypw");
		homePage.clickUpdateRaidoBtn();
		homePage.setUpdateMessage("new post 123");
		homePage.clickPostButton();		
	}
	
	@Test	
	@Ignore
	public void shouldHaveMultiplePosts() {
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.goToLoginPage();
		HomePage homePage = loginPage.login("dummy@dummy.com", "dummypw");
		
		System.out.println(homePage.getPosts().size());
		assertTrue(homePage.getPosts().size() > 2);
	}

}
