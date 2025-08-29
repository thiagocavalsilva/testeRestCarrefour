Testes de API com RestAssured + Cucumber (PT-BR) - Para Banco Carrefour
================================================================

Descrição
---------
Suite de testes BDD para endpoints REST (ex.: /login e /usuarios), usando:
- Java + Maven
- Cucumber (Gherkin em português)
- RestAssured
- JUnit
- Geração de relatório HTML (maven-cucumber-reporting)

Estrutura principal
-------------------
/src/test/java/
  ├─ hooks/               -> Hooks de cenário/suite (prepara baseURL e limpeza)
  ├─ maps/                -> "Mapas" (dados/objetos usados nos testes)
  ├─ steps/               -> Definições de passos (Dado/Quando/Então)
  └─ runner/RunnerTest.java -> Runner JUnit do Cucumber
/src/test/resources/features/
  ├─ login.feature
  └─ usuarios.feature

Requisitos
----------
- JDK 17+ (o POM está configurado para <source/target>=24; se necessário, ajuste para 17)
- Maven 3.8+
- Uma API local rodando em http://localhost:3000 com endpoints compatíveis (ex.: ServeRest).
  • Para usar o ServeRest (exemplo), você pode executá-lo localmente e mantê-lo ativo durante os testes.
  • Se desejar outro host/porta, ajuste o método prepararAmbiente() em hooks/HooksUsuarios.java
    (chamada RequisicoesApi.definirBaseUrl("http://localhost:3000")).

Como executar
-------------
1) Garanta que a API esteja rodando em http://localhost:3000.
2) No diretório do projeto, rode:
   mvn clean test -Dtest=runner.RunnerTest

Filtrar cenários via TAGs
-------------------------
O Runner (runner/RunnerTest.java) já vem com um filtro de tags.
- Para executar apenas cenários de usuários, garanta: tags = "@usuarios"
- Para executar cenários de login, use a tag presente no arquivo login.feature (ex.: @Login) e ajuste o Runner.

Relatórios
----------
- Um arquivo JSON é salvo em: target/reports/cucumberReports.json
- O plugin maven-cucumber-reporting gera o relatório HTML em: target/reports/cucumber-html-reports/index.html

Dicas
-----
- Mensagens/validações esperadas estão definidas nos .feature (em PT-BR).
- A baseURL está hardcoded no Hook; altere-a se sua API não usar localhost:3000.
- Se usar Java diferente do configurado, ajuste <maven.compiler.source>/<target> no pom.xml.

Comandos úteis
--------------
- Limpar e testar:        mvn clean test -Dtest=runner.RunnerTest
- Somente limpar:         mvn clean
- Ver versão do Maven:    mvn -v
