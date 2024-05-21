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

    private static WebDriver driver; // variavel driver do tipo WebDriver

    @BeforeAll // Executar o método abaixo antes de todos os testes
    public static void setUp() { // Configuração
        WebDriverManager.firefoxdriver().setup(); // Configura o driver do Firefox
        FirefoxOptions options = new FirefoxOptions(); // Opções do Firefox
        driver = new FirefoxDriver(options); // Inicializa o driver com o Firefox 
    }

    @SuppressWarnings("deprecation")
    @Test // Metodo Teste
    public void testMensagemEdicaoTarefa() { // Teste para cadastro de tarefa
        driver.get("http://localhost:8080/tarefas"); // Abrir a pagina de lista de tarefas

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Tempo de espera de 10 segundos para inicializar

       WebElement cadastrar = driver.findElement(By.className("btn-voltar")); // Encontrar o botao de cadastrar tarefa
       cadastrar.click(); // Clicar no botao

       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro")); // Encontra a caixa de texto 
       caixaDeBusca.click(); // Clica na caixa de texto
        caixaDeBusca.sendKeys("Teste De Cadastrar"); // Digite o texto
 
       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro")); // Encontra o botao de salvar cadastro
        salvarCadastro.click(); // Clica no botao
 
       WebElement voltar = driver.findElement(By.className("btn-voltar")); // Encontra o botao de voltar
        voltar.click(); // Clica no botao

        /* Editar Tarefa */
       WebElement editar = driver.findElement(By.className("btn-editar")); // Encontra o botao de editar
       editar.click(); // Clica no botao

       WebElement caixaDeBuscaEditar = driver.findElement(By.id("novo-titulo")); // Encontra a caixa de texto 
       caixaDeBuscaEditar.click(); // Clica no botao
       caixaDeBuscaEditar.sendKeys(" Editado"); // Digite o texto

       WebElement salvarCadastroEditar = driver.findElement(By.id("salvarEdit")); // Encontra o botao de salvar ediçao
       salvarCadastroEditar.click(); // Clica no botao

       /* Tarefa Editada com Sucesso */
       WebElement editarSucess = driver.findElement(By.id("mensagemEditSucess"));  // Encontra o campo de mensagem de tarefa editada com sucesso
       String mensagemEditSucess = editarSucess.getText(); // Recebe o texto 
       
       if(mensagemEditSucess.contains("Tarefa editada com sucesso!")) { // Se no texto contem "Tarefa editada com sucesso!"
        System.out.println("Teste de mensagem de tarefa editada realizado com sucesso"); // Aparece essa mensagem
        }else{
         System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
        }

         /* Excluir Tarefa */
         WebElement voltarList = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
         voltarList.click(); // Clica no botao

         WebElement excluir = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
         excluir.click(); // Clica no botao
  
         WebElement excluirSim = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
         excluirSim.click(); // Clica no botao

        driver.close(); // Fechar navegador

    }


}
