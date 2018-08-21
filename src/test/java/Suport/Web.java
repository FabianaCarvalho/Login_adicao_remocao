package Suport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver createChrome() {
	//Abrindo o browser	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

	driver.get("http://www.juliodelima.com.br/taskit/");
	return driver;
	}
}
