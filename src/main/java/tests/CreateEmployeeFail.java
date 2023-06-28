package tests;

import org.testng.annotations.Test;
import Pages.HomePage;
import org.testng.Assert;
import Pages.PageEmployee;
public class CreateEmployeeFail extends TestCase {

			@Test
			public void createEmployeeFail ()  {

				String inputName= "";
				String expecedTextMessage= "Tên nhân viên không được để trống";
				HomePage homePage = new HomePage(testBase.driver);
				PageEmployee pageEmployee = homePage.clickFromEmployee();
				pageEmployee.CreateEmployee(inputName);
				Assert.assertEquals(pageEmployee.getTexMessage(),expecedTextMessage);
				
				
			}
			
		
		
}

