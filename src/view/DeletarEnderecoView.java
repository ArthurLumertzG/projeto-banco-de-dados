package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ConsultaController;
import controller.EnderecoController;
import database.model.Consulta;
import database.model.Endereco;

public class DeletarEnderecoView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JLabel lblDeletar;
	private JTextField txfDeletar;
	private JButton btnDeletar;
	
	public DeletarEnderecoView() throws Exception {
		
		lblDeletar = new JLabel("Id da linha a ser excluida:");
		lblDeletar.setBounds(20, 230, 200, 20);
		getContentPane().add(lblDeletar);
		txfDeletar = new JTextField();
		txfDeletar.setBounds(180, 230, 100, 20);
		getContentPane().add(txfDeletar);
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(300, 225, 100, 30);
		getContentPane().add(btnDeletar);
		btnDeletar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String StringId = txfDeletar.getText().trim();
				if(StringId.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					return;
				}
				Integer id = Integer.parseInt(StringId);
				
				try {
					EnderecoController.deletar(id);
					JOptionPane.showMessageDialog(rootPane, "Deletado com sucesso!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido.");
					e1.printStackTrace();
				} 
			}
		});
		
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
		modelo = new DefaultTableModel()  {
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
		scroll.setBounds(10, 10, 760, 140);
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