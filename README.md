# Projeto Spring Boot - API Frete Mais

---

## 📋 Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Um editor de código, como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [VS Code](https://code.visualstudio.com/).

---

## ⚙️ Configuração do Projeto

### 1. Dependências no `pom.xml`

O projeto já está configurado com as seguintes dependências:

- **Spring Boot Starter Data JPA**: Para integração com o banco de dados.
- **Spring Boot Starter Web**: Para criar APIs REST.
- **Spring Boot DevTools**: Para desenvolvimento com recarregamento automático.
- **PostgreSQL Driver**: Para comunicação com o banco de dados PostgreSQL.
- **Lombok**: Para reduzir o código boilerplate.
- **Spring Boot Starter Test**: Para testes unitários e de integração.

Aqui está um exemplo do `pom.xml` usado no projeto:

```xml
<dependencies>
    <!-- Spring Boot Starter para JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Spring Boot Starter para Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- DevTools para facilitar o desenvolvimento -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Driver para PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Dependência para Testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```


# Configurações do projeto
spring.application.name=api

## Configurações do banco de dados
spring.datasource.url=jdbc:postgresql://ep-lively-base-a5pilucr.us-east-2.aws.neon.tech/neondb?user=neondb_owner&password=vUgB6TEaQyz4&sslmode=require
spring.datasource.username=neondb_owner
spring.datasource.password=vUgB6TEaQyz4

## Configurações de Pool de Conexões
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=30000

## Configurações de Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.batch_size=50
spring.jpa.properties.hibernate.jdbc.fetch_size=50
spring.jpa.properties.hibernate.cache.use_second_level_cache=false



