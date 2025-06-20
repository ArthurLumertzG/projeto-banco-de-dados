package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import database.model.Pet;

public class PetDAO {

	private String selectAll = "SELECT * FROM pet";
	private String insert = "INSERT INTO pet(nome, data_nascimento, especie, raca, id_tutor) VALUES (?, ?, ?, ?, ?)";
	private String update = "UPDATE pet SET nome = ?, data_nascimento = ?, especie = ?, raca = ?, id_tutor = ? WHERE id_pet = ?";
	private String delete = "DELETE FROM pet WHERE id_pet = ?";

	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

	public PetDAO() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		pstSelectAll = connection.prepareStatement(selectAll);
		pstInsert = connection.prepareStatement(insert);
		pstUpdate = connection.prepareStatement(update);
		pstDelete = connection.prepareStatement(delete);
	}

	public void insert(Pet pet) throws SQLException {
		pstInsert.setString(1, pet.getNome());
		pstInsert.setDate(2, pet.getDataNascimento());
		pstInsert.setString(3, pet.getEspecie());
		pstInsert.setString(4, pet.getRaca());
		pstInsert.setInt(5, pet.getIdTutor());
		pstInsert.execute();
	}

	public void update(Pet pet) throws SQLException {
		pstUpdate.setString(1, pet.getNome());
		pstUpdate.setDate(2, pet.getDataNascimento());
		pstUpdate.setString(3, pet.getEspecie());
		pstUpdate.setString(4, pet.getRaca());
		pstUpdate.setInt(5, pet.getIdTutor());
		pstUpdate.setInt(6, pet.getIdPet());
		pstUpdate.execute();
	}

	public void delete(int idPet) throws SQLException {
		pstDelete.setInt(1, idPet);
		pstDelete.execute();
	}

	public ArrayList<Pet> selectAll() throws SQLException {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		ResultSet resultSet = pstSelectAll.executeQuery();

		while (resultSet.next()) {
			Pet pet = new Pet();
			pet.setIdPet(resultSet.getInt("id_pet"));
			pet.setNome(resultSet.getString("nome"));
			pet.setDataNascimento(resultSet.getDate("data_nascimento"));
			pet.setEspecie(resultSet.getString("especie"));
			pet.setRaca(resultSet.getString("raca"));
			pet.setIdTutor(resultSet.getInt("id_tutor"));
			pets.add(pet);
		}

		return pets;
	}
}
