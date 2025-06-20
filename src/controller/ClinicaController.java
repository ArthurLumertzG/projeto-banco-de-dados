package controller;

import java.sql.SQLException;
import java.util.List;

import database.dao.ClinicaDAO;
import database.model.Clinica;

public class ClinicaController {

    private static ClinicaDAO clinicaDAO;

    static {
        try {
            clinicaDAO = new ClinicaDAO();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static List<Clinica> listar() throws SQLException {
        return clinicaDAO.selectAll();
    }

    public static void inserir(String nome, String cnpj, String telefone, String email, int idEndereco) throws SQLException {
        Clinica clinica = new Clinica(nome, cnpj, telefone, email, idEndereco);
        clinicaDAO.insert(clinica);
    }

    public static void atualizar(String nome, String cnpj, String telefone, String email, int idEndereco) throws SQLException {
        Clinica clinica = new Clinica(nome, cnpj, telefone, email, idEndereco);
        clinicaDAO.update(clinica);
    }

    public static void deletar(int idClinica) throws SQLException {
        clinicaDAO.delete(idClinica);
    }

    public static Clinica buscarPorId(int idClinica) throws SQLException {
        for (Clinica c : clinicaDAO.selectAll()) {
            if (c.getIdClinica() == idClinica) {
                return c;
            }
        }
        return null;
    }
}
