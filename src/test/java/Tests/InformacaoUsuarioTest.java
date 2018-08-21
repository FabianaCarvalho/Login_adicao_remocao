package Tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Suport.Generator;
import Suport.Screenshot;
import Suport.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacaoUsuarioTest.csv")

public class InformacaoUsuarioTest {
	// Declarando para todos os metodos estarem utilizando
	private WebDriver driver;

	@Before
	public void setUp() {
		// faz a chamada da classe WEB
		driver = Web.createChrome();

		driver.findElement(By.linkText("Sign in")).click();

		WebElement formSignInBox = driver.findElement(By.id("signinbox"));

		formSignInBox.findElement(By.name("login")).sendKeys("Fabiana");
		formSignInBox.findElement(By.name("password")).sendKeys("123456");
		formSignInBox.findElement(By.linkText("SIGN IN")).click();

		driver.findElement(By.className("me")).click();
		// sempre seleciona o que esta sendo exibido
		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	@Test

	// incluir os parametros do arquivo.CSV dentro do método
	public void testAdicionarInformacaoAoUsuario(@Param(name = "tipo") String tipo,
			@Param(name = "contato") String contato, @Param(name = "mensagem") String mensagemEsperada) {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[4]/div[2]/button")).click();

		// Verificando campo dentro do pop-up WebElement popUpAddMoreData =
		WebElement popUpAddMoreData = driver.findElement(By.id("addmoredata"));

		// Combo + Select WebElement campoType =
		WebElement campoType = popUpAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		popUpAddMoreData.findElement(By.name("contact")).sendKeys(contato);
		popUpAddMoreData.findElement(By.linkText("SAVE")).click();

		// Validando a mensagem de alerta WebElement mensagemPopUp =
		WebElement mensagemPopUp = driver.findElement(By.id("toast-container"));
		String mensagem = mensagemPopUp.getText();
		assertEquals(mensagemEsperada, mensagem);

	}

	// @Test

	public void removerContato() {

		driver.findElement(By.xpath("//span[text()=\"1198807070\"]/following-sibling::a")).click();

		// acessando a janela javascript (popUp) no caso para confirmar a exclusao

		driver.switchTo().alert().accept();

		WebElement mensagemPopUp = driver.findElement(By.id("toast-container"));
		String mensagem = mensagemPopUp.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);

		// Fazendo a chamada do metodo takeScreenshot, na classe Screenhshot e
		// registrarDataHora na class Generator
		Screenshot.takeScreenshot(driver, "C:\\Users\\HP\\Desktop\\EvidenciasScreenshot\\EvidenciaExclusaoContato"
				+ Generator.registrarDataHora() + "removerContato.png");

		// espera explicita
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// stalenessOf significa que espera até o elemento desapaceça do DOM.
		wait.until(ExpectedConditions.stalenessOf(mensagemPopUp));
		driver.findElement(By.linkText("Logout")).click();

	}

	@After
	public void tearDown() {
		driver.close();

	}

	// WebElement me = driver.findElement(By.className("me"));
	// String identifyName = me.getText();
	// assertEquals("Hi, Fabiana", identifyName);
}
