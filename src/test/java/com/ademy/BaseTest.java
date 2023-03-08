package com.ademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String URL_BASE = "https://www.google.com.br";

    @BeforeAll
    public static void iniciar() {
        System.out.println("Iniciando os testes...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
        System.out.println("URL base: " + URL_BASE);
    }

    @AfterAll
    public static void finalizar() {
        System.out.println("Finalizando os testes...");
        driver.quit();
    }
}
