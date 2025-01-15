package eduit.educacionIT_sel_74162;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class PracticaM2 {

	String url="http://www.automationpractice.pl/index.php/";
	
	@Test
	public void registrarUsuario() {
		
		WebDriver navegador = new EdgeDriver();
		navegador.manage().deleteAllCookies();
		//Maximiza la ventana
		
		navegador.manage().window().maximize();
		
		navegador.get(url);
		
		WebElement lnkSign=navegador.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		WebElement txtEmail=navegador.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo3404"+Math.random()+"@gmail.com");
		
		WebElement btnCreate=navegador.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Hay que agregar una espera de x tiempo o hasta que el atributo aparezca
		
		WebDriverWait espera=new WebDriverWait(navegador,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		//hacer click en el radio button
		
		WebElement radTitulo=navegador.findElement(By.id("id_gender1"));
		radTitulo.click();
		
		//Escribir el nombre
		
		WebElement txtNombre=navegador.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Arturito");
		
		//Escribir apellido
		WebElement txtApellido=navegador.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Diaz");
		
		//Limpiar el valor del correo electronico
		WebElement txtEmailForm=navegador.findElement(By.id("email"));
		txtEmailForm.clear();
		
		//Escribir un nuevo valor de correo
		txtEmailForm.sendKeys("correo3404"+Math.random()+"@gmail.com");
	
		//Escribir la contraseña
		WebElement txtPasswordForm=navegador.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");
		
		//Seleccionar fecha de nacimiento
		
		Select drpDaysForm=new Select(navegador.findElement(By.id("days")));
		drpDaysForm.selectByValue("11");
		
		Select drpMonthsForm=new Select(navegador.findElement(By.id("months")));
		drpMonthsForm.selectByValue("4");
		
		Select drpYearForm=new Select(navegador.findElement(By.id("years")));
		drpYearForm.selectByValue("1990");
		
		//Hacer click en checkbox
		
		WebElement chkNewsletter=navegador.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		//Hacer click en boton register
		
		WebElement btnRegister=navegador.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		
		
		
		
		
	}
	
}
