package com.israeloscar;

import java.sql.*;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = System.getenv("MYSQL_PASSWORD");

        try {

            System.out.print("Nome do produto que deseja adicionar: ");
            String nome = sc.nextLine();

            System.out.print("Preço do produto que deseja adicionar (ex: 89.90): ");
            double preco = Double.parseDouble(sc.nextLine());

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            String sqlInsert = """
            INSERT INTO produtos(nome, preco)
            VALUES(?,?)
            """;

            String sqlSelect = """
                    SELECT * FROM produtos
                    """;

            PreparedStatement stmtInsert = conexao.prepareStatement(sqlInsert);

            PreparedStatement stmtSelect = conexao.prepareStatement(sqlSelect);


            stmtInsert.setString(1, nome);
            stmtInsert.setDouble(2, preco);

            int linhasAfetadas = stmtInsert.executeUpdate();

            ResultSet rs = stmtSelect.executeQuery();

            System.out.println("Produto cadastrado com sucesso! Linhas afetadas: " + linhasAfetadas);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Preço: " + rs.getDouble("preco"));
            }

            rs.close();
            stmtInsert.close();
            stmtSelect.close();
            conexao.close();
            sc.close();
            System.out.println("Fim da conexão!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

