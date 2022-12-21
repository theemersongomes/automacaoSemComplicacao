package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.chrono.ChronoLocalDate;

public class TesteWeb {

    WebDriver driver;
    Driver driverWeb;

    @Before
    public void InicializaTeste() {
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
    }
    @Test
    public void primeiroTeste(){
        String xpathTitulo = "//section[2]//h4";
         //section[2]/div[3]/div/div/div/div/div[1]/div/h4
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        assertEquals("Porque Tempo � Conhecimento",titulo);

    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }

}
