# 4T Todo - Lista de Tarefas

## 💻 Sobre o projeto


O 4T Todo trata-se de um projeto template para estágiarios da 4T Soluções se familiarizarem com nosso fluxo de trabalho, a respeito de desenvolvimento de software. O **4T TODO** é uma aplicação voltada a listagem de tarefas. Ele permite realizar a listagem das tarefas, cadastração , visualização , edição e exclusão das tarefas.

---
<p align="center">
  <img alt="4t" title="4t" src="assets/4t.png" width="100px">
</p>

---
## ⚙️ Fucionalidades


**Listar Tarefas:** Exibir uma lista de todas as tarefas cadastradas no sistema, permitindo que o usuário visualize o que precisa ser feito.

**Cadastrar Tarefas:** Permitir que o usuário adicione novas tarefas ao sistema, inserindo um título para a tarefa e salvando ela no banco de dados.

**Visualizar Tarefa:** Ao selecionar uma tarefa da lista, o usuário pode ver os detalhes dessa tarefa, como o título.

**Editar Tarefa:** Dar a capacidade ao usuário de editar os detalhes de uma tarefa existente, como seu título, e salvar as alterações no banco de dados.

**Excluir Tarefa:** Permitir que o usuário remova uma tarefa específica da lista de tarefas. Ao excluir uma tarefa, ela é removida permanentemente do banco de dados.

**Salvar no Banco de Dados:** Todas as informações das tarefas são armazenadas de forma permanentemente em um banco de dados para que possam ser acessadas e modificadas posteriormente.

**Validação de Título:** Garantir que o título da tarefa seja obrigatório ao cadastrá-la no sistema, exibindo uma mensagem de erro caso o campo esteja em branco.

**Feedback de Ações:** Fornecer feedback ao usuário após realizar uma ação, como cadastrar, editar ou excluir uma tarefa, informando se a operação foi bem-sucedida ou não.

---

## 🎨 Layout


### Web

1. Lista de Tarefas
<p align="center">
  <img alt="ListaInicial" title="ListaInicial" src="assets/ListaIncial.png" width="100px">
</p>

2. Cadastro de Tarefas
<p align="center">
  <img alt="Cadastro" title="Cadastro" src="assets/Cadastro.png" width="100px">
</p>

3. Visualizar Tarefas
<p align="center">
  <img alt="Visualizar" title="Visualizar" src="assets/Visualizar.png" width="100px">
</p>

4. Editar Tarefas
<p align="center">
  <img alt="Editar" title="Editar" src="assets/Editar.png" width="100px">
</p>

5. Excluir Tarefas
<p align="center">
  <img alt="Excluir" title="Excluir" src="assets/Excluir.png" width="100px">
</p>

6. Lista de Tarefas Cadastradas
<p align="center">
  <img alt="ListaDeTarefasCompleta" title="ListaDeTarefasCompleta" src="assets/ListaDeTarefasCompleta.png" width="100px">
</p>

---

## 🚨 Validação

1. Mensagem de erro ao tentar cadastrar uma nova tarefa com um titulo nulo ou vazio
<p align="center">
  <img alt="MessageErrorNew" title="MessageErrorNew" src="assets/MessageErrorNew.png" width="100px">
</p>

2. Mensagem de erro ao tentar editar uma tarefa com um titulo nulo ou vazio
<p align="center">
  <img alt="MessageErrorEdit" title="MessageErrorEdit" src="assets/MessageErrorEdit.png" width="100px">
</p>

---

## 🛠 Tecnologias


- **Backend**:
    - **Java** com:
    - **Spring Boot**:
        - **Spring MVC**
        - **Spring Thymeleaf**
        - **Spring Data JPA**
        - **Spring Web**
        - **Spring Devtools**
        - **Spring Validation**
        - **Spring Test**
        - **Selenium**
        - **Web Driver Manager**
    - **Maven**
        
- **Frontend**:
    - **Java** com:
        - **HTML5**
        - **CSS3**
- **Banco de Dados**:
    - **SQL** com:
        - **SQLite**
        - **Dbeaver**


---

## 🛣️ Como executar o projeto

Este projeto é divido em três partes:

- Backend (Java, Spring Boot, Maven) 

- Frontend (Html e Css)

- Banco de Dados (SQLite e Dbeaver)

---

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas: Git,Dbeaver,SQLite . Além disto é bom ter um editor para trabalhar com o código como VSCode
---


### Versões

- **java adoptopenjdk-21.0.1+12.0.LTS**
- **maven 3.9.6**
---

#### Instalação do java adoptopenjdk-21.0.1+12.0.LTS (Linux)

```bash

# Adicionando o plugin do Java ao asdf
asdf plugin-add java 

# Instalando uma versão específica do Java
asdf install java adoptopenjdk-21.0.1+12.0.LTS 

# Definindo a versão local do Java
asdf local java adoptopenjdk-21.0.1+12.0.LTS 

# Versão do Java instalada
java -version 
```
#### Instalação do maven 3.9.6 (Linux)

```bash

# Adicionando o plugin do Maven ao asdf
asdf plugin-add maven 
 
# Instalando uma versão específica do Maven
asdf install maven 3.9.6 
 
# Definindo a versão local do Maven
asdf local maven 3.9.6 

# Versão do Maven instalada
mvn -v 
```

---

Instale as versões acima para executar o projeto
---

#### Iniciando o Backend (terminal)

```bash

# Crie uma pasta em chamada t4td0
$ mkdir t4td0

# Acesse a pasta do projeto no terminal/cmd
$ cd t4td0

# Clone este repositório
$ SSH: git clone git@bitbucket.org:caio-vidal-silva/t4td0.git
$ HTTPS: git clone https://caiovidal4t@bitbucket.org/caio-vidal-silva/t4td0.git

# Execute o comando no terminal (Apos parametrização do Banco de Dados)
$ mvn spring-boot:run

# O servidor inciará na porta 8080 - acesse http://localhost:8080/tarefas
```
---
<p align="center">
  <img alt="run" title="run" src="assets/run.png" width="100px">
</p>

---
#### Iniciando e Configurando o Banco de Dados (sqlite e dbeaver)

```bash

#Instale a versão mais recente do SQLite

#Instale a versão mais recente da ferramenta de gestão de bases de dados (Dbeaver)

#Entre no Dbeaver, crie uma nova conexão e escolha banco SQLite

#Crie um banco chamado database.sqlite

#Copie a url do banco database.sqlite criado

# Abra seu editor de codigo no projeto t4td0

# Entre no arquivo application.properties 
$ t4td0/src/main/resources/application.properties 

# Altere o caminho do banco 
$ spring.datasource.url=jdbc:sqlite:/home/caiovidal/Workspaces/t4td0/database.sqlite
```
---
<p align="center">
  <img alt="Dbeaver" title="run" src="assets/Dbeaver.png" width="100px">
</p>

---
#### Iniciando a aplicação web (localhost)

```bash

# Apos seguir o passo a passo e inicar o Spring Boot no terminal executando o comando 
$ mvn spring-boot:run

# Abra seu navegador 

# O servidor inciará na porta 8080 - acesse http://localhost:8080/tarefas
```
---
<p align="center">
  <img alt="Localhost" title="Localhost" src="assets/Localhost.png" width="100px">
</p>

---
## 🛠 Testes Automatizados

Os testes automatizados são de grande importância para o processo de construção de software visto que ajudam a reduzir o tempo de realização dos testes que são feitos manualmente proporcionando velocidade e fluidez ao processo de validação. Em outras palavras, esta abordagem viabiliza a execução dos testes de forma rápida e com uma cobertura maior do sistema, quando empregada de forma correta.

### Pré-requisitos
---
Antes de começar, você precisa limpar a lista de tarefas para uma boa execução dos testes automatizados.
---

#### Iniciando Testes Automatizados (terminal)
```bash

# Inicie seu terminal e execute o comando pata iniciar o Spring Boot
$ mvn spring-boot:run

# Inicie outra aba do terminal e execute o comando para iniciar os testes
$ mvn test

# Os testes automatizados serão realizados automaticamente 

# Após término dos testes, será mostrado a resolução e o feedback de cada um dos testes individualmente, informando em texto se foi REALIZADO COM SUCESSO ou se ocorreu ERRO NA PESQUISA

# No final da realização do testes automatizados é transmitido um relátorio informando:
$ Iniciados
$ Falhas
$ Erros
$ Ignorados
$ Tempo Total 
$ Data e Hora 
```
---

<p align="center">
  <img alt="Localhost" title="Localhost" src="assets/TestesAutomatizados.png" width="100px">
</p>

---
## 📝 Autor 

Feito por Caio Vidal [Entre em contato!](https://www.linkedin.com/in/caio-nobre-vidal-silva-23669b270/)






