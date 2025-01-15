
package eduit.educacionIT_sel_74162;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PracticaM3 { 
	String url="http://www.automationpractice.pl/index.php/";
	WebDriver driver;
	String urlAuthentication="http://www.automationpractice.pl/index.php?controller=my-account";
	
	@BeforeSuite 
	public void setUP() {
		//Definir que navegador vamos a utilizar
		driver= new EdgeDriver();
	}
	
	@BeforeTest
	public void irUrl() {
		//Abrir la pag
		
		driver.get(url);
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
	}
	
	@Test 
	public void registrarUsuario() {
		WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		WebElement txtEmail=driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo3404"+Math.random()+"@gmail.com");
		
		WebElement btnCreate=driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Hay que agregar una espera de x tiempo o hasta que el atributo aparezca
		
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		//hacer click en el radio button
		
		WebElement radTitulo=driver.findElement(By.id("id_gender1"));
		radTitulo.click();
		
		//Escribir el nombre
		
		WebElement txtNombre=driver.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Arturito");
		
		//Escribir apellido
		WebElement txtApellido=driver.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Diaz");
		
		//Limpiar el valor del correo electronico
		WebElement txtEmailForm=driver.findElement(By.id("email"));
		txtEmailForm.clear();
		
		//Escribir un nuevo valor de correo
		txtEmailForm.sendKeys("correo3404"+Math.random()+"@gmail.com");
	
		//Escribir la contraseña
		WebElement txtPasswordForm=driver.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");
		
		//Seleccionar fecha de nacimiento
		
		Select drpDaysForm=new Select(driver.findElement(By.id("days")));
		drpDaysForm.selectByValue("11");
		
		Select drpMonthsForm=new Select(driver.findElement(By.id("months")));
		drpMonthsForm.selectByValue("4");
		
		Select drpYearForm=new Select(driver.findElement(By.id("years")));
		drpYearForm.selectByValue("1990");
		
		//Hacer click en checkbox
		
		WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		//Hacer click en boton register
		
		WebElement btnRegister=driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		//Ver por consola el contenido de la variable
		System.out.println(urlAuthentication);
		System.out.println(driver.getCurrentUrl());
		
		//Confirmación de la cuenta
		
		Assert.assertEquals(urlAuthentication,driver.getCurrentUrl());
	}
	
	//fin deprueba
	@AfterMethod
	public void CapturarPantalla() throws IOException {
		File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen, new File("..\\educacionIT_sel_74162\\Evidencias\\pantalla_"+System.currentTimeMillis()+".png"));
	}
	@AfterClass
	public void finPrueba() {
		System.out.println("fin de prueba");
		
	}
	
	@AfterTest 
	public void cerrarNavegador() {
		driver.quit();
	}
	
	//Cierre de Suite
	@AfterSuite 
	public void finSuite() {
		System.out.println("fin de suite!");
	}
}
