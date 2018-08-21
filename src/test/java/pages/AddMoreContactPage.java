package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddMoreContactPage extends BasePage {

	

	public AddMoreContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public AddMoreContactPage escolherTipoDeContato(String tipo) {
		WebElement campoType = driver.findElement(By.id("addmoredata")).findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		return this;
	}
	
	public AddMoreContactPage digitarContato(String contato) {
		driver.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);
		
		return this;
	}
	
	public MePage clicarSalvar() {
		//irá mudar de página
		
		driver.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
		return new MePage(driver);
	}
	
	public MePage adicionarContato(String tipo, String contato) {
		//toda vez que mudar de pagina tem que colocar um "new" + a pagina direcionada + o driver
		//adicionando todos os metodos acima
		escolherTipoDeContato(tipo);
		digitarContato(contato);
		clicarSalvar();		
		
		return new MePage(driver);
	}
}
