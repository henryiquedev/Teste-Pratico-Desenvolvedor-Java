# Teste-Pratico-Desenvolvedor-Java

## Descrição do Projeto

O projeto **Teste-Pratico-Desenvolvedor-Java** é uma aplicação web desenvolvida para gerenciar agendamentos. 
A aplicação permite o cadastro, consulta e listagem de agendamentos e solicitantes. Utiliza tecnologias como Spring Boot, PrimeFaces, HSQLDB, e Spring Data JPA.

## Tecnologias Utilizadas

- **Spring Boot 2.7.2:** Framework para criação de aplicações Java robustas e escaláveis.
- **Spring Data JPA:** Abstração para operações de persistência de dados usando JPA.
- **Hibernate:** Implementação do JPA para mapeamento objeto-relacional.
- **PrimeFaces 13.0.0:** Biblioteca de componentes UI para JSF.
- **HSQLDB 2.5.2:** Banco de dados relacional leve para desenvolvimento e testes.
- **Maven 3.11.0:** Ferramenta de automação de build e gerenciamento de dependências.

## Estrutura do Projeto

- **Controller Layer:** Gerencia as requisições HTTP.
  - `AgendamentoController`
- **Service Layer:** Contém a lógica de negócio.
  - `AgendamentoService`
- **Repository Layer:** Interage com o banco de dados.
  - `AgendamentoRepository`
- **Model Layer:** Representa as entidades do banco de dados.
  - `Agendamento`, `Solicitante`

## Configuração e Execução

### Pré-requisitos

- JDK 17 
- Maven 3.6 ou superior

### Passos para Configuração e Execução

1. **Clone o Repositório**
   ```sh
   git clone https://github.com/seu-usuario/Teste-Pratico-Desenvolvedor-Java.git
   cd Teste-Pratico-Desenvolvedor-Java
2. **Compile e Empacote o Projeto**
   - mvn clean
   - mvn install -DskipTests
   - java -jar -Dserver.port=9494 target/Teste-Pratico-Desenvolvedor-Java-0.0.2-SNAPSHOT.jar
3. **Execute a Aplicação**
   - java -jar -Dserver.port=9494 target/Teste-Pratico-Desenvolvedor-Java-0.0.2-SNAPSHOT.jar
4. **Acesse a Aplicação**
   - Abra o navegador e acesse http://localhost:9494

### Observações
- Qualquer duvida entrar em contato pelo email; carlosheryique@gmail.com
