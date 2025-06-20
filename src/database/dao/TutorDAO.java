package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;
import database.model.Tutor;

public class TutorDAO {

    private String selectAll = "SELECT * FROM tutor";
    private String insert = "INSERT INTO tutor(nome, cpf, email, telefone, id_endereco) VALUES (?, ?, ?, ?, ?)";
    private String update = "UPDATE tutor SET nome = ?, cpf = ?, email = ?, telefone = ?, id_endereco = ? WHERE id_tutor = ?";
    private String delete = "DELETE FROM tutor WHERE id_tutor = ?";

    private PreparedStatement pstSelectAll;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public TutorDAO() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        pstSelectAll = connection.prepareStatement(selectAll);
        pstInsert = connection.prepareStatement(insert);
        pstUpdate = connection.prepareStatement(update);
        pstDelete = connection.prepareStatement(delete);
    }

    public void insert(Tutor tutor) throws SQLException {
        pstInsert.setString(1, tutor.getNome());
        pstInsert.setString(2, tutor.getCpf());
        pstInsert.setString(3, tutor.getEmail());
        pstInsert.setString(4, tutor.getTelefone());
        pstInsert.setInt(5, tutor.getIdEndereco());
        pstInsert.execute();
    }

    public void update(Tutor tutor) throws SQLException {
        pstUpdate.setString(1, tutor.getNome());
        pstUpdate.setString(2, tutor.getCpf());
        pstUpdate.setString(3, tutor.getEmail());
        pstUpdate.setString(4, tutor.getTelefone());
        pstUpdate.setInt(5, tutor.getIdEndereco());
        pstUpdate.setInt(6, tutor.getIdTutor());
        pstUpdate.execute();
    }

    public void delete(int idTutor) throws SQLException {
        pstDelete.setInt(1, idTutor);
        pstDelete.execute();
    }

    public List<Tutor> selectAll() throws SQLException {
        List<Tutor> tutors = new ArrayList<>();
        ResultSet resultSet = pstSelectAll.executeQuery();

        while (resultSet.next()) {
            Tutor tutor = new Tutor();
            tutor.setIdTutor(resultSet.getInt("id_tutor"));
            tutor.setNome(resultSet.getString("nome"));
            tutor.setCpf(resultSet.getString("cpf"));
            tutor.setEmail(resultSet.getString("email"));
            tutor.setTelefone(resultSet.getString("telefone"));
            tutor.setIdEndereco(resultSet.getInt("id_endereco"));
            tutors.add(tutor);
        }

        return tutors;
    }
}
