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
    
    private static WebDriver driver; // variavel driver do tipo WebDriver

    @BeforeAll // Executar o método abaixo antes de todos os testes
    public static void setUp() { // Configuração
        WebDriverManager.firefoxdriver().setup(); // Configura o driver do Firefox
        FirefoxOptions options = new FirefoxOptions(); // Opções do Firefox
        driver = new FirefoxDriver(options); // Inicializa o driver com o Firefox 
    }

    @SuppressWarnings("deprecation")
    @Test // Metodo Teste
    public void testListaTarefa() { // Teste para cadastro de tarefa
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

        /* Tarefa Cadastrada com Sucesso */
        WebElement cadastroSucesso = driver.findElement(By.className("tarefa-nome")); // Encontra o campo da tarefa cadastrada
        String TarefaCadastroSucess = cadastroSucesso.getText(); // Recebe o texto da tarefa
        
        if(TarefaCadastroSucess.contains("Teste De Cadastrar")) { // Se no texto contem "Teste De Cadastrar"
         System.out.println("1° Teste de listar tarefa realizado com sucesso"); // Aparece essa mensagem
         }else{
          System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
         }

         /* Excluir Tarefa */
        WebElement excluir = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
        excluir.click(); // Clica no botao
 
        WebElement excluirSim = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
        excluirSim.click(); // Clica no botao

       /* 2° Teste */

       WebElement cadastrar2 = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       cadastrar2.click(); // Clica no botao

       WebElement caixaDeBusca2 = driver.findElement(By.id("titulo-cadastro")); // Encontra a caixa de texto 
       caixaDeBusca2.click(); // Clica no botao
       caixaDeBusca2.sendKeys("Teste De Cadastrar 2");  // Digita "Teste De Cadastrar 2"

       WebElement salvarCadastro2 = driver.findElement(By.id("salvarCadastro")); // Encontra o botão de salvar cadastro
       salvarCadastro2.click(); // Clica no botao

       WebElement voltar2 = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       voltar2.click(); // Clica no botao

       /* Tarefa Cadastrada com Sucesso 2 */
       WebElement cadastroSucesso2 = driver.findElement(By.className("tarefa-nome")); // Encontra o campo da tarefa cadastrada
       String TarefaCadastroSucess2 = cadastroSucesso2.getText(); // Recebe o texto da tarefa
       
       if(TarefaCadastroSucess2.contains("Teste De Cadastrar 2")) { // Se no texto contem "Teste De Cadastrar 2"
        System.out.println("2° Teste de listar tarefa realizado com sucesso"); // Aparece essa mensagem
        }else{
         System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
        }


        /* Excluir Tarefa */

       WebElement excluir2 = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
       excluir2.click(); // Clica no botao

       WebElement excluirSim2 = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
       excluirSim2.click(); // Clica no botao

         /* 3° Teste */
       WebElement cadastrar3 = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       cadastrar3.click(); // Clica no botao

       WebElement caixaDeBusca3 = driver.findElement(By.id("titulo-cadastro")); // Encontra a caixa de texto 
       caixaDeBusca3.click(); // Clica no botao
       caixaDeBusca3.sendKeys("Teste De Cadastrar 3"); // Digita "Teste De Cadastrar 3"

       WebElement salvarCadastro3 = driver.findElement(By.id("salvarCadastro")); // Encontra o botão de salvar cadastro
       salvarCadastro3.click(); // Clica no botao

       WebElement voltar3 = driver.findElement(By.className("btn-voltar")); // Encontra o botão de voltar
       voltar3.click(); // Clica no botao

        /* Tarefa Cadastrada com Sucesso 3 */
       WebElement cadastroSucesso3 = driver.findElement(By.className("tarefa-nome")); // Encontra o campo da tarefa cadastrada
       String TarefaCadastroSucess3 = cadastroSucesso3.getText(); // Recebe o texto da tarefa
       
       if(TarefaCadastroSucess3.contains("Teste De Cadastrar 3")) { // Se no texto contem "Teste De Cadastrar 3"
        System.out.println("3° Teste de listar tarefa realizado com sucesso"); // Aparece essa mensagem
        }else{
         System.out.println("Erro na Pesquisa"); // Aparece essa mensagem
        }

        /* Excluir Tarefa */

       WebElement excluir3 = driver.findElement(By.className("btn-excluir")); // Encontrar botao para ir a exclusao da tarefa
       excluir3.click(); // Clica no botao

       WebElement excluirSim3 = driver.findElement(By.className("btn-sim")); // Encontrar botao para SIM para excluir a tarefa
       excluirSim3.click(); // Clica no botao

       driver.close(); // Fechar navegador
      
    }
}
