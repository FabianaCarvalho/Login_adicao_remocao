package Suport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	// declarar o Webdriver driver, pq precisamos registrar o momento atual do
	// browser
	public static void takeScreenshot(WebDriver driver, String arquivo) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(arquivo));
		} catch (Exception e) {
			System.out.println("Erro ao coletar a evidencia" + e.getMessage());

		}
	}
}
