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

public class ListaTest {
    
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

        /* 1° Teste */
       WebElement cadastrar = driver.findElement(By.className("btn-voltar"));
       cadastrar.click();

       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro"));
       caixaDeBusca.click();
       caixaDeBusca.sendKeys("Teste De Cadastrar");

       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro"));
       salvarCadastro.click();

       WebElement voltar = driver.findElement(By.className("btn-voltar"));
       voltar.click();

        /* Tarefa Cadastrada com Sucesso */
        WebElement cadastroSucesso = driver.findElement(By.className("tarefa-nome"));
        String TarefaCadastroSucess = cadastroSucesso.getText();
        
        if(TarefaCadastroSucess.contains("Teste De Cadastrar")) {
         System.out.println("1° Teste de listar tarefa realizado com sucesso");
         }else{
          System.out.println("Erro na Pesquisa");
         }

         /* Excluir Tarefa */
        WebElement excluir = driver.findElement(By.className("btn-excluir"));
        excluir.click();
 
        WebElement excluirSim = driver.findElement(By.className("btn-sim"));
        excluirSim.click();

       /* 2° Teste */

       WebElement cadastrar2 = driver.findElement(By.className("btn-voltar"));
       cadastrar2.click();

       WebElement caixaDeBusca2 = driver.findElement(By.id("titulo-cadastro"));
       caixaDeBusca2.click();
       caixaDeBusca2.sendKeys("Teste De Cadastrar 2");

       WebElement salvarCadastro2 = driver.findElement(By.id("salvarCadastro"));
       salvarCadastro2.click();

       WebElement voltar2 = driver.findElement(By.className("btn-voltar"));
       voltar2.click();

       /* Tarefa Cadastrada com Sucesso 2 */
       WebElement cadastroSucesso2 = driver.findElement(By.className("tarefa-nome"));
       String TarefaCadastroSucess2 = cadastroSucesso2.getText();
       
       if(TarefaCadastroSucess2.contains("Teste De Cadastrar 2")) {
        System.out.println("2° Teste de listar tarefa realizado com sucesso");
        }else{
         System.out.println("Erro na Pesquisa");
        }


        /* Excluir Tarefa */

       WebElement excluir2 = driver.findElement(By.className("btn-excluir"));
       excluir2.click();

       WebElement excluirSim2 = driver.findElement(By.className("btn-sim"));
       excluirSim2.click();

         /* 3° Teste */
       WebElement cadastrar3 = driver.findElement(By.className("btn-voltar"));
       cadastrar3.click();

       WebElement caixaDeBusca3 = driver.findElement(By.id("titulo-cadastro"));
       caixaDeBusca3.click();
       caixaDeBusca3.sendKeys("Teste De Cadastrar 3");

       WebElement salvarCadastro3 = driver.findElement(By.id("salvarCadastro"));
       salvarCadastro3.click();

       WebElement voltar3 = driver.findElement(By.className("btn-voltar"));
       voltar3.click();

        /* Tarefa Cadastrada com Sucesso 3 */
       WebElement cadastroSucesso3 = driver.findElement(By.className("tarefa-nome"));
       String TarefaCadastroSucess3 = cadastroSucesso3.getText();
       
       if(TarefaCadastroSucess3.contains("Teste De Cadastrar 3")) {
        System.out.println("3° Teste de listar tarefa realizado com sucesso");
        }else{
         System.out.println("Erro na Pesquisa");
        }

        /* Excluir Tarefa */

       WebElement excluir3 = driver.findElement(By.className("btn-excluir"));
       excluir3.click();

       WebElement excluirSim3 = driver.findElement(By.className("btn-sim"));
       excluirSim3.click();

       driver.close();
      
    }
}
