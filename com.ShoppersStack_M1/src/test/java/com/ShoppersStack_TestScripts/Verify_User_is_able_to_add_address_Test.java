package com.ShoppersStack_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.GenericUtility.ListenersUtility;
import com.ShoppersStack.pom.AddressFormPage;
import com.ShoppersStack.pom.MyAddressPage;
import com.ShoppersStack.pom.MyProfilePage;
import com.aventstack.extentreports.Status;
@Listeners(ListenersUtility.class)
public class Verify_User_is_able_to_add_address_Test extends BaseTest{
	
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
		test.log(Status.INFO,"Navigated to home page");
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		test.log(Status.INFO,"Navigated to myProfile page");
		MyProfilePage myProfilePage=new MyProfilePage(driver);
		myProfilePage.getMyAddressBtn().click();
		test.log(Status.INFO,"Navigated to myAddress page");
		MyAddressPage myAddressPage=new MyAddressPage(driver);
		myAddressPage.getAddAddressBtn().click();
		test.log(Status.INFO,"Navigated to AddressForm page");
		AddressFormPage addressFormPage=new AddressFormPage(driver);
		addressFormPage.getNameTf().sendKeys(file.readExcelData("Sheet1", 1, 0));
		addressFormPage.getHouseTf().sendKeys(file.readExcelData("Sheet1", 1, 1));
		addressFormPage.getStreetTf().sendKeys(file.readExcelData("Sheet1", 1, 2));
		addressFormPage.getLandMarkTf().sendKeys(file.readExcelData("Sheet1", 1, 3));
		webdriverUtil.selectByvalue(addressFormPage.getCountryDd(), file.readPropertyData("country"));
		webdriverUtil.selectByvalue(addressFormPage.getStateDd(), file.readPropertyData("state"));
		webdriverUtil.selectByvalue(addressFormPage.getCityDd(), file.readPropertyData("city"));
		addressFormPage.getPincodeTf().sendKeys(file.readExcelData("Sheet1", 1, 4));
		addressFormPage.getPhoneNumberTf().sendKeys(file.readExcelData("Sheet1", 1, 5));
		addressFormPage.getAddAddressBtn().click();
		
	}
	
}
