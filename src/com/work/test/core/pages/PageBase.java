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


}
