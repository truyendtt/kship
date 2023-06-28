package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page {
	
			protected WebDriver driverWeb;
			public Page (WebDriver dr) {
				super();
				this.driverWeb = dr;
			}
			public void selectElementFromDropdown(By element, String textInput) {
				Select selectOption = new Select(driverWeb.findElement(element));
				selectOption.selectByVisibleText(textInput);
			}
			public String cutString(String st) {
				String A[] = st.split(":");
				String result= A[1];
				return result;
			}
			
			public void clickFromElement(By element) {
				WebElement webElement = new WebDriverWait(driverWeb, Duration.ofSeconds(20))
				          .until(driver -> driver.findElement(element));

				JavascriptExecutor executor = (JavascriptExecutor)driverWeb;
				executor.executeScript("arguments[0].click();", webElement);
			}
}
