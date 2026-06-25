package com.israeloscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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

            String sql = """
            INSERT INTO produtos(nome, preco)
            VALUES(?,?)
            """;
            PreparedStatement stmt = conexao.prepareStatement(sql);


            stmt.setString(1, nome);
            stmt.setDouble(2, preco);

            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso! Linhas afetadas: " + linhasAfetadas);

            sc.close();
            stmt.close();
            conexao.close();
            System.out.println("Fim da conexão!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

