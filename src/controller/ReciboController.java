package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import database.dao.ReciboDAO;
import database.model.Recibo;

public class ReciboController {

    private static ReciboDAO reciboDAO;

    static {
        try {
            reciboDAO = new ReciboDAO();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static List<Recibo> listar() throws SQLException {
        return reciboDAO.selectAll();
    }

    public static void inserir(int idConsulta, double valor, Date dataEmissao, String formaPagamento, String detalhes) throws SQLException {
        Recibo recibo = new Recibo(idConsulta, valor, dataEmissao, formaPagamento, detalhes);
        reciboDAO.insert(recibo);
    }

    public static void atualizar(int idConsulta, double valor, Date dataEmissao, String formaPagamento, String detalhes) throws SQLException {
        Recibo recibo = new Recibo(idConsulta, valor, dataEmissao, formaPagamento, detalhes);
        reciboDAO.update(recibo);
    }

    public static void deletar(int idRecibo) throws SQLException {
        reciboDAO.delete(idRecibo);
    }

    public static Recibo buscarPorId(int idRecibo) throws SQLException {
        for (Recibo recibo : reciboDAO.selectAll()) {
            if (recibo.getIdRecibo() == idRecibo) {
                return recibo;
            }
        }
        return null;
    }
}
