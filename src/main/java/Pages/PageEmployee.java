package Pages;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageEmployee extends Page {
	By btnCreateEmployee = By.xpath("//aside//span[contains(text(),'Nhân viên')]");
	//By txtName= By.xpath("//div[@class = 'col-md-6']/div[2]//div[1]//input[1]");
	//By txtName = By.cssSelector("input.ts-form-control.ng-pristine.ng-valid.ng-empty.ng-valid-maxlength.ng-touched[ng-model=\"vm.employee.name\"]"); 
	By txtName = By.cssSelector("[ng-model=\"vm.employee.name\"]");
	By btnSave= By.id("btnSave");
	public By txtNameEmployee= By.xpath("//td[6]/span[1]");
	By toastMessage= By.className("toast-message");
	By btnUpdateInfor = By.xpath("//div[@class='ts-group-btn']//button[2]");
	public PageEmployee(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public void CreateEmployee(String nameEmployee) {
		
		clickFromElement(btnCreateEmployee);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driverWeb.findElement(txtName).sendKeys(nameEmployee);
		driverWeb.findElement(btnSave).click();
	}
	
	public String getTextName() {
		
		return driverWeb.findElement(txtNameEmployee).getText();
	}
	public String getTexMessage() {
		WebElement webElement = new WebDriverWait(driverWeb, Duration.ofSeconds(20))
		          .until(driver -> driver.findElement(toastMessage));
		return driverWeb.findElement(toastMessage).getText();
	}
	
	public UpdateEmployeePage clickFormUpdateInformationEmployee() {
		clickFromElement(txtNameEmployee);
		clickFromElement(btnUpdateInfor);
		return new UpdateEmployeePage(driverWeb);
	}
}
