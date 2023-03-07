package com.ademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement resultado;

    public GooglePO(WebDriver driver) {
        super(driver);
    }

    public GooglePO() {
        super(null);
    }

    public void pesquisar(String texto) {
        try {
            inputPesquisa.sendKeys(texto + Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar: " + e.getMessage());
        }
    }

    public String obterResultadoDaPesquisa(){
        return resultado.getText();
    }

    // WebElement inputPesquisa = driver.findElement(By.name("q"));
}
