package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ClinicaController;
import database.model.Clinica;

public class VisualizarClinicaView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;

	public VisualizarClinicaView() {
		setTitle("Visualizar - Clínica");
		setSize(500, 300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void componentesCriar() {
		modelo = new DefaultTableModel()  {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false; 
				    }
		};
		modelo.addColumn("ID Clínica");
		modelo.addColumn("Nome");
		modelo.addColumn("CNPJ");
		modelo.addColumn("Email");
		modelo.addColumn("Telefone");
		modelo.addColumn("ID Endereço");

		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 460, 240);
		getContentPane().add(scroll);

		try {
			List<Clinica> clinicaLista = ClinicaController.listar();

			for (Clinica clinica : clinicaLista) {
				String idClinica = clinica.getIdClinicaAsString();
				String nome = clinica.getNome();
				String cnpj = clinica.getCnpj();
				String email = clinica.getEmail();
				String telefone = clinica.getTelefone();
				String idEndereco = String.valueOf(clinica.getIdEndereco());

				modelo.addRow(new String[] {
					idClinica, nome, cnpj, email, telefone, idEndereco
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados da clínica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
