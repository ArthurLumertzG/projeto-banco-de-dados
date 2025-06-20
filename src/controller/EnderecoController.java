package controller;

import java.sql.SQLException;
import java.util.List;

import database.dao.EnderecoDAO;
import database.model.Endereco;

public class EnderecoController {

    private static EnderecoDAO enderecoDAO;

    static {
        try {
            enderecoDAO = new EnderecoDAO();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static List<Endereco> listar() throws SQLException {
        return enderecoDAO.selectAll();
    }

    public static void inserir(String cep, String rua, String numero, String bairro, String cidade, String estado, String complemento) throws SQLException {
        Endereco endereco = new Endereco(0, cep, rua, numero, bairro, cidade, estado, complemento);
        enderecoDAO.insert(endereco);
    }

    public static void atualizar(int idEndereco, String cep, String rua, String numero, String bairro, String cidade, String estado, String complemento) throws SQLException {
        Endereco endereco = new Endereco(idEndereco, cep, rua, numero, bairro, cidade, estado, complemento);
        enderecoDAO.update(endereco);
    }

    public static void deletar(int idEndereco) throws SQLException {
        enderecoDAO.delete(idEndereco);
    }

    public static Endereco buscarPorId(int idEndereco) throws SQLException {
        for (Endereco endereco : enderecoDAO.selectAll()) {
            if (endereco.getIdEndereco() == idEndereco) {
                return endereco;
            }
        }
        return null;
    }
}