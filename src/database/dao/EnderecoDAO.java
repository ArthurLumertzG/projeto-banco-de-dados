package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Endereco;

public class EnderecoDAO {

	private String selectAll = "SELECT * FROM endereco";
	private String insert = "INSERT INTO endereco(cep, rua, numero, bairro, cidade, estado, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String update = "UPDATE endereco SET cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ? WHERE id_endereco = ?";
	private String delete = "DELETE FROM endereco WHERE id_endereco = ?";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

	public EnderecoDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
	}

	public void insert(Endereco endereco) throws SQLException {
		pstInsert.setString(1, endereco.getCep());
		pstInsert.setString(2, endereco.getRua());
		pstInsert.setString(3, endereco.getNumero());
		pstInsert.setString(4, endereco.getBairro());
		pstInsert.setString(5, endereco.getCidade());
		pstInsert.setString(6, endereco.getEstado());
		pstInsert.setString(7, endereco.getComplemento());
		pstInsert.execute();
	}

	public void update(Endereco endereco) throws SQLException {
		pstUpdate.setString(1, endereco.getCep());
		pstUpdate.setString(2, endereco.getRua());
		pstUpdate.setString(3, endereco.getNumero());
		pstUpdate.setString(4, endereco.getBairro());
		pstUpdate.setString(5, endereco.getCidade());
		pstUpdate.setString(6, endereco.getEstado());
		pstUpdate.setString(7, endereco.getComplemento());
		pstUpdate.setInt(8, endereco.getIdEndereco());
		pstUpdate.execute();
	}

	public void delete(int idEndereco) throws SQLException {
		pstDelete.setInt(1, idEndereco);
		pstDelete.execute();
	}

	public ArrayList<Endereco> selectAll() throws SQLException {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(resultSet.getInt("id_endereco"));
			endereco.setCep(resultSet.getString("cep"));
			endereco.setRua(resultSet.getString("rua"));
			endereco.setNumero(resultSet.getString("numero"));
			endereco.setBairro(resultSet.getString("bairro"));
			endereco.setCidade(resultSet.getString("cidade"));
			endereco.setEstado(resultSet.getString("estado"));
			endereco.setComplemento(resultSet.getString("complemento"));
			enderecos.add(endereco);
		}

		return enderecos;
	}
}
