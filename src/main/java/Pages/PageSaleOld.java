package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class PageSaleOld extends Page {
//	By btnCancel= By.className("introjs-button introjs-nextbutton introjs-fullbutton");
	By btn = By.cssSelector(".introjs-skipbutton");
	By txtSearchProductInput = By.id("productSearchInput");
	By txtSearchCustomerInput = By.id("customerSearchInput");
	By txtDeliveryPartnerSearchInput = By.id("deliveryPartnerSearchInput");
	By btnPay = By.id("saveTransactionDelivery");
	
	By btnNewSale = By.className("switch-newpos");
	public PageSaleOld(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public void cancel() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(driverWeb.findElement(btn).getText());
		driverWeb.findElement(btn).click();
		
	}
	public void createOrder(String productName, String customerName) {
		driverWeb.findElement(txtSearchProductInput).sendKeys(productName);
		driverWeb.findElement(txtSearchProductInput).sendKeys(Keys.ENTER);
		driverWeb.findElement(txtSearchCustomerInput).sendKeys(customerName);
		driverWeb.findElement(txtSearchCustomerInput).sendKeys(Keys.ENTER);
	}
}
