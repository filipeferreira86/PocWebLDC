package br.com.gx2.steps;

//Imports JUnit
import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
//Imports Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
//Imports Cucumber
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

//Import Classes
import br.com.gx2.func.PrtSrc;

public class Steps {

	WebDriver driver;
	Scenario cenario;
	WebDriverWait driverEspera;

	@Before
	public void antes(Scenario c) {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/filipe.jesus/Documents/Testes/scripts/jars/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driverEspera = new WebDriverWait(driver, 20);
		this.cenario = c;
	}

	@Dado("^que estou na pagina \"([^\"]*)\"$")
	public void queEstouNaPagina(String site) throws Throwable {
		driver.get(site);
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Quando("^eu informar \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void euInformarNoCampo(String login, String id) throws Throwable {
		WebElement efLogin = driver.findElement(By.id(id));
		efLogin.sendKeys(login);
		cenario.embed(PrtSrc.capturar(driver), "image/png");

	}

	@Quando("^informar \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void informarNoCampo(String senha, String id) throws Throwable {
		WebElement efSenha = driver.findElement(By.id(id));
		efSenha.sendKeys(senha);
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Quando("^cliar no botão \"([^\"]*)\"$")
	public void cliarNoBotão(String name) throws Throwable {
		WebElement btnLogin = driver.findElement(By.name(name));
		btnLogin.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve logar exibindo texto \"([^\"]*)\" no \"([^\"]*)\"$")
	public void deveLogarExibindoTextoNo(String resultado, String id) throws Throwable {
		WebElement lblRes = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		Assert.assertEquals(resultado, lblRes.getText());
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^exibir mensagem de erro \"([^\"]*)\" no \"([^\"]*)\"$")
	public void exibirMensagemDeErroNo(String resultado, String id) throws Throwable {
		WebElement lblRes = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		Assert.assertEquals(resultado, lblRes.getText());
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	// Validar tela de Login:

	@Quando("^eu acessar a pagina \"([^\"]*)\"$")
	public void euAcessarAPagina(String site) throws Throwable {
		driver.get(site);
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve exibir \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void deveExibirNoCampo(String texto, String id) throws Throwable {
		WebElement lblCabecalho = driver.findElement(By.id(id));
		Assert.assertEquals(texto, lblCabecalho.getText());
	}

	@Então("^campo \"([^\"]*)\"$")
	public void campo(String id) throws Throwable {
		WebElement efLogin = driver.findElement(By.id(id));
		Assert.assertTrue("Item não está visivel", efLogin.isDisplayed());
	}

	@Dado("^que seja exibida a mensagem \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void queSejaExibidaAMensagemNoCampo(String texto, String id) throws Throwable {
		WebElement efLogin = driver.findElement(By.id(id));
		if(texto != efLogin.getText()) {
			throw new PendingException("Texto de boas vindas está errado!! Esperado: " + texto + " exibido "+ efLogin.getText());
		}
	}

	@Quando("^eu clicar no menu \"([^\"]*)\"$")
	public void euClicarNoMenu(String id) throws Throwable {
		WebElement mnCadU = driver.findElement(By.id(id));
		mnCadU.click();
	}

	@Então("^deve exibir uma grid \"([^\"]*)\"$")
	public void deveExibirUmaGrid(String grid) throws Throwable {
		WebElement grdUsuario = driverEspera.until(ExpectedConditions.presenceOfElementLocated(By.id(grid)));
		Assert.assertTrue(grdUsuario.isDisplayed());
	}

	@Então("^dentro da grid o \"([^\"]*)\"$")
	public void dentroDaGridO(String user1) throws Throwable {
		WebElement grdUsuario = driverEspera.until(ExpectedConditions.presenceOfElementLocated(By.id(user1)));
		Assert.assertTrue("Item não está visivel", grdUsuario.isDisplayed());
	}

	@Dado("^que estou na tela de \"([^\"]*)\"$")
	public void queEstouNaTelaDe(String id) throws Throwable {
		WebElement mnCadU = driver.findElement(By.id(id));
		mnCadU.click();
	}

	@Então("^deve exibir \"([^\"]*)\" no item da \"([^\"]*)\"$")
	public void deveExibirNoItemDa(String texto, String id) throws Throwable {
		WebElement grItem = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		Assert.assertTrue("Item não está visivel", grItem.isDisplayed());
	}

	@After
	public void depois() {
		driver.close();

	}
}
