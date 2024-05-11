package com.ShoppersStack_TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.GenericUtility.ListenersUtility;
import com.ShoppersStack.pom.MyAddressPage;
import com.ShoppersStack.pom.MyProfilePage;
@Listeners(ListenersUtility.class)
public class Verify_user_is_able_to_delete_address_Test extends BaseTest{

	@Test
	public void deleteAddress() throws InterruptedException {
		
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfilePage profilePage=new MyProfilePage(driver);
		profilePage.getMyAddressBtn().click();
		
		MyAddressPage addressPage=new MyAddressPage(driver);
		Thread.sleep(2000);
		addressPage.getDeleteBtn().click();
		Thread.sleep(2000);
		addressPage.getYesBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}
	
}
