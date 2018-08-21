package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//toda a class do page object voc� tem que declarar o webdriver driver, ele que navegar� entre as p�ginas e um construtor
	//private WebDriver driver;
	
	//Dentro da classe do pageObject voc� tera que adicionar um construtor e tem que receber uma instancia do webdriver
	
	//public LoginPage(WebDriver driver) {
	//	this.driver = driver;
	
	
	public LoginFormPage clickSignIn () {
		driver.findElement(By.linkText("Sign in")).click();
		//sempre tem que ter o retorno, de outra pagina ou na mesma pagina.
		return new LoginFormPage(driver);
		
		
	}
	
}
