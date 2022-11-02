package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import Pages.AutomationPracticeFormPage;
import Pages.PageLogin;
import Pages.PageSaleOld;
import common.TestBasic;

public class PracticeFormTest {
			TestBasic testBase = new TestBasic();
			// chua toan bo TC
			//TC01: [PracticeForm] Submit data successfully
			@BeforeMethod
			public void openWWebsite() {
				testBase.openWebsite("https://shippingtest.kvpos.com:59912/man/#/login");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//@AfterMethod
			public void closeBrower() {
				testBase.driver.quit();
			}
			@Test
			public void submitDataSuccessfully() throws IOException {
				String inputUserName = "admin";
				String inputPassword = "123456";
				String inputProductName= "Phấn lót trang điểm L'oreal Paris";
				String inputCustomerName= "truyền";
				PageLogin pageLogin = new PageLogin(testBase.driver);
				PageSaleOld pageSaleOld = pageLogin.loginKV(inputUserName, inputPassword);
				pageSaleOld.cancel();
				pageSaleOld.createOrder(inputProductName, inputCustomerName);
				
				
				
			} 
		
}

