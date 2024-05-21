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

public class VisualizarTest {
    
    private static WebDriver driver; // variavel driver do tipo WebDriver

    @BeforeAll // Executar o método abaixo antes de todos os testes
    public static void setUp() { // Configuração
        WebDriverManager.firefoxdriver().setup(); // Configura o driver do Firefox
        FirefoxOptions options = new FirefoxOptions(); // Opções do Firefox
        driver = new FirefoxDriver(options); // Inicializa o driver com o Firefox 
    }

    @SuppressWarnings("deprecation")
    @Test // Metodo Teste
    public void testVisualizarTarefa() { // Teste para cadastro de tarefa
        driver.get("http://localhost:8080/tarefas"); // Abrir a pagina de lista de tarefas

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Tempo de espera de 10 segundos para inicializar

       WebElement cadastrar = driver.findElement(By.className("btn-voltar")); // Encontrar o botao de cadastrar tarefa
       cadastrar.click(); // Clicar no botao

       WebElement caixaDeBusca = driver.findElement(By.id("titulo-cadastro")); // Encontra a caixa de texto 
       caixaDeBusca.click(); // Clica na caixa de texto
       caixaDeBusca.sendKeys("Teste De Cadastrar"); // Digita "Teste De Cadastrar"

       WebElement salvarCadastro = driver.findElement(By.id("salvarCadastro")); // Encontra o botão de salvar cadastro
       salvarCadastro.click(); // Clica no botão

       WebElement voltar = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       voltar.click(); // Clica no botão de voltar

       /* Visualizar Tarefa */

       WebElement visualizar = driver.findElement(By.className("btn-visualizar")); // Encontra o botao de visualizar
       visualizar.click(); // Clica no botao

       WebElement cadastroSucesso = driver.findElement(By.id("visualizarTarefa")); // Encontra o campo da visualizar tarefa
       String TarefaCadastroSucess = cadastroSucesso.getText(); // Recebe o texto da tarefa
    
       if(TarefaCadastroSucess.contains("Teste De Cadastrar")) { // Se no texto contem "Teste De Cadastrar"
        System.out.println("Teste de visualizar tarefa realizado com sucesso"); // Aparece essa mensagem
        }else{
         System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
        }

       WebElement voltarList = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       voltarList.click(); // Clica no botao

      
        /* Excluir Tarefa */
        WebElement excluir = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
       excluir.click(); // Clica no botao

       WebElement excluirSim = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
       excluirSim.click(); // Clica no botao

       driver.close(); // Fechar navegador

    }
}
