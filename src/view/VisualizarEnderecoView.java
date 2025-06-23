package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ConsultaController;
import controller.EnderecoController;
import database.model.Consulta;
import database.model.Endereco;

public class VisualizarEnderecoView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;

	public VisualizarEnderecoView() throws Exception {
		setTitle("Visualizar - Endereço");
		setSize(800, 300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void componentesCriar() throws Exception {
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelo.addColumn("ID Endereço");
		modelo.addColumn("CEP");
		modelo.addColumn("Rua");
		modelo.addColumn("Número");
		modelo.addColumn("Bairro");
		modelo.addColumn("Cidade");
		modelo.addColumn("Estado");
		modelo.addColumn("Complemento");

		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 760, 240);
		getContentPane().add(scroll);

		try {
			List<Endereco> enderecoLista = EnderecoController.listar();

			for (Endereco endereco : enderecoLista) {
				String idEndereco = endereco.getIdEnderecoAsString();
				String cep = endereco.getCep();
				String rua = endereco.getRua();
				String numero = endereco.getNumero();
				String bairro = endereco.getBairro();
				String cidade = endereco.getCidade();
				String estado = endereco.getEstado();
				String complemento = endereco.getComplemento();

				modelo.addRow(new String[] { idEndereco, cep, rua, numero, 
						bairro, cidade, estado, complemento});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados da consulta", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}