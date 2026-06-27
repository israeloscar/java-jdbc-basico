package com.israeloscar;

import java.sql.*;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        // Endereço do banco de dados, usuário e senha.
        String url = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = System.getenv("MYSQL_PASSWORD");

        try {

            Scanner sc = new Scanner(System.in);

            // Abre a conexão com o banco de dados.
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Exibe o menu e aguarda as ações do usuário.
            menu(conexao, sc);

            // Fecha os recursos na ordem inversa de abertura.
            conexao.close();
            sc.close();
            System.out.println("Fim da conexão!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Cadastra um novo produto no banco de dados.
    static void cadastrarProduto(Connection conexao, Scanner sc) throws SQLException {

        System.out.print("Nome do produto que deseja adicionar(ou -1 para voltar): ");
        String nome = sc.nextLine();

        // Retorna ao menu se o usuário digitar -1.
        if (nome.equals("-1")) {
            return;
        }

        System.out.print("Preço do produto que deseja adicionar (ex: 89.90): ");
        double preco = Double.parseDouble(sc.nextLine());

        // SQL de inserção com parâmetros para evitar SQL Injection.
        String sqlInsert = """
        INSERT INTO produtos(nome, preco)
        VALUES(?,?)
        """;

        // Prepara o comando SQL para execução.
        PreparedStatement stmtInsert = conexao.prepareStatement(sqlInsert);

        // Preenche os parâmetros na ordem em que aparecem no SQL.
        stmtInsert.setString(1, nome);
        stmtInsert.setDouble(2, preco);

        // Executa o INSERT e armazena quantas linhas foram afetadas.
        int linhasAfetadasInsert = stmtInsert.executeUpdate();

        System.out.println("Produto cadastrado com sucesso! Linhas afetadas: " + linhasAfetadasInsert);

        stmtInsert.close();
    }

    // Lista todos os produtos cadastrados no banco de dados.
    static void listarProdutos(Connection conexao) throws SQLException {

        String sqlSelect = """
                SELECT * FROM produtos
                """;

        PreparedStatement stmtSelect = conexao.prepareStatement(sqlSelect);

        // Executa o SELECT e armazena o resultado no ResultSet.
        ResultSet rs = stmtSelect.executeQuery();

        // Navega linha por linha pelo resultado e exibe cada produto.
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Preço: " + rs.getDouble("preco"));
        }

        // Fecha o ResultSet antes do statement.
        rs.close();
        stmtSelect.close();
    }

    // Atualiza o nome e o preço de um produto existente.
    static void atualizarProduto(Connection conexao, Scanner sc) throws SQLException {

        // Lista os produtos para o usuário visualizar os IDs disponíveis.
        listarProdutos(conexao);

        System.out.print("Digite o id do produto que deseja atualizar(ou digite -1 para voltar): ");
        int id = Integer.parseInt(sc.nextLine());

        // Retorna ao menu se o usuário digitar -1.
        if (id == -1) {
            return;
        }

        System.out.print("Qual será o novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Qual será o novo preço: ");
        double preco = Double.parseDouble(sc.nextLine());

        // SQL de atualização filtrando pelo id do produto.
        String sqlUpdate = """
                UPDATE produtos
                SET nome = ?, preco = ?
                WHERE id = ?
                """;

        PreparedStatement stmtUpdate = conexao.prepareStatement(sqlUpdate);

        // Preenche os parâmetros na ordem em que aparecem no SQL.
        stmtUpdate.setString(1, nome);
        stmtUpdate.setDouble(2, preco);
        stmtUpdate.setInt(3, id);

        int linhasAfetadasUpdate = stmtUpdate.executeUpdate();

        System.out.println("Produto atualizado com sucesso! Linhas afetadas: " + linhasAfetadasUpdate);

        stmtUpdate.close();
    }

    // Remove um produto do banco de dados pelo id.
    static void deletarProduto(Connection conexao, Scanner sc) throws SQLException {

        // Lista os produtos para o usuário visualizar os IDs disponíveis.
        listarProdutos(conexao);

        System.out.print("Digite o id do produto que deseja deletar(ou -1 para voltar): ");
        int id = Integer.parseInt(sc.nextLine());

        // Retorna ao menu se o usuário digitar -1.
        if (id == -1) {
            return;
        }

        // SQL de exclusão filtrando pelo id do produto.
        String sqlDelete = """
               DELETE FROM produtos
               WHERE id = ?
               """;

        PreparedStatement stmtDelete = conexao.prepareStatement(sqlDelete);

        stmtDelete.setInt(1, id);

        int linhasAfetadasDelete = stmtDelete.executeUpdate();

        System.out.println("Produto deletado com sucesso! Linhas afetadas: " + linhasAfetadasDelete);

        stmtDelete.close();
    }

    // Exibe o menu interativo e direciona para o método correto conforme a escolha do usuário.
    static void menu(Connection conexao, Scanner sc) throws SQLException {

        while (true) {
            System.out.println("----Menu CRUD----");
            System.out.println("1 - Adicionar um produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Atualizar um produto");
            System.out.println("4 - Deletar um produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            // Direciona para o método correspondente à opção escolhida.
            switch (opcao) {
                case "1" -> cadastrarProduto(conexao, sc);
                case "2" -> listarProdutos(conexao);
                case "3" -> atualizarProduto(conexao, sc);
                case "4" -> deletarProduto(conexao, sc);
                case "0" -> {
                    return;
                }
            }
        }
    }
}