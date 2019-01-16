package br.com.gx2.steps;

//Imports JUnit
import org.junit.Assert;
//Imports Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Import Classes
import br.com.gx2.func.PrtSrc;
//Imports Cucumber
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

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
		Thread.sleep(1000);
		WebElement efLogin = driverEspera.until(ExpectedConditions.elementToBeClickable((By.id(id))));
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
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertEquals(texto, lblCabecalho.getText());
	}

	@Então("^campo \"([^\"]*)\"$")
	public void campo(String id) throws Throwable {
		WebElement efLogin = driver.findElement(By.id(id));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue("Item não está visivel", efLogin.isDisplayed());
	}

	@Dado("^que seja exibida a mensagem \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void queSejaExibidaAMensagemNoCampo(String texto, String id) throws Throwable {
	}

	@Quando("^eu clicar no menu \"([^\"]*)\"$")
	public void euClicarNoMenu(String linkText) throws Throwable {
		WebElement mnCadU = driverEspera.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText)));
		Thread.sleep(1000);
		mnCadU.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve exibir uma grid \"([^\"]*)\"$")
	public void deveExibirUmaGrid(String grid) throws Throwable {
		WebElement grdUsuario = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(grid)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue(grdUsuario.isDisplayed());
	}

	@Então("^dentro da \"([^\"]*)\" o \"([^\"]*)\"$")
	public void dentroDaO(String id, String user1) throws Throwable {
		WebElement grdUsuario = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue("Item não está visivel", grdUsuario.getText().contains(user1));
	}

	@Dado("^que estou na tela de \"([^\"]*)\"$")
	public void queEstouNaTelaDe(String linkText) throws Throwable {
		WebElement mnCadU = driverEspera.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText)));
		Thread.sleep(1000);
		mnCadU.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve exibir \"([^\"]*)\" no item da \"([^\"]*)\"$")
	public void deveExibirNoItemDa(String texto, String id) throws Throwable {
		WebElement grItem = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue("Item não está visivel", grItem.isDisplayed());
	}

	@Então("^não deve exibir \"([^\"]*)\" no item da \"([^\"]*)\"$")
	public void nãoDeveExibirNoItemDa(String arg1, String id) throws Throwable {
		Thread.sleep(1000);
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue(driver.findElements(By.id(id)).size() < 1);
	}

//	manutenção:

	@Dado("^que estou na tela de cadastro usuário$")
	public void queEstouNaTelaDeCadastroUsuário() throws Throwable {
	}

	@Quando("^eu clicar no \"([^\"]*)\"$")
	public void euClicarNo(String id) throws Throwable {
		WebElement btnAprovUsuario = driverEspera.until(ExpectedConditions.elementToBeClickable((By.id(id))));
		Thread.sleep(1000);
		btnAprovUsuario.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve exibir texto \"([^\"]*)\" no label \"([^\"]*)\"$")
	public void deveExibirTextoNoLabel(String text, String xpath) throws Throwable {
		WebElement lblTexto = driverEspera.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath))));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertEquals(text, lblTexto.getText());
	}

	@Dado("^que estou no formulario de \"([^\"]*)\"$")
	public void queEstouNoFormularioDe(String id) throws Throwable {
		Thread.sleep(1000);
		WebElement btnInsert = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		btnInsert.click();
	}

	@Quando("^limpar campo \"([^\"]*)\"$")
	public void limparCampo(String id) throws Throwable {
		WebElement efLimpar = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		efLimpar.clear();
		efLimpar.sendKeys(Keys.TAB);
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Quando("^clicar no botão \"([^\"]*)\"$")
	public void clicarNoBotão(String id) throws Throwable {
		WebElement btnConfirmar = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		Thread.sleep(1000);
		btnConfirmar.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve exibir mensagem \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void deveExibirMensagemNoCampo(String msg, String id) throws Throwable {
		WebElement blnAlerta = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertEquals(msg, blnAlerta.getText());
	}

	@Então("^deve exibir um comboBox \"([^\"]*)\"$")
	public void deveExibirUmComboBox(String id) throws Throwable {
		WebElement cmbAtivo = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cmbAtivo.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue(cmbAtivo.getText().contains("Sim"));
	}
	
	@Quando("^clicar no comboBox \"([^\"]*)\"$")
	public void clicarNoComboBox(String id) throws Throwable {
		WebElement cmbAtivo = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cmbAtivo.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue(cmbAtivo.getText().contains("Sim"));
		
	}

	@Quando("^clicar no item \"([^\"]*)\"$")
	public void clicarNoItem(String xpath) throws Throwable {
		WebElement itItem = driverEspera.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		itItem.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^não deve exibir na grid \"([^\"]*)\" itens com itens \"([^\"]*)\" ativos$")
	public void nãoDeveExibirNaGridItensComItensAtivos(String id, String item) throws Throwable {
		Thread.sleep(1000);
		WebElement grdUsuarios = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		cenario.embed(PrtSrc.capturar(driver), "image/png");
		Assert.assertTrue(!grdUsuarios.getText().contains(item));
	}


	@After
	public void depois() {
		driver.close();

	}
}
