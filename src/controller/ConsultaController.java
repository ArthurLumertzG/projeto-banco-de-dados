package controller;

import java.sql.Date;
import java.util.List;

import database.dao.ConsultaDAO;
import database.model.Consulta;

public class ConsultaController {

    private static ConsultaDAO consultaDAO;

    static {
        try {
            consultaDAO = new ConsultaDAO();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static List<Consulta> listar() throws Exception {
        return consultaDAO.selectAll();
    }

    public static void inserir(int idVeterinario, int idAuxiliar, int idPet, Date dataHora, String motivo, String diagnostico, String tratamento) throws Exception {
        Consulta consulta = new Consulta(idVeterinario, idAuxiliar, idPet, dataHora, motivo, diagnostico, tratamento);
        consultaDAO.insert(consulta);
    }

    public static void atualizar(int idConsulta, int idVeterinario, int idAuxiliar, int idPet, Date dataHora, String motivo, String diagnostico, String tratamento) throws Exception {
        Consulta consulta = new Consulta(idConsulta, idVeterinario, idAuxiliar, idPet, dataHora, motivo, diagnostico, tratamento);
        consultaDAO.update(consulta);
    }

    public static void deletar(int idConsulta) throws Exception {
        consultaDAO.delete(idConsulta);
    }

    public static Consulta buscarPorId(int idConsulta) throws Exception {
        for (Consulta consulta : consultaDAO.selectAll()) {
            if (consulta.getIdConsulta() == idConsulta) {
                return consulta;
            }
        }
        return null;
    }
}
