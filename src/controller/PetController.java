package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import database.dao.PetDAO;
import database.model.Pet;

public class PetController {

    private static PetDAO petDAO;

    static {
        try {
            petDAO = new PetDAO();
        } catch (SQLException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static List<Pet> listar() throws SQLException {
        return petDAO.selectAll();
    }

    public static void inserir(int idTutor, String nome, Date dataNascimento, String especie, String raca) throws SQLException {
        Pet pet = new Pet(idTutor, nome, dataNascimento, especie, raca);
        petDAO.insert(pet);
    }

    public static void atualizar(int idTutor, String nome, Date dataNascimento, String especie, String raca) throws SQLException {
        Pet pet = new Pet(idTutor, nome, dataNascimento, especie, raca);
        petDAO.update(pet);
    }

    public static void deletar(int idPet) throws SQLException {
        petDAO.delete(idPet);
    }

    public static Pet buscarPorId(int idPet) throws SQLException {
        for (Pet pet : petDAO.selectAll()) {
            if (pet.getIdPet() == idPet) {
                return pet;
            }
        }
        return null;
    }
}
