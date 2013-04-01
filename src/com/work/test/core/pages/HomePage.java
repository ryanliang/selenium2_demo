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
	
	private final  String POST_BUTTON_BY_ID = "7290e7453188e16a"; 
	
	//
	@FindBy(how=How.XPATH, using="//div[@id='7290e7454652a2fb']/div/input")	WebElement postTitle;
	@FindBy(how=How.XPATH, using="//textarea[@id='AbstractGeneralMessageForm-text-area']")	WebElement updateMessageTextArea;
	@FindBy(how=How.ID, using=POST_BUTTON_BY_ID)	WebElement postButton;
	@FindBy(how=How.ID, using="7290e7452416208f")	WebElement div;
	@FindBy(how=How.XPATH, using ="//span[@id='7290e7455402f836']/input") WebElement updateRadioBtn;	
	
	
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
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(POST_BUTTON_BY_ID)));		
		 new FluentWait<WebDriver>(driver).
         withTimeout(10, TimeUnit.SECONDS).
         pollingEvery(100,TimeUnit.MILLISECONDS).
         until(new Function<WebDriver, Boolean>() {
             @Override
             public Boolean apply(WebDriver driver) {
//                 return element.getText().endsWith("04");
            	 return true;
             }
         }
         );
		 
		 postButton.click();
	}
			
			

		
	
	
	public void clickUpdateRaidoBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='7290e7455402f836']/input")));	
		updateRadioBtn.click();
	}
	
	public List<WebElement> getPosts() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("5496d56413e50b75")));
		
		return driver.findElements(By.id("5496d56413e50b75"));
		
		
//		String xpathPattern = "//div[@id='5496d5641f973938']/div/div[1]/table/tbody/tr/td[2]/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div";
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#5496d56413e50b75.GJBBPSCB0E"))));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("1ee3e5ab6b8bf940"))));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathPattern))));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathPattern)));
	
//		return driver.findElements(By.cssSelector("div#5496d56413e50b75.GJBBPSCB0E"));
//		return driver.findElements(By.id("1ee3e5ab6b8bf940"));
//		return driver.findElements(By.xpath(xpathPattern));
		
	}
	
}
