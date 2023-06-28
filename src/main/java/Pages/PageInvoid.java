package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageInvoid extends Page {
	public PageInvoid(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	By labelInvoidName = By.xpath("//table[@role='treegrid']//tr[2]//td[4]");
	By customerCode = By.xpath("//*[@ng-show='dataItem.Customer.Id && !dataItem.Customer.isDeleted']");
	public String getCustomerCode() {
		clickFromElement(labelInvoidName);
		String A[] = driverWeb.findElement(customerCode).getText().split(" ");
		String result= A[0];
		return result;
	}
	
}