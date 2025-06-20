package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Auxiliar;

public class AuxiliarDAO {

	private String selectAll = "SELECT * FROM auxiliar";
	private String insert = "INSERT INTO auxiliar(nome, cpf, telefone, id_clinica, email, crmv, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String update = "UPDATE auxiliar SET nome = ?, cpf = ?, telefone = ?, id_clinica = ?, email = ?, crmv = ?, id_endereco = ? WHERE id_auxiliar = ?";
	private String delete = "DELETE FROM auxiliar WHERE id_auxiliar = ?";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

	public AuxiliarDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
	}

	public void insert(Auxiliar auxiliar) throws SQLException {
		pstInsert.setString(1, auxiliar.getNome());
		pstInsert.setString(2, auxiliar.getCpf());
		pstInsert.setString(3, auxiliar.getTelefone());
		pstInsert.setInt(4, auxiliar.getIdClinica());
		pstInsert.setString(5, auxiliar.getEmail());
		pstInsert.setString(6, auxiliar.getCrmv());
		pstInsert.setInt(7, auxiliar.getIdEndereco());
		pstInsert.execute();
	}

	public void update(Auxiliar auxiliar) throws SQLException {
		pstUpdate.setString(1, auxiliar.getNome());
		pstUpdate.setString(2, auxiliar.getCpf());
		pstUpdate.setString(3, auxiliar.getTelefone());
		pstUpdate.setInt(4, auxiliar.getIdClinica());
		pstUpdate.setString(5, auxiliar.getEmail());
		pstUpdate.setString(6, auxiliar.getCrmv());
		pstUpdate.setInt(7, auxiliar.getIdEndereco());
		pstUpdate.setInt(8, auxiliar.getIdAuxiliar());
		pstUpdate.execute();
	}

	public void delete(int idAuxiliar) throws SQLException {
		pstDelete.setInt(1, idAuxiliar);
		pstDelete.execute();
	}

	public ArrayList<Auxiliar> selectAll() throws SQLException {
		ArrayList<Auxiliar> auxiliares = new ArrayList<Auxiliar>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Auxiliar auxiliar = new Auxiliar();
			auxiliar.setIdAuxiliar(resultSet.getInt("id_auxiliar"));
			auxiliar.setNome(resultSet.getString("nome"));
			auxiliar.setCpf(resultSet.getString("cpf"));
			auxiliar.setTelefone(resultSet.getString("telefone"));
			auxiliar.setIdClinica(resultSet.getInt("id_clinica"));
			auxiliar.setEmail(resultSet.getString("email"));
			auxiliar.setCrmv(resultSet.getString("crmv"));
			auxiliar.setIdEndereco(resultSet.getInt("id_endereco"));
			auxiliares.add(auxiliar);
		}

		return auxiliares;
	}
}
