package br.com.gx2.steps;

//Imports JUnit
import org.junit.Assert;

//Imports Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void cliarNoBotão(String id) throws Throwable {
		WebElement btnLogin = driver.findElement(By.id(id));
		btnLogin.click();
		cenario.embed(PrtSrc.capturar(driver), "image/png");
	}

	@Então("^deve logar exibindo texto \"([^\"]*)\" no \"([^\"]*)\"$")
	public void deveLogarExibindoTextoNo(String resultado, String id) throws Throwable {
		WebElement lblRes = driverEspera.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		Assert.assertEquals(resultado, lblRes.getText());
	}

	@After
	public void depois() {
		driver.close();

	}
}
