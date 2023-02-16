package com.sslweb.automation.test.page.actions;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPDPVerifyDetailsHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
public class SSBPDPVerifyDetailsAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBPDPVerifyDetailsHelper.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPVerifyDetailsHelper ssbpdpverifydetails;
	
	
	public SSBPDPVerifyDetailsAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpverifydetails = new SSBPDPVerifyDetailsHelper(driver);
		js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)"," ");
	}
	
	public void NavigateToPDP(String testCaseName){
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			// Flow for sending product ID in search bar 
			/*WebElementOperationsWeb.park(3);
			ssbpdpverifydetails.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.enterByRobot();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");*/
			ssbpdpverifydetails.ClickonProductCard();
			WebElementOperationsWeb.park(3);	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void VerifyProductDetails(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.VerifyProductDetails();
			WebElementOperationsWeb.park(3);
			ssbpdpverifydetails.VerifyProductPrice();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	
	public void PDPVerifyDetails(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.ClickonProductImage();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
			ssbpdpverifydetails.ClickonCloseButton();
			WebElementOperationsWeb.park(2);
			ssbpdpverifydetails.EasyReturnsClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpverifydetails.CloseOkayButton();
			WebElementOperationsWeb.park(2);
			ssbpdpverifydetails.AuthenticProductClick();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpverifydetails.CloseOkayButton();
			WebElementOperationsWeb.park(2);
			js.executeScript("window.scrollBy(0,400)"," ");
			WebElementOperationsWeb.park(2);
			ssbpdpverifydetails.HowtouseClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	

}
