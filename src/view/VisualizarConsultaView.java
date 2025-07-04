package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ConsultaController;
import database.model.Consulta;

public class VisualizarConsultaView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;

	public VisualizarConsultaView() throws Exception {
		setTitle("Visualizar - Consultas");
		setSize(800, 300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void componentesCriar() throws Exception {
		modelo = new DefaultTableModel()  {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false; 
				    }
		};
		modelo.addColumn("ID Consulta");
		modelo.addColumn("ID Veterinário");
		modelo.addColumn("ID Auxiliar");
		modelo.addColumn("ID Pet");
		modelo.addColumn("Data/Hora");
		modelo.addColumn("Motivo");
		modelo.addColumn("Diagnóstico");
		modelo.addColumn("Tratamento");

		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 760, 240);
		getContentPane().add(scroll);

		try {
			List<Consulta> consultaLista = ConsultaController.listar();

			for (Consulta consulta : consultaLista) {
				String idConsulta = consulta.getIdConsultaAsString();
				String idVeterinario = consulta.getIdVeterinarioAsString();
				String idAuxiliar = consulta.getIdAuxiliarAsString();
				String idPet = consulta.getIdPetAsString();
				String dataHora = consulta.getDataHoraAsString();
				String motivo = consulta.getMotivo();
				String diagnostico = consulta.getDiagnostico();
				String tratamento = consulta.getTratamento();

				modelo.addRow(new String[] {
					idConsulta, idVeterinario, idAuxiliar, idPet, dataHora, motivo, diagnostico, tratamento
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados da consulta", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
