package com.example.t4td0.controller;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MensagemExcluirTest {
    
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testCadastroTarefa() {
        driver.get("http://localhost:8080/tarefas");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       WebElement cadastrar = driver.findElement(By.className("btn-voltar"));
       cadastrar.click();

       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro"));
       caixaDeBusca.click();
       caixaDeBusca.sendKeys("Teste De Cadastrar");

       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro"));
       salvarCadastro.click();

       WebElement voltar = driver.findElement(By.className("btn-voltar"));
       voltar.click();

       /* Excluir Tarefa */
       WebElement excluir = driver.findElement(By.className("btn-excluir"));
       excluir.click();

       WebElement excluirSim = driver.findElement(By.className("btn-sim"));
       excluirSim.click();

       /* Mensagem de Tarefa Exluida com Sucesso */
       WebElement cadastroSucesso = driver.findElement(By.className("mensagem-exclusao"));
       String TarefaCadastroSucess = cadastroSucesso.getText();
       
       if(TarefaCadastroSucess.contains("Tarefa excluída com sucesso!")) {
        System.out.println("Teste de mensagem de exclusao de tarefa realizado com sucesso");
        }else{
         System.out.println("Erro na Pesquisa");
        }

       driver.close();

    }
}
