package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

	// toda a class do page object voc� tem que declarar o webdriver driver, ele que
	// navegar� entre as p�ginas e um construtor
	//private WebDriver driver;

	// Dentro da classe do pageObject voc� tera que adicionar um construtor e tem
	// que receber uma instancia do webdriver

	//public LoginFormPage(WebDriver driver) {
	//	this.driver = driver;
	
	// Ap�s criar a p�gina Base Page, foi refatorado o codigo e n�o precisa mais fazer manualmente a declara��o do Construtor
	
	
	public LoginFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	public LoginFormPage typeLogin(String login) {
		driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		//se retornar a mesma p�gina coloca o return this
		return this;
		
	}
     
	public LoginFormPage typePassword (String password) {
		driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;
		
	}
	
	public SecretPage clickSignin () {
		driver.findElement(By.linkText("SIGN IN")).click();
		//criou-se uma nova pagina, por isso o retorno � new SecretPage 
		return new SecretPage(driver);
		
	}
	
}
