# Avaliação Java / Spring: API Rest para Controle de Contatos
#### Daniel Antônio Pereira - 12/03/2024

### Configuração e Instalação

A configuração e instalação do projeto requer conhecimentos básicos em Maven e Spring Framework. É necessário ter o Java e o Maven instalados na sua máquina. Para a aplicação que utiliza banco de dados MySQL (Porta 3333), é necessário ter o Docker instalado para a instância do banco de dados.
OBS :::: Caso utilize a porta padrão (3306) troque no application.properties

Para rodar a aplicação, siga os passos abaixo:

1. Clone o repositório para sua máquina local.
2. Navegue até a pasta do projeto específico que deseja executar.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

---

### Documentação e Suporte

- **Swagger:** Todos os endpoints da aplicação RESTful são documentados utilizando o Swagger, acessível via `/swagger-ui.html` no navegador após a aplicação estar rodando.

- **Autenticação:** A aplicação AppControleContatos utiliza autenticação JWT. Para conseguir o acesso solicite a geração do token via '/token?username=nomeuser' informando seu nome de usuário.

---

### Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Docker
- MySQL
- Swagger
- JWT Authentication

---

### Contato

Para mais informações, entre em contato atraves de dantsp@gmail.com
