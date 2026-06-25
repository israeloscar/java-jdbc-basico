# ☕ Java JDBC — Cadastro de Produtos (MySQL)

Projeto simples em Java utilizando JDBC para conexão com banco de dados MySQL e inserção de produtos via console.

Este projeto faz parte do meu aprendizado de Java Backend com foco em conseguir meu primeiro emprego como desenvolvedor. 🚀

---

## 📌 Objetivo

O objetivo deste projeto é praticar:

* Conexão entre Java e MySQL usando JDBC
* Uso de PreparedStatement
* Inserção de dados no banco (INSERT)
* Entrada de dados via console com Scanner
* Boas práticas básicas de separação de dados e segurança

---

## 🧠 Conceitos aplicados

* JDBC (Java Database Connectivity)
* DriverManager e Connection
* PreparedStatement
* SQL parametrizado (?)
* executeUpdate()
* Scanner (entrada de dados)
* Variáveis de ambiente (System.getenv)

---

## 🛠️ Tecnologias utilizadas

* Java 21 ☕
* MySQL 🐬
* JDBC
* Maven
* IntelliJ IDEA 💡

---

## 📁 Estrutura do projeto

```text
jdbc-mysql/
│
├── pom.xml
├── README.md
│
└── src/
    └── main/
        └── java/
            └── com/israeloscar/
                └── App.java
```

---

## ⚙️ Como instalar e executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/israeloscar/jdbc-mysql.git
```

---

### 2. Crie o banco de dados no MySQL

Execute no MySQL:

```sql
CREATE DATABASE loja;

USE loja;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DOUBLE
);
```

---

### 3. Configure a variável de ambiente

Crie a variável no sistema operacional:

```text
MYSQL_PASSWORD=sua_senha_mysql
```

No código Java, ela é lida automaticamente:

```java
String senha = System.getenv("MYSQL_PASSWORD");
```

---

### 4. Execute o projeto

Abra no IntelliJ IDEA e rode:

```text
App.java
```

Ou execute pelo Maven/IDE.

---

## 💡 Exemplo de uso

```text
Nome do produto que deseja adicionar: Mouse Gamer
Preço do produto que deseja adicionar (ex: 89.90): 89.90

Produto cadastrado com sucesso! Linhas afetadas: 1
Fim da conexão!
```

---

## 📈 Próximos passos

* Implementar SELECT (listar produtos)
* Implementar UPDATE (editar produtos)
* Implementar DELETE (remover produtos)
* Criar um CRUD completo no console
* Evoluir para Spring Boot 🚀

---

## 👤 Autor

**Israel Oscar**

*Atualizado conforme avanço nos estudos.* 📈
