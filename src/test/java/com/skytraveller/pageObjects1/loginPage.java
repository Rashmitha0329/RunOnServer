package com.skytraveller.pageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iween.utilities.ScreenshotUtil;

public class loginPage extends BasePage{

	// Constructor of loginPage calls the BasePage constructor with driver
	public loginPage(WebDriver driver) {
		super(driver);// calls BasePage constructor
	}

	
	
	
 
@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userNameHrm;
 
@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordHrm;
 
public void UserLoginHRM(String uName, String pwd) throws InterruptedException
	{
		try
		{
		System.out.println(uName);
		System.out.println(pwd);
		Thread.sleep(2000);
		userNameHrm.sendKeys(uName);
		passwordHrm.sendKeys(pwd);
		//submit.click();
		}
		catch(Exception e)
		{
			
		  e.printStackTrace();
		  Assert.fail();
		}
 
	}
	
	public void clickOnLoginButtonHRM()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void searchHRM(ExtentTest test) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Admin");
		test.log(Status.INFO,"Searched for Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a")).click();
		test.log(Status.INFO,"clicked on Admin DropDown");
		Thread.sleep(3000);
		
	}
 
	public void validateAdminPageisDisplayed(ExtentTest test)
	{
		try {
		WebElement adminPage=driver.findElement(By.xpath("//h5[text()='System Users']"));
		if(adminPage.isDisplayed())
		{
			test.log(Status.PASS,"adminPage is displayed");
		}
		else
		{
			test.log(Status.PASS,"adminPage is not displayed");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception validateAdminPageisDisplayed "+e.getMessage());
		}
	}
	
	
 


}
