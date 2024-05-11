package com.ShoppersStack.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility implements ITestListener,ISuiteListener{
	
	JavaUtility java=new JavaUtility();
	
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)BaseTest.listenersDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest =new File(FrameWorkConstants.screenshot+java.localDateTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
