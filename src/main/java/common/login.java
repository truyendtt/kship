package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login<HomePage> {
	public WebDriver driver;
	By txtRetailer = By.id("Retailer");
	By txtUserName = By.id("UserName");
	By txtPassWord = By.id("Password");
	By loginManage = By.name("quan-ly");
	public login<HomePage> loginKV(String retailer, String userName, String password) {
      driver.findElement(txtRetailer).sendKeys(retailer);
      driver.findElement(txtUserName).sendKeys(userName);
      driver.findElement(txtPassWord).sendKeys(password);
      driver.findElement(loginManage).click();
      return new login<HomePage>();
	}
}
