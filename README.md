# ☕ Java JDBC — Cadastro e Listagem de Produtos (MySQL)

Projeto simples em Java utilizando JDBC para conexão com banco de dados MySQL, inserção e listagem de produtos via console.

Este projeto faz parte do meu aprendizado de Java Backend com foco em conseguir meu primeiro emprego como desenvolvedor. 🚀

---

## 📌 Objetivo

O objetivo deste projeto é praticar:

- Conexão entre Java e MySQL usando JDBC.
- Uso de PreparedStatement para INSERT e SELECT.
- Inserção de dados no banco via console.
- Listagem de todos os produtos cadastrados.
- Boas práticas de segurança com variáveis de ambiente.

---

## 🧠 Conceitos aplicados

- JDBC (Java Database Connectivity).
- DriverManager e Connection.
- PreparedStatement.
- ResultSet (navegação linha por linha com rs.next()).
- executeUpdate() para INSERT.
- executeQuery() para SELECT.
- Scanner (entrada de dados via console).
- Variáveis de ambiente (System.getenv).
- Fechamento de recursos na ordem inversa de abertura.

---

## 🛠️ Tecnologias utilizadas

- Java 21 ☕
- MySQL 🐬
- JDBC
- Maven
- IntelliJ IDEA 💡

---

## 📁 Estrutura do projeto

```
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

```
git clone https://github.com/israeloscar/java-jdbc-basico.git
```

### 2. Crie o banco de dados no MySQL

```sql
CREATE DATABASE loja;

USE loja;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DOUBLE
);
```

### 3. Configure a variável de ambiente

Crie a variável no sistema operacional:

```
MYSQL_PASSWORD=sua_senha_mysql
```

No código Java, ela é lida automaticamente:

```java
String senha = System.getenv("MYSQL_PASSWORD");
```

### 4. Execute o projeto

Abra no IntelliJ IDEA e rode `App.java`.

---

## 💡 Exemplo de uso

```
Nome do produto que deseja adicionar: Mouse Gamer
Preço do produto que deseja adicionar (ex: 89.90): 89.90

Produto cadastrado com sucesso! Linhas afetadas: 1

ID: 1 | Nome: Mouse Gamer | Preço: 89.9
ID: 2 | Nome: Teclado | Preço: 150.0

Fim da conexão!
```

---

## 📈 Próximos passos

- Implementar UPDATE (editar produtos).
- Implementar DELETE (remover produtos).
- Criar um CRUD completo no console.
- Evoluir para Spring Boot 🚀

---

## 👤 Autor

**Israel Oscar**

*Atualizado conforme avanço nos estudos.* 📈
