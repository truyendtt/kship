package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends Page {
	By txtRetailer = By.id("Retailer");
	By txtUserName = By.id("UserName");
	By txtPassWord = By.id("Password");
	By loginManage = By.name("quan-ly");
	public PageLogin(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public HomePage loginKV(String retailer, String userName, String password) {
		driverWeb.findElement(txtRetailer).sendKeys(retailer);
		driverWeb.findElement(txtUserName).sendKeys(userName);
		driverWeb.findElement(txtPassWord).sendKeys(password);
		driverWeb.findElement(loginManage).click(); 
		return new HomePage(driverWeb);
	}
}
