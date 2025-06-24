package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Clinica;
import database.model.TotalConsultas;

public class ClinicaDAO {

	private String selectAll = "SELECT * FROM clinica";
	private String insert = "INSERT INTO clinica(nome, cnpj, telefone, email, id_endereco) VALUES (?, ?, ?, ?, ?)";
	private String update = "UPDATE clinica SET nome = ?, cnpj = ?, telefone = ?, email = ?, id_endereco = ? WHERE id_clinica = ?";
	private String delete = "DELETE FROM clinica WHERE id_clinica = ?";
	private String totalConsultasPorClinica = "SELECT c.id_clinica, c.nome AS nome_clinica, COUNT(*) AS total_consultas FROM Consulta cs JOIN Veterinario v ON cs.id_veterinario = v.id_veterinario JOIN Clinica c ON v.id_clinica = c.id_clinica GROUP BY c.id_clinica, c.nome ORDER BY total_consultas DESC;";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;
	private PreparedStatement pstTotalConsultasPorClinica;

	public ClinicaDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
		pstTotalConsultasPorClinica = connection.prepareStatement(totalConsultasPorClinica);
	}

	public void insert(Clinica clinica) throws SQLException {
		pstInsert.setString(1, clinica.getNome());
		pstInsert.setString(2, clinica.getCnpj());
		pstInsert.setString(3, clinica.getTelefone());
		pstInsert.setString(4, clinica.getEmail());
		pstInsert.setInt(5, clinica.getIdEndereco());
		pstInsert.execute();
	}

	public void update(Clinica clinica) throws SQLException {
		pstUpdate.setString(1, clinica.getNome());
		pstUpdate.setString(2, clinica.getCnpj());
		pstUpdate.setString(3, clinica.getTelefone());
		pstUpdate.setString(4, clinica.getEmail());
		pstUpdate.setInt(5, clinica.getIdEndereco());
		pstUpdate.setInt(6, clinica.getIdClinica());
		pstUpdate.execute();
	}

	public void delete(int idClinica) throws SQLException {
		pstDelete.setInt(1, idClinica);
		pstDelete.execute();
	}

	public ArrayList<Clinica> selectAll() throws SQLException {
		ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Clinica clinica = new Clinica();
			clinica.setIdClinica(resultSet.getInt("id_clinica"));
			clinica.setNome(resultSet.getString("nome"));
			clinica.setCnpj(resultSet.getString("cnpj"));
			clinica.setTelefone(resultSet.getString("telefone"));
			clinica.setEmail(resultSet.getString("email"));
			clinica.setIdEndereco(resultSet.getInt("id_endereco"));
			clinicas.add(clinica);
		}

		return clinicas;
	}

	public ArrayList<TotalConsultas> selectTotalConsultas() throws SQLException {
		ArrayList<TotalConsultas> consultasPorClinica = new ArrayList<TotalConsultas>();
		ResultSet resultSet = pstTotalConsultasPorClinica.executeQuery();
		while (resultSet.next()) {
			TotalConsultas tc = new TotalConsultas(resultSet.getInt("id_clinica"), resultSet.getString("nome_clinica"),
					resultSet.getInt("total_consultas"));
			consultasPorClinica.add(tc);
		}
		return consultasPorClinica;
	}
}
