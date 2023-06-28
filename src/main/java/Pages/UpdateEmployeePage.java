package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class UpdateEmployeePage extends Page{
	By txtName = By.cssSelector("[ng-model=\"vm.employee.name\"]");
	By txtNickName = By.cssSelector("[ng-model=\"vm.employee.nickName\"]");
	By iconDatePicker = By.xpath("//*[@aria-controls='dobDate_dateview']");
	By radioButtonFemale = By.xpath("//label[contains(.,'Nữ')]]");
	By radioButtonMale = By.xpath("//label[contains(.,'Nam')]");
	By ddDerpartmentList= By.xpath("//span//span//span[contains(.,'Chọn phòng ban')]");
	//By searchDerpartmentList = By.xpath("//input[@aria-owns='department_listbox']");
	//By searchDerpartmentList= By.cssSelector("#department-list .k-textbox");
	By searchDerpartmentList=By.xpath("//div[@id='department-list']//span[@class='k-list-filter']//input");
	//By resultDerpartmanetList= By.xpath("//ul[@id='department_listbox']//li[contains(.,'phòng Kinh doanh')]");
	//By btnUploadimage = By.xpath("//span[contains(.,'Chọn ảnh')]"); k-button k-upload-button //ts-employee-profile-picture-single-upload/div[2]/div/div/input
	By btnUploadimage = By.xpath("//ts-employee-profile-picture-single-upload/div[2]/div/div/input");
	//By btnUploadimage = By.cssSelector("div.k-button.k-upload-button");
	By iconArrow= By.cssSelector("a.k-link.k-nav-prev");
	By txtLabelDate= By.xpath("//a[contains(.,'June 2023')]");
	By btnSave= By.xpath("//* [@ng-click='vm.handleClickSave()']");
	By btnConfirm = By.xpath("//button[contains(.,'Đồng ý')]");
	By txtlabelUploadSuccessfully = By.xpath("//strong[contains(.,'Done')]");
	public UpdateEmployeePage(WebDriver dr) {
		super(dr);
		this.driverWeb= dr;
	}
	public void updateNickName(String inputNickName) {
		driverWeb.findElement(txtNickName).sendKeys(inputNickName);
	}
//	public void updateBirthday(String inputDate) {
//		driverWeb.findElement(txtDateOfBirth).sendKeys(Keys.DELETE);
//		driverWeb.findElement(txtDateOfBirth).sendKeys(inputDate);
//	}
	public void updateBirthday(String inputDate) {
		getTimes(inputDate);
		clickFromElement(iconDatePicker);
		clickFromElement(txtLabelDate);
		for (int i= 1; i<=getTimes(inputDate); i++ ){
			clickFromElement(iconArrow);
		}
		String xpathMonth= String.format("//a[contains(.,'%s')]", getInputMonth(inputDate));
		driverWeb.findElement(By.xpath(xpathMonth)).click();
		inputDate = inputDate.replace("/", " ");
		String [] arrayDate= inputDate.split(" ");
		String day = new String(arrayDate[0]);
		String xpathDay= String.format("//a[contains(.,'%s')]", day);
		clickFromElement(By.xpath(xpathDay));
	}
	private String date(){
		Date date = new Date();
		// Hien thi date va time boi su dung toString()
		String dateNow = String.format("%s %tB %<tY",
				"Date:", date);
		return dateNow ;
	}
	private int getTimes(String inputDate){
		int inputYear= getInputYear(inputDate);
		String inputDateNow= date();
		String [] arrayDate= inputDateNow.split(" ");
		String year= new String(arrayDate[2]);
		int yearNow = Integer.parseInt(year);
		int times= yearNow - inputYear;
		return times;
	}
	private int getInputYear(String inputDate){
		inputDate = inputDate.replace("/", " ");
		String [] arrayDate= inputDate.split(" ");
		String year = new String(arrayDate[2]);
		int inputYear= Integer.parseInt(year);
		return inputYear;
	}
	private String getInputMonth(String inputDate){
		inputDate = inputDate.replace("/", " ");
		String [] arrayDate= inputDate.split(" ");
		String Month = new String(arrayDate[1]);
		String result= "";
		switch (Month) {
			case "01": result= "Jan";
				break;
			case "02": result= "Feb";
				break;
			case "03": result= "Mar";
				break;
			case "04": result= "Apr";
				break;
			case "05": result= "May";
				break;
			case "06": result= "Jun";
				break;
			case "07": result= "Jul";
				break;
			case "08": result= "Aug";
				break;
			case "09": result= "Sep";
				break;
			case "10": result= "Oct";
				break;
			case "11": result= "Nov";
				break;
			case "12": result= "Dec";
				break;
		}
		return result;
	}
	public void updateGender(String inputGender) {
		if (inputGender== "female") {
		driverWeb.findElement(radioButtonFemale).click();}
		else driverWeb.findElement(radioButtonMale).click();
	}
	public void updateDerpartment(String inputDerpartment) {
		driverWeb.findElement(ddDerpartmentList).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driverWeb.findElement(searchDerpartmentList).sendKeys(inputDerpartment);
		String xpathResultDerpartmanetList = String.format("//ul[@id='department_listbox']//li[contains(.,'%s')]", inputDerpartment);
		//driverWeb.findElement(By.xpath(xpathResultDerpartmanetList)).click();
		clickFromElement(By.xpath(xpathResultDerpartmanetList));
	}
	public void updateJobTitle(String inputJobTitle) {
		
	}
	public void updateImage(String inputPathImage) {
		WebElement fileInput=  driverWeb.findElement(btnUploadimage);
		fileInput.sendKeys(inputPathImage);
		WebElement webElement = new WebDriverWait(driverWeb, Duration.ofSeconds(20))
				.until(driver -> driver.findElement(txtlabelUploadSuccessfully));
	}
	public void updateWorkingBranch(String inputWorkingBranch) {
		//driverWeb.findElement(getGenderXpath(inputGender)).click();
	}
	public void updateAddress(String inputAddress) {
		//driverWeb.findElement(getGenderXpath(inputGender)).click();
	}
	public void clickSaveInformationUpdaed(){
		clickFromElement(btnSave);
		//clickFromElement(btnConfirm);
	}
//	public String getActualNickName(){
//		driverWeb.findElement(PageEmployee.txtNameEmployee).click();
//
//
//	}
}
