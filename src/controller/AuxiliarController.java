package controller;

import java.sql.SQLException;
import java.util.List;

import database.dao.AuxiliarDAO;
import database.model.Auxiliar;

public class AuxiliarController {

    private static AuxiliarDAO auxiliarDAO;

    static {
        try {
            auxiliarDAO = new AuxiliarDAO();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static List<Auxiliar> listar() throws SQLException {
        return auxiliarDAO.selectAll();
    }

    public static void inserir(String nome, String cpf, String crmv, String email, int idClinica, String telefone, int idEndereco) throws SQLException {
        Auxiliar auxiliar = new Auxiliar(nome, cpf, crmv, email, idClinica, telefone, idEndereco);
        auxiliarDAO.insert(auxiliar);
    }

    public static void atualizar(int idAuxiliar, String nome, String cpf, String crmv, String email, int idClinica, String telefone, int idEndereco) throws SQLException {
        Auxiliar auxiliar = new Auxiliar(idAuxiliar, nome, cpf, crmv, email, idClinica, telefone, idEndereco);
        auxiliarDAO.update(auxiliar);
    }

    public static void deletar(int idAuxiliar) throws SQLException {
        auxiliarDAO.delete(idAuxiliar);
    }

    public static Auxiliar buscarPorId(int idAuxiliar) throws SQLException {
        for (Auxiliar auxiliar : auxiliarDAO.selectAll()) {
            if (auxiliar.getIdAuxiliar() == idAuxiliar) {
                return auxiliar;
            }
        }
        return null;
    }
}
