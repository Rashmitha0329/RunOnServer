package com.orangeHRM.testcase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iween.testBase.baseClass;
import com.iween.utilities.DataProviders;
import com.iween.utilities.ExtentManager;
import com.iween.utilities.Iween_FutureDates;
import com.iween.utilities.Retry;
import com.iween.utilities.ScreenshotUtil;


import com.skytraveller.pageObjects1.loginPage;


public class TCCP_1 extends baseClass {

	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class)
	//,retryAnalyzer = Retry.class
	public void myTest(Map<String, String> excelTestData) throws Exception {

		ExtentTest test = ExtentManager.getTest();  // Get the ExtentTest instance from thread-local
		logger.info("******** Starting TestCase1: testLogin ********");



		try {
			System.out.println("Running test with: " + excelTestData);
        	test.log(Status.INFO, "Search To Booking Supplier Wise");
        	//Get The Data From Excel
            String departFrom = excelTestData.get("Depart From");
            loginPage loginPage = new loginPage(driver);
            loginPage.UserLoginHRM(p.getProperty("username"), p.getProperty("password"));
            Thread.sleep(2000);
            loginPage.clickOnLoginButtonHRM();
            test.log(Status.INFO,"Clicked on Login Button");
            Thread.sleep(2000);
            loginPage.searchHRM(test);
            Thread.sleep(2000);
            loginPage.validateAdminPageisDisplayed(test);
            
            Thread.sleep(2000);
   		
            logger.info("******** TestCase1: testLogin completed successfully ********");


		} catch (Exception e) {
			logger.error("Test failed due to: ", e);
			test.fail("Test failed with exception: " + e.getMessage());
			throw e;  // Re-throw to ensure Retry works properly
		}
	}
}
