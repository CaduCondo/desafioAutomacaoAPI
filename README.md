
# Serverest API Tests – QA Automation Engineer

## Contexto
Projeto desenvolvido como desafio técnico para vaga de QA Automation Engineer.

## Estratégia de Testes
- Autenticação JWT (cenários válidos e inválidos)
- CRUD de usuários
- Cenários positivos e negativos
- Validação de contrato da API
- Rate limit tratado de forma resiliente

## Tecnologias
- Java 17
- JUnit 5
- RestAssured
- Allure Reports
- GitHub Actions

## Execução Local
mvn clean test

## Relatórios
allure serve target/allure-results

## CI
Os testes são executados automaticamente a cada push no GitHub.
