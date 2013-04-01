package com.work.test.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.assertTrue;

public class LandingPage extends PageBase {

	WebDriver driver;
	final String url = "https://www.work.com";
	final String pageName = "LandingPage";
	
	
	@FindBy(how=How.ID, using="login-link")	WebElement loginLink;
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		this.get();
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		driver.get(url);		
	}
	
	@Override
	protected void isLoaded() {
		String currUrl = driver.getCurrentUrl();
		System.out.println(currUrl);
		assertTrue("Not on " + pageName, currUrl.contains("work.com"));		
	}
	
	public LoginPage goToLoginPage() {
		loginLink.click();
		return new LoginPage(driver);
	}
	
	
	
	
	
}
