package com.pedrosaez.englishtrainer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {

    private static final String URL = "jdbc:sqlite:data/englishtrainer.db";

    private static DataBaseManager instance;

    private DataBaseManager() {
        createDatabase();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    // Patrón Singleton
    public static synchronized DataBaseManager getInstance() {
        if (instance == null) {
            instance = new DataBaseManager();
        }
        return instance;
    }

    private void createDatabase() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                createTables(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.execute("""
            CREATE TABLE IF NOT EXISTS Vocabulario (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                palabra TEXT NOT NULL,
                significado TEXT NOT NULL,
                ejemplo TEXT,
                notas TEXT,
                dificultad INTEGER DEFAULT 1,
                creado TEXT NOT NULL
            );
        """);

        stmt.execute("""
            CREATE TABLE IF NOT EXISTS Vocab_estadisticas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                vocab_id INTEGER NOT NULL,
                correctas INTEGER DEFAULT 0,
                fallidas INTEGER DEFAULT 0,
                ultimas_estudiadas TEXT,
                FOREIGN KEY(vocab_id) REFERENCES Vocabulario(id)
            );
        """);

        stmt.execute("""
            CREATE TABLE IF NOT EXISTS Sesion_estudio(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fecha_sesion TEXT NOT NULL,
                total_preguntas INTEGER DEFAULT 0,
                respuestas_correctas INTEGER DEFAULT 0,
                respuestas_fallidas INTEGER DEFAULT 0
            );
        """);

        stmt.execute("""
            CREATE TABLE IF NOT EXISTS sesion_resultados(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                sesion_id INTEGER NOT NULL,
                vocab_id INTEGER NOT NULL,
                resultado TEXT NOT NULL CHECK (result IN ('CORRECT','WRONG')),
                FOREIGN KEY(session_id) REFERENCES Sesion_estudio(id),
                FOREIGN KEY(vocab_id) REFERENCES Vocabulario(id)
            );
        """);
    }
}
