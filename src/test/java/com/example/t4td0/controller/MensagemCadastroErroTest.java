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

public class MensagemCadastroErroTest {

    private static WebDriver driver; // variavel driver do tipo WebDriver

    @BeforeAll // Executar o método abaixo antes de todos os testes
    public static void setUp() { // Configuração
        WebDriverManager.firefoxdriver().setup(); // Configura o driver do Firefox
        FirefoxOptions options = new FirefoxOptions(); // Opções do Firefox
        driver = new FirefoxDriver(options); // Inicializa o driver com o Firefox 
    }

    @SuppressWarnings("deprecation")
    @Test // Metodo Teste
    public void testMensagemCadastroErroTarefa() { // Teste para cadastro de tarefa
        driver.get("http://localhost:8080/tarefas"); // Abrir a pagina de lista de tarefas

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Tempo de espera de 10 segundos para inicializar

       WebElement cadastrar = driver.findElement(By.className("btn-voltar")); // Encontrar o botao de cadastrar tarefa
       cadastrar.click(); // Clicar no botao

       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro")); // Encontra a caixa de texto 
       caixaDeBusca.click(); // Clica na caixa de texto
       caixaDeBusca.sendKeys("");

       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro")); // Encontra o salvar cadastro
       salvarCadastro.click(); // Clica no botao

       /* Mensagem de Erro de Cadastrado com Sucesso */
       WebElement cadastroSucess = driver.findElement(By.id("mensagemErro")); // Encontra o campo de mensagem de erro
       String mensagemCadastroSucess = cadastroSucess.getText(); // Recebe o texto 
       
       if(mensagemCadastroSucess.contains("Título é obrigatório")) { // Se no texto contem "Título é obrigatório"
       System.out.println("Teste de Mensagem de Erro de cadastro de tarefa realizado com sucesso"); // Aparece essa mensagem
       }else{
        System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
       }

       WebElement caixaDeBuscaNov = driver.findElement(By.id("titulo-cadastro"));  // Encontra a caixa de texto 
       caixaDeBuscaNov.click(); // Clica no botao
       caixaDeBuscaNov.sendKeys("Teste De Cadastrar"); // Digite o texto

       WebElement salvarCadastroNov = driver.findElement(By.id("salvarCadastro")); // Encontra o botao de salvar cadastro
       salvarCadastroNov.click(); // Clica no botao

       WebElement voltarList = driver.findElement(By.className("btn-voltar")); // Encontra o botao de voltar
       voltarList.click(); // Clica no botao 

       /* Excluir Tarefa */

       WebElement excluir = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
       excluir.click(); // Clica no botao

       WebElement excluirSim = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
       excluirSim.click(); // Clica no botao 

       driver.close(); // Fechar navegador

    }
}


