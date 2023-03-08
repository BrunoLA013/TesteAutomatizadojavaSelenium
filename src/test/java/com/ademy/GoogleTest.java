package com.ademy;

import com.ademy.pageObject.GooglePO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest extends BaseTest {

    private static final String PESQUISA_BASE = "Batata frita";
    private static GooglePO googlePO;

    @BeforeAll
    public static void prepararTestes() {
        googlePO = new GooglePO(driver);
    }

    @Test
    public void devePesquisarNoGoogle() {
        googlePO.pesquisar(PESQUISA_BASE);
        String resultado = googlePO.obterResultadoDaPesquisa();
        assertTrue(resultado.contains("Aproximadamente"));
    }
}
