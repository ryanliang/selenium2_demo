package com.work.test.core.pages;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import static org.junit.Assert.assertTrue;

public class HomePage extends PageBase {

	WebDriver driver;
	final String url = "https://app.work.com/#home";
	final String pageName = "HomePage";
	
	private final String POST_BUTTON_BY_ID = "7290e7453188e16a";
	private final String POST_TTITLE_BY_XPATH = "//div[@id='7290e7454652a2fb']/div/input";
	private final String UPDATE_TEXT_BY_XPATH = "//textarea[@id='AbstractGeneralMessageForm-text-area']";
	private final String UPDATE_RADIO_BTN_BY_XPATH = "//span[@id='7290e7455402f836']/input";
	private final String POST_DIV = "5496d56413e50b75";
	
	
	@FindBy(how=How.XPATH, using=POST_TTITLE_BY_XPATH)	     WebElement postTitle;
	@FindBy(how=How.XPATH, using=UPDATE_TEXT_BY_XPATH)	     WebElement updateMessageTextArea;
	@FindBy(how=How.ID,    using=POST_BUTTON_BY_ID)	         WebElement postButton;
	@FindBy(how=How.XPATH, using=UPDATE_RADIO_BTN_BY_XPATH)  WebElement updateRadioBtn;	
	
	
	public HomePage(WebDriver driver) {
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
		assertTrue("Not on " + pageName, currUrl.contains("#home"));		
	}
	
	
	public HomePage setUpdateMessage(String message) {
		updateMessageTextArea.sendKeys(message);
		return this;			
	}
	
	public void clickPostButton() {
		 new FluentWait<WebDriver>(driver).
         withTimeout(10, TimeUnit.SECONDS).
         pollingEvery(100,TimeUnit.MILLISECONDS).
         until(new Function<WebDriver, Boolean>() {
             @Override
             public Boolean apply(WebDriver driver) {
                 return driver.findElement(By.id(POST_BUTTON_BY_ID)).isEnabled();            	 
             }
         }
         );
		 
		 postButton.click();
	}
	
	public void clickUpdateRaidoBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UPDATE_RADIO_BTN_BY_XPATH)));	
		updateRadioBtn.click();
	}
	
	public List<WebElement> getPosts() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(POST_DIV)));
		
		return driver.findElements(By.id(POST_DIV));

	}
	
}
