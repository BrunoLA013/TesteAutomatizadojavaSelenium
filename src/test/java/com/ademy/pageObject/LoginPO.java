package com.ademy.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnSenha;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(id = "navbar-brand")
    public WebElement navBarMensagem;


    public LoginPO(WebDriver driver) {
        super(driver);
    }


    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto, Keys.TAB);
    }

    public void fazerLogin(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnSenha.click();
    }

    public String obterMensagem() {
        return spanMensagem.getText();
    }

    public String obterMensagemLogado() {
        return navBarMensagem.getText();
    }

    public String obterTituloPagina(){
       return driver.getTitle();
            }
}
