package br.com.chronosAcademy.pages;

import br.com.chronosAcademy.maps.CursoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CursosPage {

    WebDriver driver;
    CursoMap cursoMap;

    public CursosPage(WebDriver driver) {
        this.driver = driver;
        cursoMap = new CursoMap();
        PageFactory.initElements(driver,cursoMap);
    }

    public String getTitulo2() {
        return cursoMap.txtTitulo.getText();
    }
}
