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

public class MensagemEdicaoTest {

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

       /* Cadastrar Tarefa */
       WebElement cadastrar = driver.findElement(By.className("btn-voltar"));
        cadastrar.click();
 
       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro"));
        caixaDeBusca.click();
        caixaDeBusca.sendKeys("Teste De Cadastrar");
 
       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro"));
        salvarCadastro.click();
 
       WebElement voltar = driver.findElement(By.className("btn-voltar"));
        voltar.click();

        /* Editar Tarefa */
       WebElement editar = driver.findElement(By.className("btn-editar"));
       editar.click();

       WebElement caixaDeBuscaEditar = driver.findElement(By.id("novo-titulo"));
       caixaDeBuscaEditar.click();
       caixaDeBuscaEditar.sendKeys(" Editado");

       WebElement salvarCadastroEditar = driver.findElement(By.id("salvarEdit"));
       salvarCadastroEditar.click();

       /* Tarefa Editada com Sucesso */
       WebElement editarSucess = driver.findElement(By.id("mensagemEditSucess"));
       String mensagemEditSucess = editarSucess.getText();
       
       if(mensagemEditSucess.contains("Tarefa editada com sucesso!")) {
        System.out.println("Teste de mensagem de tarefa editada realizado com sucesso");
        }else{
         System.out.println("Erro na Pesquisa");
        }

         /* Excluir Tarefa */
         WebElement voltarList = driver.findElement(By.className("btn-voltar"));
         voltarList.click();

         WebElement excluir = driver.findElement(By.className("btn-excluir"));
         excluir.click();
  
         WebElement excluirSim = driver.findElement(By.className("btn-sim"));
         excluirSim.click();

        driver.close();

    }


}
