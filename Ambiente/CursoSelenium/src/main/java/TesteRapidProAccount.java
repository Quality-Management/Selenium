import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRapidProAccount {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(800, 600));
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void teste() {
		driver.get("https://rapidpro.ilhasoft.dev");
		Assert.assertEquals("Rapidpro - Visually build interactive SMS Applications", driver.getTitle());
		driver.findElement(By.linkText("sign in")).click();
		driver.findElement(By.id("id_username")).sendKeys("account");
		driver.findElement(By.id("id_password")).sendKeys("pwd");
		driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
		Assert.assertEquals("Error", driver.findElement(By.cssSelector("h3:nth-child(1)")).getText());
	}	
}