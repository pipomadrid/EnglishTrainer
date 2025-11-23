package com.pedrosaez.englishtrainer.repository;

import com.pedrosaez.englishtrainer.model.Vocabulario;
import com.pedrosaez.englishtrainer.service.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VocabularioDAOImpl implements VocabularioDAO{

    @Override
    public void insert(Vocabulario v) {
        String sql = """
            INSERT INTO Vocabulario(palabra, significado, ejemplo, notas, dificultad, creado)
            VALUES (?, ?, ?, ?, ?, ?)
        """;
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,v.getPalabra());
            stmt.setString(2,v.getSignificado());
            stmt.setString(3,v.getEjemplo());
            stmt.setString(4,v.getNotas());
            stmt.setInt(5,v.getDificultad());
            stmt.setString(6,v.getCreado());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) v.setId(rs.getInt(1));


        }catch(SQLException e){
            e.printStackTrace();

        }
    }

    @Override
    public void update(Vocabulario v) {
        String sql = """
            UPDATE Vocabulario
            SET palabra=?, significado=?, ejemplo=?, notas=?, dificultad=?
            WHERE id=?
        """;

        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,v.getPalabra());
            stmt.setString(2,v.getSignificado());
            stmt.setString(3,v.getEjemplo());
            stmt.setString(4,v.getNotas());
            stmt.setInt(5,v.getDificultad());
            stmt.setString(6,v.getCreado());

            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Vocabulario WHERE id=?";

        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vocabulario findById(int id) {
        String sql = "SELECT * FROM Vocabulario WHERE id=?";

        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vocabulario v = new Vocabulario();
                v.setId(rs.getInt("id"));
                v.setPalabra(rs.getString("word"));
                v.setSignificado(rs.getString("meaning"));
                v.setEjemplo(rs.getString("example"));
                v.setNotas(rs.getString("notes"));
                v.setDificultad(rs.getInt("difficulty"));
                v.setCreado(rs.getString("created_at"));
                return v;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Vocabulario> findAll() {
        List<Vocabulario> list = new ArrayList<>();
        String sql = "SELECT * FROM Vocabulario ORDER BY created_at DESC";

        try (Connection conn = DataBaseManager.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                Vocabulario v = new Vocabulario();
                v.setId(rs.getInt("id"));
                v.setPalabra(rs.getString("word"));
                v.setSignificado(rs.getString("meaning"));
                v.setEjemplo(rs.getString("example"));
                v.setNotas(rs.getString("notes"));
                v.setDificultad(rs.getInt("difficulty"));
                v.setCreado(rs.getString("created_at"));
                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Vocabulario> search(String query) {
        List<Vocabulario> list = new ArrayList<>();
        String sql = """
            SELECT * FROM VOCABULARY
            WHERE palabra LIKE ? OR significado LIKE ?
            ORDER BY word ASC
        """;

        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String pattern = "%" + query + "%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vocabulario v = new Vocabulario();
                v.setId(rs.getInt("id"));
                v.setPalabra(rs.getString("word"));
                v.setSignificado(rs.getString("meaning"));
                v.setEjemplo(rs.getString("example"));
                v.setNotas(rs.getString("notes"));
                v.setDificultad(rs.getInt("difficulty"));
                v.setCreado(rs.getString("created_at"));
                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
