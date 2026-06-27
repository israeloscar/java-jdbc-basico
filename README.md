# ☕ Java JDBC — CRUD de Produtos (MySQL)

Sistema de cadastro de produtos via console, desenvolvido em Java com JDBC e MySQL. Permite cadastrar, listar, atualizar e deletar produtos através de um menu interativo.

Este projeto faz parte do meu aprendizado de Java Backend com foco em conseguir meu primeiro emprego como desenvolvedor. 🚀

---

## 📌 Objetivo

Praticar a conexão entre Java e MySQL usando JDBC, implementando um CRUD completo com menu interativo no console.

---

## 🧠 Conceitos aplicados

- JDBC (Java Database Connectivity).
- `Connection` e `DriverManager` para conexão com o banco.
- `PreparedStatement` para executar SQL com parâmetros seguros.
- `ResultSet` para navegar pelos resultados do SELECT.
- `executeUpdate()` para INSERT, UPDATE e DELETE.
- `executeQuery()` para SELECT.
- Separação de responsabilidades em métodos.
- Variáveis de ambiente com `System.getenv` para não expor a senha no código.
- Opção de voltar ao menu com `-1` em cada operação.
- Fechamento correto de recursos na ordem inversa de abertura.

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

## ⚙️ Como instalar e executar

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

```
MYSQL_PASSWORD=sua_senha_mysql
```

No Windows, pelo terminal:

```
setx MYSQL_PASSWORD "sua_senha_mysql"
```

### 4. Execute o projeto

Abra no IntelliJ IDEA e rode `App.java`.

---

## 💡 Exemplo de uso

```
----Menu CRUD----
1 - Adicionar um produto
2 - Listar todos os produtos
3 - Atualizar um produto
4 - Deletar um produto
0 - Sair
Escolha uma opção: 1

Nome do produto que deseja adicionar(ou -1 para voltar): Mouse Gamer
Preço do produto que deseja adicionar (ex: 89.90): 89.90
Produto cadastrado com sucesso! Linhas afetadas: 1

----Menu CRUD----
Escolha uma opção: 2

ID: 1 | Nome: Mouse Gamer | Preço: 89.9

----Menu CRUD----
Escolha uma opção: 3

ID: 1 | Nome: Mouse Gamer | Preço: 89.9
Digite o id do produto que deseja atualizar(ou digite -1 para voltar): 1
Qual será o novo nome: Mouse Gamer RGB
Qual será o novo preço: 120.00
Produto atualizado com sucesso! Linhas afetadas: 1

----Menu CRUD----
Escolha uma opção: 4

ID: 1 | Nome: Mouse Gamer RGB | Preço: 120.0
Digite o id do produto que deseja deletar(ou -1 para voltar): 1
Produto deletado com sucesso! Linhas afetadas: 1

----Menu CRUD----
Escolha uma opção: 0
Fim da conexão!
```

---

## 📈 Próximos passos

- Refatorar com try-with-resources para fechamento automático de recursos.
- Evoluir para Spring Boot com API REST 🚀

---

## 👤 Autor

**Israel Oscar**

[github.com/israeloscar](https://github.com/israeloscar)

*Atualizado conforme avanço nos estudos.* 📈