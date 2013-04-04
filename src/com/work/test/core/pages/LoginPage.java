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

import com.work.test.core.common.Constants;

import static org.junit.Assert.assertTrue;

public class LoginPage extends PageBase{

	final String pageName = "LoginPage";
	final String url      = "https://app.work.com/#login";
	
	private final String USERNAME_BY_CSS = "input[id='10f609783b815858'][name='j_username']";  
	private final String PASSWORD_BY_ID = "10f609781286c67a";  
	private final String PASSWORD_INPUT_BY_ID = "10f6097849fcde43";
	private final String LOGIN_BTN_BY_ID = "10f60978316c0ffb";
	private final String RESET_PW_LINK_BY_XPATH = "//a[@href='#resetpwd']";
	private final String KEEP_ME_LOGIN_LINK_BY_XPATH = "10f60978455ecaa";
	
	@FindBy(how=How.CSS,   using=USERNAME_BY_CSS)              WebElement username;
	@FindBy(how=How.ID,    using=PASSWORD_BY_ID)               WebElement password;
	@FindBy(how=How.ID,    using=PASSWORD_INPUT_BY_ID)         WebElement passwordInput;
	@FindBy(how=How.ID,    using=LOGIN_BTN_BY_ID)              WebElement loginButton;
	@FindBy(how=How.XPATH, using=RESET_PW_LINK_BY_XPATH)       WebElement resetPasswordLink;
	@FindBy(how=How.ID,    using=KEEP_ME_LOGIN_LINK_BY_XPATH)  WebElement keepMeLoginChkBox;
	
	@Override
	protected void load() {
		driver.get(url);
	}
	
	@Override
	protected void isLoaded() {
		String currUrl = driver.getCurrentUrl();
		System.out.println(currUrl);
		assertTrue("Not on " + pageName, currUrl.contains("#login"));	
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.get();
		PageFactory.initElements(this.driver, this);
	}
	
	public HomePage login(String user, String pw) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_IN_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(username));		
		username.clear();
		username.sendKeys(user);			
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PASSWORD_BY_ID)));
		password.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LOGIN_BTN_BY_ID)));
		passwordInput.sendKeys(pw);
		
		loginButton.click();
		
		return new HomePage(driver);
	}
	
	public void toggleKeepMeLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_IN_SECONDS);
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
