package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends Page {
	By txtUserName = By.id("UserName");
	By txtPassWord = By.id("Password");
	By loginNewSaleOld = By.id("loginNewSaleOld");
	public PageLogin(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public PageSaleOld loginKV(String userName, String password) {
		driverWeb.findElement(txtUserName).sendKeys(userName);
		driverWeb.findElement(txtPassWord).sendKeys(password);
		driverWeb.findElement(loginNewSaleOld).click(); 
		return new PageSaleOld(driverWeb);
	}
}
