package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;
import database.model.Veterinario;

public class VeterinarioDAO {

    private String selectAll = "SELECT * FROM veterinario";
    private String insert = "INSERT INTO veterinario(nome, id_clinica, cpf, crmv, email, especialidade, telefone, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private String update = "UPDATE veterinario SET nome = ?, id_clinica = ?, cpf = ?, crmv = ?, email = ?, especialidade = ?, telefone = ?, id_endereco = ? WHERE id_veterinario = ?";
    private String delete = "DELETE FROM veterinario WHERE id_veterinario = ?";

    private PreparedStatement pstSelectAll;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public VeterinarioDAO() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        pstSelectAll = connection.prepareStatement(selectAll);
        pstInsert = connection.prepareStatement(insert);
        pstUpdate = connection.prepareStatement(update);
        pstDelete = connection.prepareStatement(delete);
    }

    public void insert(Veterinario veterinario) throws SQLException {
        pstInsert.setString(1, veterinario.getNome());
        pstInsert.setInt(2, veterinario.getIdClinica());
        pstInsert.setString(3, veterinario.getCpf());
        pstInsert.setString(4, veterinario.getCrmv());
        pstInsert.setString(5, veterinario.getEmail());
        pstInsert.setString(6, veterinario.getEspecialidade());
        pstInsert.setString(7, veterinario.getTelefone());
        pstInsert.setInt(8, veterinario.getIdEndereco());
        pstInsert.execute();
    }

    public void update(Veterinario veterinario) throws SQLException {
        pstUpdate.setString(1, veterinario.getNome());
        pstUpdate.setInt(2, veterinario.getIdClinica());
        pstUpdate.setString(3, veterinario.getCpf());
        pstUpdate.setString(4, veterinario.getCrmv());
        pstUpdate.setString(5, veterinario.getEmail());
        pstUpdate.setString(6, veterinario.getEspecialidade());
        pstUpdate.setString(7, veterinario.getTelefone());
        pstUpdate.setInt(8, veterinario.getIdEndereco());
        pstUpdate.setInt(9, veterinario.getIdVeterinario());
        pstUpdate.execute();
    }

    public void delete(int idVeterinario) throws SQLException {
        pstDelete.setInt(1, idVeterinario);
        pstDelete.execute();
    }

    public List<Veterinario> selectAll() throws SQLException {
        List<Veterinario> veterinarios = new ArrayList<>();
        ResultSet resultSet = pstSelectAll.executeQuery();

        while (resultSet.next()) {
            Veterinario veterinario = new Veterinario();
            veterinario.setIdVeterinario(resultSet.getInt("id_veterinario"));
            veterinario.setNome(resultSet.getString("nome"));
            veterinario.setIdClinica(resultSet.getInt("id_clinica"));
            veterinario.setCpf(resultSet.getString("cpf"));
            veterinario.setCrmv(resultSet.getString("crmv"));
            veterinario.setEmail(resultSet.getString("email"));
            veterinario.setEspecialidade(resultSet.getString("especialidade"));
            veterinario.setTelefone(resultSet.getString("telefone"));
            veterinario.setIdEndereco(resultSet.getInt("id_endereco"));
            veterinarios.add(veterinario);
        }

        return veterinarios;
    }
}
