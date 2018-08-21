package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

	
	public MePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public MePage clickMoreDataAboutYou() {
		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		return this;
	}
	
	public AddMoreContactPage clickButtonAddMoreData() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[4]/div[2]/button")).click();
		return new AddMoreContactPage(driver);
		
	}

}
