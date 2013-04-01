package com.work.test.core.pages;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.google.common.base.Function;
import com.google.common.base.Predicate;



public abstract class PageBase extends LoadableComponent<PageBase>{
	WebDriver driver;
	
	abstract protected void load();
	abstract protected void isLoaded();
	
//	SearchContext driver2;
	
//	protected WebElement findElement(SearchContext context, By by, long timeoutSeconds, long sleepMilliseconds) {
//	    @SuppressWarnings("unchecked")
//	    FluentWait<SearchContext> wait = new FluentWait<SearchContext>(context)
//	            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
//	            .pollingEvery(sleepMilliseconds, TimeUnit.MILLISECONDS)
//	            .ignoring(NotFoundException.class);
//	    WebElement element = null;
//	    try {
//	        element = wait.until(new Function<WebElement, Boolean>
//	    }
//	    catch (TimeoutException te) {
//	        element = null;
//	    }
//	    return element;
//	}
//	protected Function<SearchContext, WebElement> elementLocatedBy(final By by) {
//		return new Function<SearchContext, WebElement>() {
//			@Override
//			public WebElement apply(SearchContext sc) {
//				return sc.findElement(by);
//			}
//		};
//		
//	}
//		
//		
//	protected WebElement myFindElement(SearchContext sc, By by) {
//		FluentWait<SearchContext> wait = new FluentWait<SearchContext>(sc)
//			.withTimeout(10, TimeUnit.SECONDS)
//			.pollingEvery(100, TimeUnit.MILLISECONDS)
//			;
//		
//		WebElement result = null;
//		
//		try {
//			result = wait.until(elementLocatedBy(by));
//		} catch (TimeoutException e) {
//			return null;
//		}
//		
//		return result;
//		
//		
//	}
	
	

}
