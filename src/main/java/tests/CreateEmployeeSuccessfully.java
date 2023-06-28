package tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.HomePage;
import Pages.PageLogin;
import Pages.PageEmployee;
import common.TestBasic;

public class CreateEmployeeSuccessfully extends Page {
			TestBasic testBase = new TestBasic();
			// chua toan bo TC
			//TC01: [PracticeForm] Submit data successfully
			@BeforeMethod
			public void openWebsite() {
				testBase.openWebsite("https://salon-dev.booking.citigo.net/login?");

			}
			//@AfterMethod
			public void closeBrower() {
				testBase.driver.quit();
			}
			@Test
			public void createEmployeeSuccessfully () throws IOException {
				String inputRetailer ="Truyen";
				String inputUserName = "admin";
				String inputPassword = "1";
				String inputName= "Hoa";
				String textMessage= "Thêm mới nhân viên thành công";
				
				PageLogin pageLogin = new PageLogin(testBase.driver);
				HomePage homePage = pageLogin.loginKV(inputRetailer,inputUserName, inputPassword);
				PageEmployee pageEmployee = homePage.clickFromEmployee();
				pageEmployee.CreateEmployee(inputName);
				Assert.assertEquals(pageEmployee.getTextName(),inputName);
				Assert.assertEquals(pageEmployee.getTexMessage(),textMessage);

			}

}

