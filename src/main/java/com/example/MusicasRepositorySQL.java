package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicasRepositorySQL extends RepositoryMySQL<Musicas> implements MusicasRepository {
    @Override
    public void poulate() {
        String uri = "jdbc:mysql://localhost/mydatabase2?user=myuser&password=mypass";

        try (Connection conn = DriverManager.getConnection(uri)) {
            //INSERT
            PreparedStatement statement = conn.prepareStatement("INSERT INTO movies(id,title) VALUES(?,?)");
            statement.setString(1, "1");
            statement.setString(2, "Brave");
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
