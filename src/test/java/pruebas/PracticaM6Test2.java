package pruebas;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import páginas.paginaLogin;

public class PracticaM6Test2 {
	
	public class PracticaM6 {
		
			String url="https://demo.guru99.com/test/upload/";

			WebDriver driver; 
			paginaLogin login;

			@BeforeMethod
			public void setUP() {
				WebDriverManager.chromedriver().setup();
				
				driver=new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
			}
			
			@Test
			public void cargarArchivo() {
				
				WebElement rutaArchivo=driver.findElement(By.id("uploadfile_0"));
				rutaArchivo.sendKeys("C:\\Users\\agost\\eclipse-workspace\\educacionIT_sel_74162\\prueba.txt");
				
			}
		
			

		
			@AfterMethod 
			public void tearDown() {
			driver.quit();
		} 
	}

}
