package br.com.gx2.func;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class PrtSrc {

	public static byte[] capturar(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			
		return source;
	}

}
