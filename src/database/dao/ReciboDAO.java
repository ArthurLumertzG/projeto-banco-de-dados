package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Recibo;

public class ReciboDAO {

	private String selectAll = "SELECT * FROM recibo";
	private String insert = "INSERT INTO recibo(id_consulta, valor, data_emissao, forma_pagamento, detalhes) VALUES (?, ?, ?, ?, ?)";
	private String update = "UPDATE recibo SET id_consulta = ?, valor = ?, data_emissao = ?, forma_pagamento = ?, detalhes = ? WHERE id_recibo = ?";
	private String delete = "DELETE FROM recibo WHERE id_recibo = ?";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

	public ReciboDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
	}

	public void insert(Recibo recibo) throws SQLException {
		pstInsert.setInt(1, recibo.getIdConsulta());
		pstInsert.setDouble(2, recibo.getValor());
		pstInsert.setDate(3, recibo.getDataEmissao());
		pstInsert.setString(4, recibo.getFormaPagamento());
		pstInsert.setString(5, recibo.getDetalhes());
		pstInsert.execute();
	}

	public void update(Recibo recibo) throws SQLException {
		pstUpdate.setInt(1, recibo.getIdConsulta());
		pstUpdate.setDouble(2, recibo.getValor());
		pstUpdate.setDate(3, recibo.getDataEmissao());
		pstUpdate.setString(4, recibo.getFormaPagamento());
		pstUpdate.setString(5, recibo.getDetalhes());
		pstUpdate.setInt(6, recibo.getIdRecibo());
		pstUpdate.execute();
	}

	public void delete(int idRecibo) throws SQLException {
		pstDelete.setInt(1, idRecibo);
		pstDelete.execute();
	}

	public ArrayList<Recibo> selectAll() throws SQLException {
		ArrayList<Recibo> recibos = new ArrayList<Recibo>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Recibo recibo = new Recibo();
			recibo.setIdRecibo(resultSet.getInt("id_recibo"));
			recibo.setIdConsulta(resultSet.getInt("id_consulta"));
			recibo.setValor(resultSet.getDouble("valor"));
			recibo.setDataEmissao(resultSet.getDate("data_emissao"));
			recibo.setFormaPagamento(resultSet.getString("forma_pagamento"));
			recibo.setDetalhes(resultSet.getString("detalhes"));
			recibos.add(recibo);
		}

		return recibos;
	}
}
