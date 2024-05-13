package com.example.t4td0.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeControllerTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); 
        driver = new FirefoxDriver(options);
    }

    public void testCadastroTarefa() {
        driver.get("http://localhost:8080/tarefas");

        WebElement cadastrar = driver.findElement(By.id("btn-voltar"));
        cadastrar.click();
}
}
