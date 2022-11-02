package Pages;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.reporters.Files;

//import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AutomationPracticeFormPage extends Page {
	
	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtEmail = By.id("userEmail");
	By radioGender= By.xpath("//*[@for='gender-radio-1']");
	By txtMobile = By.id("userNumber");
	By btnSubmit = By.id("submit");
	By btnUploadimage = By.id("uploadPicture");
	By datePicker = By.id("dateOfBirthInput");
	By btnMonth= By.className("react-datepicker__month-select");
	By btnYear= By.className("react-datepicker__year-select");
	By txtState = By.id("react-select-3-input");
	By txtCity = By.id("react-select-4-input");
	
	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
		this.driverWeb = dr;
	}
	public void inputFirstName(String inputFirstName) {
		driverWeb.findElement(txtFirstName).sendKeys(inputFirstName);
		
	}
	public void inputLastName(String inputLastName) {
		driverWeb.findElement(txtLastName).sendKeys(inputLastName);
	}
	public void inputEmail(String inputEmail) {
		driverWeb.findElement(txtEmail).sendKeys(inputEmail);
	}
	public By getGenderXpath(String inputGender) {
		By result= null;
		if ( inputGender.equalsIgnoreCase("Male")) {
			result = By.xpath("//*[@for='gender-radio-1']");
		} else if (inputGender.equalsIgnoreCase("Female")) {
			result = By.xpath("//*[@for='gender-radio-2']");
		} else if (inputGender.equalsIgnoreCase("Other")) {
			result = By.xpath("//*[@for='gender-radio-3']");
		}
		return result;
	}
	public void inputGender(String inputGender) {
		driverWeb.findElement(getGenderXpath(inputGender)).click();
	}
	public void inputMobile(String inputMobile) {
		driverWeb.findElement(txtMobile).sendKeys(inputMobile);
		
	}
	
	public void inputImage(String inputPathImage) {
		WebElement fileInput=  driverWeb.findElement(btnUploadimage);
		fileInput.sendKeys(inputPathImage);
	}
	
	
	
	public void inputDateOfBirth(String inputDate) {
		driverWeb.findElement(datePicker).click();
		inputDate = inputDate.replace(",", " ");
		String [] arrayDate= inputDate.split(" ");
		String day = new String(arrayDate[0]);
		String month = new String(arrayDate[1]);
		String year = new String(arrayDate[2]);
		selectElementFromDropdown(btnMonth, month);
		selectElementFromDropdown(btnYear, year);
		String xpathDay= String.format("//div[contains(text(),'%s')]", day);
		System.out.println(xpathDay);
		driverWeb.findElement(By.xpath(xpathDay)).click();
	}
	public void selectStateOfCity(String inputStateAndCity) {
		String [] arrayStateAndCity = inputStateAndCity.split(" ");
		String inputState= new String(arrayStateAndCity[0]);
		String inputCity= new String(arrayStateAndCity[1]);
		driverWeb.findElement(txtState).sendKeys(inputState);
		driverWeb.findElement(txtState).sendKeys(Keys.ENTER);
		driverWeb.findElement(txtCity).sendKeys(inputCity);
		driverWeb.findElement(txtCity).sendKeys(Keys.ENTER);
		
	}
	public By getElementsubmitBtn() {
		return btnSubmit;
	}

	
	
	
	public String FileName(String inputPathImage) throws IOException{
		Path path = Paths.get(inputPathImage);
		Path PathName = path.getFileName();
		String FileName= PathName.toString();
		System.out.println(FileName);
		return FileName;
	}
	public void submitFail() {
		//boolean result= false;
		driverWeb.findElement(btnSubmit).click();
		String border= driverWeb.findElement(txtMobile).getCssValue("border-color");
		System.out.println(border);
		//if (border== "#dc3545"){
	//		result= true;
		//} else result= false;
	//	return result;
	}
	public void getBoderColor() {
		driverWeb.findElement(btnSubmit).click();
		System.out.println(driverWeb.findElement(txtMobile).getCssValue("border-color"));
	}
	public void scrollBrower() {
		
		JavascriptExecutor js = (JavascriptExecutor) driverWeb;
		js.executeScript("window.scrollBy(0,50)");
	}
	public void get() {
		WebElement element = driverWeb.findElement(By.id("currentAddress"));
		int elementWidth= element.getSize().getWidth();
		int elementHeight= element.getSize().getHeight();
		Point poit= element.getLocation();
		int x= poit.getX();
		int y= poit.getY();
		int xOffset= x+ elementWidth-5;
		int yOffset= y+ elementHeight-5;
		Actions action = new Actions(driverWeb);	
		action.moveByOffset(xOffset, yOffset).clickAndHold().moveByOffset(50, 30).release().build().perform();
		
	}
}
