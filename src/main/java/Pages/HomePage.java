package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
	By btnGroupEmployee= By.xpath("//section/ul/li[6]/a");
	By checkbox = By.xpath("//*[text()=' Không hiển thị lần sau']");
	By iconCancer = By.className("popup-close");
	By btnEmployee = By.xpath("//a[contains(@href, '/truyen/#/Employee/')]");
	public HomePage(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public PageEmployee clickFromEmployee() {
		clickFromElement(checkbox);
		//clickFromElement(iconCancer);
		clickFromElement(btnGroupEmployee);
		clickFromElement(btnEmployee);
		return new PageEmployee(driverWeb);
	}
}
