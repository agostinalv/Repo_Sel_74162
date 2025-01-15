package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

		WebDriver driver=null;
		String url="http://www.automationpractice.pl/index.php/";
		
		@BeforeMethod
		@Parameters("navegador")
		public void setUP(String navegador) {
			
			if(navegador.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver();
			}
			
			else {
				driver= new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(url);
			
		}
		
		@Test
		public void buscarPalabra() {
			
		}
		
		@AfterMethod
		public void cierreNavegador() {
			driver.quit();
		}
		
}
