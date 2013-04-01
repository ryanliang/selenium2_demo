package com.work.test.core.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage extends PageBase{

	final String pageName = "LoginPage";
	final String url      = "https://app.work.com/#login";
	
//	@FindBy(how=How.ID_OR_NAME,using="j_username") WebElement username;
	@FindBy(how=How.CSS,using="input[id='10f609783b815858'][name='j_username']") WebElement username;
	@FindBy(how=How.ID,using="10f609781286c67a") WebElement password;
	@FindBy(how=How.ID,using="10f6097849fcde43") WebElement passwordInput;
	@FindBy(how=How.ID, using="10f60978316c0ffb")  WebElement loginButton;
	@FindBy(how=How.XPATH, using="//a[@href='#resetpwd']")  WebElement resetPasswordLink;
	@FindBy(how=How.ID, using="10f60978455ecaa")  WebElement keepMeLoginChkBox;
	
	@Override
	protected void load() {
		driver.get(url);
	}
	
	@Override
	protected void isLoaded() {
		String currUrl = driver.getCurrentUrl();
		System.out.println(currUrl);
//		assertTrue("Not on " + pageName, currUrl.contains("#login"));	
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.get();
		PageFactory.initElements(this.driver, this);
	}
	
	public HomePage login(String user, String pw) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));		
		username.clear();
		username.sendKeys(user);
//		username.sendKeys(Keys.TAB);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("10f609781286c67a")));
//		wait.until(ExpectedConditions.presenceOfElementLocated(password));

		password.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("10f6097849fcde43")));

		passwordInput.sendKeys(pw);
		
		loginButton.click();
		
		return new HomePage(driver);
	}
	
	public void toggleKeepMeLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(keepMeLoginChkBox));
		
		keepMeLoginChkBox.click();
	}
	
	public void clickResetPwdLink() {
		resetPasswordLink.click();
	}
	
	public WebElement getKeepMeLoginChkBox() {
		return keepMeLoginChkBox;
	}
}
