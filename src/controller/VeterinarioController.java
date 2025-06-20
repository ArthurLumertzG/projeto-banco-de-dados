package controller;

import java.sql.SQLException;
import java.util.List;

import database.dao.VeterinarioDAO;
import database.model.Veterinario;

public class VeterinarioController {

    private static VeterinarioDAO veterinarioDAO;

    static {
        try {
            veterinarioDAO = new VeterinarioDAO();
        } catch (SQLException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static List<Veterinario> listar() throws SQLException {
        return veterinarioDAO.selectAll();
    }

    public static void inserir(int idClinica, int idEndereco, String nome, String cpf, String crmv, String email, String especialidade, String telefone) throws SQLException {
        Veterinario veterinario = new Veterinario(idClinica, idEndereco, nome, cpf, crmv, email, especialidade, telefone);
        veterinarioDAO.insert(veterinario);
    }

    public static void atualizar(int idClinica, int idEndereco, String nome, String cpf, String crmv, String email, String especialidade, String telefone) throws SQLException {
        Veterinario veterinario = new Veterinario(idClinica, idEndereco, nome, cpf, crmv, email, especialidade, telefone);
        veterinarioDAO.update(veterinario);
    }

    public static void deletar(int idVeterinario) throws SQLException {
        veterinarioDAO.delete(idVeterinario);
    }

    public static Veterinario buscarPorId(int idVeterinario) throws SQLException {
        for (Veterinario veterinario : veterinarioDAO.selectAll()) {
            if (veterinario.getIdVeterinario() == idVeterinario) {
                return veterinario;
            }
        }
        return null;
    }
}
