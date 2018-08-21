package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

	// toda a class do page object você tem que declarar o webdriver driver, ele que
	// navegará entre as páginas e um construtor
	//private WebDriver driver;

	// Dentro da classe do pageObject você tera que adicionar um construtor e tem
	// que receber uma instancia do webdriver

	//public LoginFormPage(WebDriver driver) {
	//	this.driver = driver;
	
	// Após criar a página Base Page, foi refatorado o codigo e não precisa mais fazer manualmente a declaração do Construtor
	
	
	public LoginFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	public LoginFormPage typeLogin(String login) {
		driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		//se retornar a mesma página coloca o return this
		return this;
		
	}
     
	public LoginFormPage typePassword (String password) {
		driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;
		
	}
	
	public SecretPage clickSignin () {
		driver.findElement(By.linkText("SIGN IN")).click();
		//criou-se uma nova pagina, por isso o retorno é new SecretPage 
		return new SecretPage(driver);
		
	}
	
}
