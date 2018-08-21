package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	// Essa pagina ficara armazenada todas as ações em comum: ex.: construtor, etc
	// protected é um modificador do Webdriver
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String capturarTextoToast() {
		return driver.findElement(By.id("toast-container")).getText();
		// Existem duas formas para fazer, uma em duas linhas ou juntando em uma linha
		// reduzida conforme a linha acima
		// WebElement mensagemPopUp = driver.findElement(By.id("toast-container"));
		// return mensagemPopUp.getText();

	}
}
