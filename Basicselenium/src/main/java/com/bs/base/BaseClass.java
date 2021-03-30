package com.bs.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	Properties prop;
	 ExtentReports extent;
	 ExtentTest logger;
	 
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	@BeforeSuite()
	public void cofig() throws IOException {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\USER\\eclipse-workspace\\Basicselenium\\TestOutput\\ExtentReport\\ExtentReportsresults.html");
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 
		 
		 
		 
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\USER\\eclipse-workspace\\Basicselenium\\Configuration\\config.properties");
		prop.load(fis);

	}
	/*
	 * public void test_name(String testname) { logger=extent.createTest(testname);
	 * } public void test_step(String message) { logger.log(Status.PASS, message); }
	 */
	
	public void launch() {

		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
	}
	@AfterSuite()
	public void afterSuite() {
		
		 extent.flush();
	}
}