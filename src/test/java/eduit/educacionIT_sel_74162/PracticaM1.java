package eduit.educacionIT_sel_74162;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;




public class PracticaM1 {

	//Variables que necesitaremos en la prueba
	String url="http://www.automationpractice.pl/index.php/";
			
	@Test 
	public void lab1_test() {
		System.out.println("HOLA MUNDO DE AUTOMATIZACION");
	};


	@Test
	public void buscarProductoEdge() {
	//Paso 1 : definir navegador
	WebDriver navegador = new EdgeDriver();
	navegador.manage().deleteAllCookies();
	//Maximiza la ventana
	
	navegador.manage().window().maximize();
	
	//Paso 2: Abrir la página a testear 
	navegador.get(url);
	
	//Paso 3: Escribir palabra a buscar
	WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
	txtBusqueda.sendKeys("Blouse");
	
	//Simular que presionamos el enter
	txtBusqueda.sendKeys(Keys.ENTER);
	
	//Paso 4: Cierra el navegador
	navegador.quit();
	}






	
}