package Tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Suport.Web;
import pages.LoginPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfoUserPageObjectsTest.csv")

public class InfoUserPageObjectsTest {
//criar uma variavel do tipo Webdriver
	private WebDriver driver;

	@Before
	public void setup() {
		//driver recebe chromeDriver
		driver = Web.createChrome();
	}
	
	@Test
	public void testAdicionarInformacaoAoUsuario(
			@Param(name="login")String login,
			@Param(name="password")String password,
			@Param(name="tipo")String tipo,
			@Param(name="contato")String contato,
			@Param(name="mensagem")String mensagemEsperada
			) {
	// para fazer as chamadas das paginas criadas
	// Precisou ser adicionado a String textToast para dar suporte ao metodo .capturarTextoToast, utilizando o Assert
	String textToast =	new LoginPage(driver)
              .clickSignIn()
              .typeLogin(login)
              .typePassword(password)
              .clickSignin()
              .clickLogin()
              .clickMoreDataAboutYou()
              .clickButtonAddMoreData()
              //esse adicionar contato é uma junção de dois campos, tipo e contato; Tem duas formas de serem feitas, junto ou separados.
              .adicionarContato(tipo, contato)
              //.escolherTipoDeContato("Phone")
              //.digitarContato("1190908088")
              .capturarTextoToast();
           
	 
	assertEquals(mensagemEsperada, textToast);
	}
			
	
	
	@After
	public void tearDown() {
		//driver.close();
	}

}
