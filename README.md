# Teste-Pratico-Desenvolvedor-Java

## Descrição do Projeto

O projeto **Teste-Pratico-Desenvolvedor-Java** é uma aplicação web desenvolvida para gerenciar agendamentos de vagas. 
A aplicação permite o cadastro, consulta e listagem de agendamentos e solicitantes. Utiliza tecnologias como Spring Boot, PrimeFaces, HSQLDB, e Spring Data JPA, entre outras.

## Tecnologias Utilizadas

- **Spring Boot 2.7.2:** Framework para criação de aplicações Java robustas e escaláveis.
- **Spring Data JPA:** Abstração para operações de persistência de dados usando JPA.
- **Hibernate:** Implementação do JPA para mapeamento objeto-relacional.
- **PrimeFaces 13.0.0:** Biblioteca de componentes UI para JSF.
- **HSQLDB 2.5.2:** Banco de dados relacional leve para desenvolvimento e testes.
- **Maven 3.11.0:** Ferramenta de automação de build e gerenciamento de dependências.

## Arquitetura do Projeto

- **Controller Layer:** Gerencia as requisições HTTP e mapeamento das páginas JSF.
  - `AgendamentoController`,`SolicitanteController`,`VagaController`
- **Service Layer:** Contém a lógica de negócio.
  - `AgendamentoService`,`SolicitanteService`,`VagaService`
- **Repository Layer:** Interage com o banco de dados.
  - `AgendamentoRepository`,`SolicitanteRepository`,`VagaRepository`
- **Model Layer:** Representa as entidades do banco de dados.
  - `Agendamento`,`Solicitante`,`Vaga`
- **Bean:** Ponte entre a camada de visão (a interface do usuário) e a camada de serviço/lógica de negócios na aplicação.
  - `AgendamentoBean`, `SolicitanteBean`,`VagaBean`


**1. Camadas do Projeto**

- Controller (Camada de Controle):
  Responsável por lidar com as requisições HTTP recebidas pelo servidor e o mapeamento dos arquivo XHTML.
  Utiliza anotações do Spring (@RestController, @Controller, @RequestMapping, etc.) para mapear URLs para métodos específicos.
  Exemplo: AgendamentoController para lidar com endpoints relacionados a agendamentos.

- Service (Camada de Serviço):
  Contém a lógica de negócio da aplicação.
  Utiliza a anotação @Service do Spring.
  Exemplo: AgendamentoService que contém métodos para salvar, buscar e listar agendamentos.

- Repository (Camada de Repositório):
  Responsável pela interação com o banco de dados.
  Utiliza Spring Data JPA para operações CRUD.
  Exemplo: AgendamentoRepository que estende JpaRepository para fornecer métodos de acesso ao banco de dados.

- Model (Camada de Modelo):
  Contém as classes de entidade que representam as tabelas do banco de dados.
  Utiliza anotações do JPA (@Entity, @Table, @Column, etc.) para mapear classes Java para tabelas no banco de dados.
  Exemplo: Agendamento e Solicitante.

**2. Frameworks e Ferramentas Utilizadas**

 - Spring Boot:
    Framework principal para criar aplicações Java robustas e escaláveis.
- Spring Data JPA:
  Abstração sobre o JPA para facilitar operações com o banco de dados.
- Hibernate:
  Implementação do JPA usada para mapeamento objeto-relacional.
- PrimeFaces:
  Biblioteca de componentes UI para JSF.
- HSQLDB:
  Banco de dados relacional leve usado para persistência de dados.

**3. Banco de Dados**
Utiliza HSQLDB como banco de dados embutido para desenvolvimento e testes.
Configurado para criação automática das tabelas usando spring.jpa.hibernate.ddl-auto=update.


**Padrões de Projeto Utilizados**

1. MVC (Model-View-Controller)
Estrutura de divisão de responsabilidades entre modelo (dados), visão (UI) e controle (lógica de aplicação).
Model: Entidades JPA como Agendamento e Solicitante.
View: Páginas XHTML utilizando PrimeFaces.
Controller: AgendamentoController e Beans gerenciados por JSF.

3. Dependency Injection
Utilização de injeção de dependências do Spring para gerenciamento de beans e inversão de controle.
Anotações como @Autowired, @Component, @Service, e @Repository são usadas para definir e injetar dependências.
Outras anotações utilizadas @ViewScoped, @Data, @RequestMapping

5. Repository Pattern
Separação da lógica de acesso a dados em repositórios.
Por exemplo; AgendamentoRepository estende JpaRepository fornecendo uma interface limpa para operações CRUD.

7. Singleton Pattern
Utilização implícita pelo Spring no gerenciamento de beans de escopo singleton (default).

**Fluxo de Trabalho**

1. Cadastro de Agendamento
Usuário acessa a página de cadastro (cadastroagendamento.xhtml).
Preenche os campos do formulário e clica em "Salvar".
Requisição é enviada para AgendamentoBean, que chama o método salvar do AgendamentoService.
AgendamentoService persiste o novo agendamento no banco de dados via AgendamentoRepository.

3. Consulta de Agendamento
Usuário acessa a página de consulta (consultaagendamento.xhtml).
Preenche os critérios de busca e clica em "Consultar".
Requisição é enviada para AgendamentoBean, que chama o método consultar do AgendamentoService.
AgendamentoService retorna uma lista de agendamentos que correspondem aos critérios de busca via AgendamentoRepository.


4. Cadastro de Solicitante
Usuário acessa a página de cadastro (cadastrosolicitante.xhtml).
Preenche o campo do formulário e clica em "Salvar".
Requisição é enviada para AgendamentoBean, que chama o método salvar do AgendamentoService.
AgendamentoService persiste o novo solicitante no banco de dados via AgendamentoRepository.

6. Cadastro de Vaga
Usuário acessa a página de cadastro (cadastrovaga.xhtml).
Preenche os campos do formulário e clica em "Salvar".
Requisição é enviada para VagaBean, que chama o método salvar do VagaService.
VagaService persiste a nova vaga no banco de dados via VagaRepository.


**Arquivos Importantes**
**Páginas JSF**
- index.xhtml Página inicial, ao clicar no botão que iniciar o sistema SAV(Sistema Agendamento Vaga)
- homeagendamento.xhtml Página que dar acesso a todas as outras página do sistema.
- cadastroagendamento.xhtml Página para cadastro de agendamentos.
- consultaagendamento.xhtml Página para consulta de agendamentos.
- cadastrosolicitante.xhtml Página para consulta de solicitantes.
- cadastrovaga.xhtml Página para cadastro de vaga.



**Classes Java**
- AgendamentoBean Managed Bean para interagir com a camada de visão (JSF).
- AgendamentoController Controller para gerenciar requisições HTTP relacionadas, mapear a página .XHTML a agendamentos.
- AgendamentoService Serviço para lógica de negócios de agendamentos.
- AgendamentoRepository Repositório para interações com o banco de dados de agendamentos.

**Estrutura do Banco de Dados**
**Tabelas**
- Agendamento
    id (PK)
    data
    numero
    motivo
    solicitante_id (FK)
- Solicitante
  id (PK)
  nome
- Vagas
  id (PK)
  inicio
  fim
  quantidade

**Alguns Endpoints da API**
Agendamentos
- Criar Agendamento
    POST: http://localhost:9494/api/agendamentos
    Content-Type: application/json
    {
    "data": "2024-06-16T10:00:00",
    "numero": "12345",
    "motivo": "Reunião",
    "solicitante": { "id": 1 }
    }

- Buscar Agendamentos
  No navegador digite ao URL abaixo
  GET: http://localhost:9494/api/listaragendamentos?inicio=2024-06-01T00:00:00&fim=2024-06-30T23:59:59&solicitanteId=1

- Solicitantes
  Listar Solicitantes
  No navegador digite ao URL abaixo
  GET: http://localhost:9494/api/solicitante/

Vagas
Listar Vagas
No navegador digite ao URL abaixo
GET: http://localhost:9494/api/vagas/


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
3. **Execute a Aplicação**
   - java -jar -Dserver.port=9494 target/Teste-Pratico-Desenvolvedor-Java-0.0.2-SNAPSHOT.jar
4. **Acesse a Aplicação**
   - Abra o navegador e acesse http://localhost:9494

### Observações

- Essa arquitetura e os padrões de projeto asseguram uma aplicação organizada, modular, assim facilitando manutenibilidade, seguindo as melhores práticas de desenvolvimento
  com Spring Boot e JSF,aplicação também está preparada para fluxo dos verbos HTTP.
- Qualquer duvida entrar em contato pelo email; carlosheryique@gmail.com
