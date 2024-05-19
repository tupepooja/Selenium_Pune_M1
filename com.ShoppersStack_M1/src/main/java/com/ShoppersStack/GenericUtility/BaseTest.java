package com.ShoppersStack.GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack.pom.HomePage;
import com.ShoppersStack.pom.LoginPage;
import com.ShoppersStack.pom.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	public WebDriver driver;
	public static WebDriver listenersDriver;
	public FileUtility file=new FileUtility();
	public WelcomePage welcomePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public WebdriverUtility webdriverUtil=new WebdriverUtility();
	public JavaUtility java=new JavaUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public WebDriverWait wait;

	@BeforeSuite
	public void bs() {
		System.out.println("BeforeSuite");
	}

	@BeforeTest
	public void bt() {
		System.out.println("BeforeTest");
		
		spark=new ExtentSparkReporter("./reports/"+java.localDateTime()+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("Demo");
		
	}

	@BeforeClass
	public void bc() throws IOException {
		System.out.println("BeforeClass");

//		String browser = file.readPropertyData("browser");
//		String url = file.readPropertyData("url");
		
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		

		if (browser.contains("chrome")) {
			driver =new ChromeDriver();
		}
		else if (browser.contains("firefox")) {
			driver =new FirefoxDriver();
		}
		else if (browser.contains("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println(" Invalid browser name ");
		}
		listenersDriver=driver;
		welcomePage=new WelcomePage(driver);
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.get(url);
		
	}

	@BeforeMethod
	public void bm() throws IOException, InterruptedException {
		System.out.println("BeforeMethod");
		wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
		Thread.sleep(5000);
		welcomePage.getLoginBtn().click();
		loginPage.getEmailTf().sendKeys(file.readPropertyData("username"));
		loginPage.getPasswordTf().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();
		
	}

	@AfterMethod
	public void am() {
		System.out.println("AfterMethod");
		
		homePage.getAccountBtn().click();
		homePage.getLogoutBtn().click();
		
	}

	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void at() {
		System.out.println("AfterTest");
		report.flush();
	}

	@AfterSuite
	public void as() {
		System.out.println("AfterSuite");
	}

}
