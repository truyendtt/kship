package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;

public class PageSaleOld extends Page {
	By btnNext= By.xpath("//a[@class='introjs-skipbutton']");
	By txtSearchProductInput = By.id("productSearchInput");
	By txtSearchCustomerInput = By.id("customerSearchInput");
	By btnPay = By.id("saveTransactionDelivery");
	By btnNewSale = By.className("switch-newpos");
	public PageSaleOld(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public void cancel() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement next = driverWeb.findElement(btnNext);
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driverWeb;
		executor.executeScript("arguments[0].click();", next); 

	}
	public void createOrder(String productName, String customerName) {
		driverWeb.findElement(txtSearchProductInput).sendKeys(productName);
		driverWeb.findElement(txtSearchProductInput).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driverWeb.findElement(txtSearchCustomerInput).sendKeys(customerName);	
		WebElement next = driverWeb.findElement(By.xpath("//li[@val='Truyền']"));	
		JavascriptExecutor executor = (JavascriptExecutor)driverWeb;
		executor.executeScript("arguments[0].click();", next); 
		
	}
}
