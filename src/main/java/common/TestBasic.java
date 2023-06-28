package common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBasic {
	public WebDriver driver;
	public  static final String FILE_CONFIG="\\config\\ProjectConfiguration.properties";
	public void openWebsite(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.gecko",
					readConfigValueByKey("gecko_driver"));
			driver = new FirefoxDriver();
			System.out.print("firefoxff" + driver);
		} else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					readConfigValueByKey("chrome_dirver"));
			driver = new ChromeDriver();
		}
		
		driver.get(readConfigValueByKey("url"));
		driver.manage().window().maximize();
	}
	public String readConfigValueByKey(String Key) {
		String resultValue = "";
		Properties properties = new Properties();
		InputStream inputStream=null;
		String currentDir= System.getProperty("user.dir");
		try {
			inputStream = new FileInputStream(currentDir + FILE_CONFIG);
			properties.load(inputStream);
			resultValue = properties.getProperty(Key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultValue;
	}

//	public void openWebsite(String url) {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\truyendtt\\Documents\\GitHub\\SeleniumWithMaven_v2\\DemoQA\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get(url);
//		driver.manage().window().maximize();
//
//	}
	
	public void closeBrowser() {
		driver.quit();// close toàn bộ cửa sổ
	}
	public void ScrollWindow(By element) {
		
//		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement iframe= driver.findElement(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframe);	
//		js.executeScript("arguments[0].scrollIntoView(true);", iframe);
	}
	public void setWidown () {
		Dimension dm= new Dimension(700,1000);
		driver.manage().window().setSize(dm);
	}

	public By getLocatorString(String locatorType, String locatorValue) {
		By result = null;

		return result;

	}
	public ArrayList<String> getColumnValuesList(By columnLocator){
		   ArrayList<String> columnValuesList = new ArrayList();
		   
		   List<WebElement> columnElements =  driver.findElements(columnLocator);
		   
		   for (WebElement e : columnElements){//for each => chỉ áp dụng cho danh sách
		    String columnValue = e.getText();
		    columnValuesList.add(columnValue);
		   }
		   return columnValuesList;
		    
	}

}
