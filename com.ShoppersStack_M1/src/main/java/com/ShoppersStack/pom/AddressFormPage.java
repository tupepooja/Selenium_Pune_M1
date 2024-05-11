package com.ShoppersStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage {
	
	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Office")
	private WebElement officeRb;
	
	@FindBy(id = "Name")
	private WebElement nameTf;
	
	@FindBy(id = "House/Office Info")
	private WebElement houseTf;
	
	@FindBy(id = "Street Info")
	private WebElement streetTf;
	
	@FindBy(id = "Landmark")
	private WebElement landMarkTf;
	
	@FindBy(id = "Country")
	private WebElement countryDd;
	
	@FindBy(id = "State")
	private WebElement stateDd;
	
	@FindBy(id = "City")
	private WebElement cityDd;
	
	@FindBy(id = "Pincode")
	private WebElement pincodeTf;
	
	@FindBy(id = "Phone Number")
	private WebElement phoneNumberTf;
	
	@FindBy(id = "addAddress")
	private WebElement addAddressBtn;

	public WebElement getOfficeRb() {
		return officeRb;
	}

	public WebElement getNameTf() {
		return nameTf;
	}

	public WebElement getHouseTf() {
		return houseTf;
	}

	public WebElement getStreetTf() {
		return streetTf;
	}

	public WebElement getLandMarkTf() {
		return landMarkTf;
	}

	public WebElement getCountryDd() {
		return countryDd;
	}

	public WebElement getStateDd() {
		return stateDd;
	}

	public WebElement getCityDd() {
		return cityDd;
	}

	public WebElement getPincodeTf() {
		return pincodeTf;
	}

	public WebElement getPhoneNumberTf() {
		return phoneNumberTf;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}
	
	
	
}
