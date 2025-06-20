package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Consulta;

public class ConsultaDAO {

	private String selectAll = "SELECT * FROM consulta";
	private String insert = "INSERT INTO consulta(id_veterinario, id_auxiliar, id_pet, data_hora, motivo, diagnostico, tratamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String update = "UPDATE consulta SET id_veterinario = ?, id_auxiliar = ?, id_pet = ?, data_hora = ?, motivo = ?, diagnostico = ?, tratamento = ? WHERE id_consulta = ?";
	private String delete = "DELETE FROM consulta WHERE id_consulta = ?";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

	public ConsultaDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
	}

	public void insert(Consulta consulta) throws SQLException {
		pstInsert.setInt(1, consulta.getIdVeterinario());
		pstInsert.setInt(2, consulta.getIdAuxiliar());
		pstInsert.setInt(3, consulta.getIdPet());
		pstInsert.setDate(4, consulta.getDataHora());
		pstInsert.setString(5, consulta.getMotivo());
		pstInsert.setString(6, consulta.getDiagnostico());
		pstInsert.setString(7, consulta.getTratamento());
		pstInsert.execute();
	}

	public void update(Consulta consulta) throws SQLException {
		pstUpdate.setInt(1, consulta.getIdVeterinario());
		pstUpdate.setInt(2, consulta.getIdAuxiliar());
		pstUpdate.setInt(3, consulta.getIdPet());
		pstUpdate.setDate(4, consulta.getDataHora());
		pstUpdate.setString(5, consulta.getMotivo());
		pstUpdate.setString(6, consulta.getDiagnostico());
		pstUpdate.setString(7, consulta.getTratamento());
		pstUpdate.setInt(8, consulta.getIdConsulta());
		pstUpdate.execute();
	}

	public void delete(int idConsulta) throws SQLException {
		pstDelete.setInt(1, idConsulta);
		pstDelete.execute();
	}

	public ArrayList<Consulta> selectAll() throws SQLException {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Consulta consulta = new Consulta();
			consulta.setIdConsulta(resultSet.getInt("id_consulta"));
			consulta.setIdVeterinario(resultSet.getInt("id_veterinario"));
			consulta.setIdAuxiliar(resultSet.getInt("id_auxiliar"));
			consulta.setIdPet(resultSet.getInt("id_pet"));
			consulta.setDataHora(resultSet.getDate("data_hora"));
			consulta.setMotivo(resultSet.getString("motivo"));
			consulta.setDiagnostico(resultSet.getString("diagnostico"));
			consulta.setTratamento(resultSet.getString("tratamento"));
			consultas.add(consulta);
		}

		return consultas;
	}
}
