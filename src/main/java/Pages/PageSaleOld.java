package Pages;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class PageSaleOld extends Page {
	By btnClose= By.xpath("//a[@class='introjs-skipbutton']");
	By txtSearchProductInput = By.id("productSearchInput");
	By txtSearchCustomerInput = By.id("customerSearchInput");
	By btnPay = By.id("saveTransactionDelivery");
	By btnNewSale = By.className("switch-newpos");
	By btnClose1= By.xpath("//a[text()='Đóng']");
	By btnCloseNote = By.xpath("//span[@class='k-icon k-i-close']");
	By labelCustomer = By.xpath("//h5[text()='Truyền']");
	By btnNhanh= By.xpath("//*[text()='Nhanh']");
	By btnTrongNgay= By.xpath("//*[text()=' Trong ngày']");
	By btnManage = By.xpath("//*[text()='Quản lý']");
	By iconListManage = By.xpath("//*[@class='icon-link list-bar']");
	public PageSaleOld(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public void closePopup() {
		
		clickFromElement(btnClose);
	}
	public void createOrder(String productName, String customerName) {
		driverWeb.findElement(txtSearchProductInput).sendKeys(productName);
		driverWeb.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driverWeb.findElement(txtSearchProductInput).sendKeys(Keys.ENTER);
		driverWeb.findElement(txtSearchCustomerInput).sendKeys(customerName);	
		clickFromElement(labelCustomer);
		clickFromElement(btnClose1);
	}
	public static By selectDelivery(String nameDelivery){
		By result= null;
		switch (nameDelivery) {
		case "j&t": result= By.xpath("//table//tr[1]//td[2]"); 
		break;
		case "njv": result= By.xpath("//table//tr[4]//td[2]");
		break;
		case "ghtk": result= By.xpath("//table//tr[5]//td[2]");
		break;
		case "vtp": result= By.xpath("//table//tr[3]//td[2]");
		break;
		case "best": result= By.xpath("//table//tr[7]//td[2]");
		break;
		case "vnp": result= By.xpath("//table//tr[9]//td[2]");
		break;
		case "ems": result= By.xpath("//table//tr[1]//td[2]");
		break;
		case "ahamove": result= By.xpath("//table//tr[3]//td[2]");
		break;
		case "grap": result= By.xpath("//table//tr[10]//td[2]");
		break;
		case "ghn": result= By.xpath("//table//tr[10]//td[2]");
		break;
		}
		return result;
	}
	public void completeOrder(String nameDelivery, String groupName ) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		By groupNameService= selectGroupService(groupName);
		clickFromElement(groupNameService);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		By HVC= selectDelivery(nameDelivery);
		clickFromElement(HVC);
		clickFromElement(btnPay);
		clickFromElement(btnCloseNote);
	}
	public By selectGroupService(String groupName) {
		By result= null;
		switch (groupName) {
		case "Tiết kiệm hơn": result= By.xpath("//*[text()=' Tiết kiệm hơn']");
		break;
		case "Nhanh": result= By.xpath("//*[text()=' Nhanh']");
		break;
		case "Trong ngày": result= By.xpath("//*[text()=' Trong ngày']");
		break;
		}
		return result;
	}
	
	public void keyPressed() {

		Robot robot;
		try {
			Thread.sleep(5000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        // Nhập từ khóa selenium 
    }
	public PageInvoid clickBtnManage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickFromElement(iconListManage);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickFromElement(btnManage);
		return new PageInvoid(driverWeb);
	}
}
