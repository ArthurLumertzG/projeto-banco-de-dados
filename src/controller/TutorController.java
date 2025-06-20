package controller;

import java.sql.SQLException;
import java.util.List;

import database.dao.TutorDAO;
import database.model.Tutor;

public class TutorController {

    private static TutorDAO tutorDAO;

    static {
        try {
            tutorDAO = new TutorDAO();
        } catch (SQLException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static List<Tutor> listar() throws SQLException {
        return tutorDAO.selectAll();
    }

    public static void inserir(String nome, String cpf, String email, String telefone, int idEndereco) throws SQLException {
        Tutor tutor = new Tutor(nome, cpf, email, telefone, idEndereco);
        tutorDAO.insert(tutor);
    }

    public static void atualizar(String nome, String cpf, String email, String telefone, int idEndereco) throws SQLException {
        Tutor tutor = new Tutor(nome, cpf, email, telefone, idEndereco);
        tutorDAO.update(tutor);
    }

    public static void deletar(int idTutor) throws SQLException {
        tutorDAO.delete(idTutor);
    }

    public static Tutor buscarPorId(int idTutor) throws SQLException {
        for (Tutor tutor : tutorDAO.selectAll()) {
            if (tutor.getIdTutor() == idTutor) {
                return tutor;
            }
        }
        return null;
    }
}
