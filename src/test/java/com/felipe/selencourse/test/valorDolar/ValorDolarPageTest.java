package com.felipe.selencourse.test.valorDolar;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.felipe.selencourse.test.context.TestContext;
/**
 * Testing
 * @author Niemand
 *
 */
public class ValorDolarPageTest extends TestContext {

	private static ChromeDriverService service;

	private WebDriver driver;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		
		//Create a new instance by using chromeDriver.exe
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("D:/Software/ChromeDriver/chromedriver.exe")).usingAnyFreePort()
				.build();
		service.start();
	}
	
	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	/**
	 * Example N1
	 * Ejemplo N1
	 * @throws InterruptedException
	 */
	@Test
	public void test01() throws InterruptedException {

		driver.get("http://www.wikipedia.org");

		WebElement link;

		link = driver.findElement(By.id("js-link-box-en"));

		link.click();

		// 5 seconds -- needs throws Exeption
		Thread.sleep(5000);

		WebElement searchBox;

		searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("Software");

		Thread.sleep(5000);

		driver.quit();

	}

	@Test
	public void test02() throws InterruptedException {
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("webdriver");
		Thread.sleep(10000);
		searchBox.submit();
		// driver.quit();
		//WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return $('.cheese')[0]");

		Assert.assertEquals("Google", driver.getTitle());

	}
	
	@Test
	public void test03() throws InterruptedException {
		driver.get("http://www.valor-dolar.cl");
		WebElement searchBox = driver.findElement(By.id("to_CLP"));
		
		Thread.sleep(5000);
		// driver.quit();
		
		Assert.assertEquals("Valor del Dolar en Chile | Tipo de Cambio actualizado", driver.getTitle());
		Assert.assertEquals("653,32", searchBox.getText());

	}
}
