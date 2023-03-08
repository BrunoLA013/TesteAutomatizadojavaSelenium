package com.ademy;

import com.ademy.pageObject.LoginPO;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseLoginTest {

    private static final String SENHA_VAZIA = "";
    private static final String EMAIL_VAZIO = "";
    private static final String SENHA_ERRADA = "1234165";
    private static final String EMAIL_ERRADO = "Aadmin@admin.com";

    private static final String SENHA_CERTA = "admin@123";
    private static final String EMAIL_CERTO = "admin@admin.com";
    private static LoginPO loginPO;


    @BeforeAll
    public static void configurarTestes() {
        loginPO = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveTerAcessoSemLoginESenha() {

        loginPO.fazerLogin(EMAIL_VAZIO, SENHA_VAZIA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC002_naoDeveTerAcessoSomenteComEmailErrado() {
        loginPO.fazerLogin(EMAIL_ERRADO, SENHA_VAZIA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC003_naoDeveTerAcessoSomenteComSenhaErrada() {
        loginPO.fazerLogin(EMAIL_VAZIO, SENHA_ERRADA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC004_naoDeveTerAcessoComLoginESenhaErrados() {
        loginPO.fazerLogin(EMAIL_ERRADO, SENHA_ERRADA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC005_naoDeveTerAcessoComLoginCertoESenhaErrada() {
        loginPO.fazerLogin(EMAIL_CERTO, SENHA_ERRADA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC006_naoDeveTerAcessoComLoginErradoESenhaCerta() {
        loginPO.fazerLogin(EMAIL_ERRADO, SENHA_CERTA);
        String mensagem = loginPO.obterMensagem();
        assertTrue(mensagem.contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC007_deveTerAcessoComLoginESenhaCorretos() {
        loginPO.fazerLogin(EMAIL_CERTO, SENHA_CERTA);
        loginPO.obterTituloPagina();
        assertEquals(loginPO.obterTituloPagina(), "Controle de Produtos");
    }

}
