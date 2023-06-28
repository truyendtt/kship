package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import Pages.AutomationPracticeFormPage;
import Pages.PageInvoid;
import Pages.PageLogin;
import Pages.PageSaleOld;
import common.TestBasic;

public class PracticeFormTest extends Page {
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
//			@Test
//			public void createOrderByJnT () throws IOException {
//				String inputUserName = "admin";
//				String inputPassword = "123456";
//				String inputProductName= "Phấn lót trang điểm L'oreal Paris";
//				String inputCustomerName= "truyền";
//				String inputDeliveryName= "j&t";
//				String inputGroupServiceName="Tiết kiệm hơn";
//				PageLogin pageLogin = new PageLogin(testBase.driver);
//				PageSaleOld pageSaleOld = pageLogin.loginKV(inputUserName, inputPassword);
//				pageSaleOld.closePopup();
//				pageSaleOld.createOrder(inputProductName, inputCustomerName);
//				pageSaleOld.completeOrder(inputDeliveryName, inputGroupServiceName);					
//			} 
//			
		//	@Test
//			public void createOrderByNJV () throws IOException {
//				String inputUserName = "admin";
//				String inputPassword = "123456";
//				String inputProductName= "Phấn lót trang điểm L'oreal Paris";
//				String inputCustomerName= "truyền";
//				String inputDeliveryName= "njv";
//				String inputGroupServiceName="Tiết kiệm hơn";
//				PageLogin pageLogin = new PageLogin(testBase.driver);
//				PageSaleOld pageSaleOld = pageLogin.loginKV(inputUserName, inputPassword);
//				pageSaleOld.closePopup();
//				pageSaleOld.createOrder(inputProductName, inputCustomerName);
//				pageSaleOld.completeOrder(inputDeliveryName, inputGroupServiceName);
//			}
			@Test
			public void createOrderByEMS () throws IOException {
				String inputUserName = "admin";
				String inputPassword = "123456";
				String inputProductName= "Phấn lót trang điểm L'oreal Paris";
				String inputCustomerCode= "KH000018";
				String inputDeliveryName= "ems";
				String inputGroupServiceName="Nhanh";
				PageLogin pageLogin = new PageLogin(testBase.driver);
				PageSaleOld pageSaleOld = pageLogin.loginKV(inputUserName, inputPassword);
				pageSaleOld.closePopup();
				pageSaleOld.createOrder(inputProductName, inputCustomerCode);
				pageSaleOld.completeOrder(inputDeliveryName, inputGroupServiceName);
				pageSaleOld.keyPressed();
				pageSaleOld.keyPressed();
				PageInvoid pageInvoid = pageSaleOld.clickBtnManage();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pageInvoid.getCustomerCode();
			}
			
		
		
}

