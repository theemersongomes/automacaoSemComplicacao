package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.pages.CursosPage;
import br.com.chronosAcademy.pages.PrincipalPage;
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
    PrincipalPage principalPage;
    CursosPage cursosPage;

    @Before
    public void InicializaTeste() {
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }
    @Test
    public void primeiroTeste(){
            assertEquals("Porque Tempo É Conhecimento",principalPage.getTitulo());
    }

    @Test
    public void segundoTeste(){
        cursosPage = new CursosPage(driver);
        principalPage.clickBotao();
        assertEquals("Conheça todos os nossos cursos",cursosPage.getTitulo2());
    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }

}
