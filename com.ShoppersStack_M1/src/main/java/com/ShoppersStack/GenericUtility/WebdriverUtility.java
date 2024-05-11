package com.ShoppersStack.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	Select sel;
	
	public void selectByvalue(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void takewebpageScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("");
		FileHandler.copy(temp, dest);
		
	}
	
	public void takewebelementScreenshot(WebElement element) throws IOException {
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("");
		FileHandler.copy(temp, dest);
		
	}

}
