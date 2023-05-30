# Desafio-Digix
Desafio Técnico - Digix - Desenvolvedor

# Documentação do Projeto
# Visão Geral

Este documento descreve o projeto feito para o Desafio Técnico da Digix para Desenvolvedor.
O sistema é baseado em Spring Boot 2.7.12 para a criação de uma API Restful. O projeto utiliza a versão 2.7.12 do spring para utilizar o Swagger como uma ferramenta para testar e visualizar o funcionamento da API.

# Tecnologias Utilizadas

•	Spring Boot 2.7.12

•	Java 17

•	Maven

# Dependências

•	spring-boot-devtools

•	lombok

•	spring-boot-starter-validation

•	spring-boot-starter-data-jpa

•	spring-boot-starter-web

•	mysql-connector-java

•	flyway-core

# Link do Swagger

O Swagger é utilizado neste projeto para documentar e testar a API.
`http://localhost:8080/swagger-ui.html`

Configuração do Banco de Dados

O projeto utiliza o Spring Data JPA em conjunto com o Flyway para migrações do banco de dados.

# •	application.properties:
# # Configurações do banco de dados MySQL

spring.datasource.url=jdbc:mysql://localhost:3306/habitpop

spring.datasource.username=root

spring.datasource.password=Admin123

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.error.include-stacktrace=never

# # Configurações do Flyway
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration

# Documentação da API
# Base URL
A base URL para todas as requisições é: `http://localhost:8080`

# Domínio
Camada com as classes principais e seus respectivos DTO’s em Record e repository.

# Repository
O acesso aos dados é gerenciado pelo repository usando o JpaRepository.

# Infraestrutura
A infraestrutura da API inclui o tratamento de exceções utilizando @RestControllerAdvice e @ExceptionHandler. Isso permite o tratamento adequado de erros e a geração de respostas de erro consistentes em toda a aplicação.

# Migrações
As migrações do banco de dados são gerenciadas usando o Flyway. Isso garante que o banco de dados esteja sempre atualizado com as versões mais recentes do esquema, além de manter histórico.

# Exclusão Lógica
As exclusões neste projeto acontecem de forma lógica apenas, sendo inativado para não mostrar nas requisições GET, porém com seu histórico armazenado para consultas de usuários inativos em uma url específica conforme controller.
