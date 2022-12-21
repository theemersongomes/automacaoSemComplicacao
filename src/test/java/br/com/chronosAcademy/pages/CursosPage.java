package br.com.chronosAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CursosPage {

    WebDriver driver;

    public CursosPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitulo2() {
        String cssTitulo = "div.text-center > div.large-h1";
        WebElement txtTitulo = driver.findElement(By.cssSelector(cssTitulo));
        String titulo = txtTitulo.getText();
        return titulo;
    }
}
