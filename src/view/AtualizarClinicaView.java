package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import controller.ClinicaController;
import database.model.Clinica;

public class AtualizarClinicaView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JLabel lblAtualizar;
	private JTextField txfAtualizar;
	private JButton btnAtualizar;

	public AtualizarClinicaView() {
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
		
		lblAtualizar = new JLabel("Id da linha a ser excluida:");
		lblAtualizar.setBounds(20, 230, 200, 20);
		getContentPane().add(lblAtualizar);
		txfAtualizar = new JTextField();
		txfAtualizar.setBounds(180, 230, 100, 20);
		getContentPane().add(txfAtualizar);
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(300, 225, 100, 30);
		getContentPane().add(btnAtualizar);
		btnAtualizar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String StringId = txfAtualizar.getText().trim();
				if(StringId.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					return;
				}
				Integer id = Integer.parseInt(StringId);
				
				try {
					ClinicaController.deletar(id);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					e1.printStackTrace();
				}
			}
		});
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
		
		lblAtualizar = new JLabel("Id da linha a ser excluida:");
		lblAtualizar.setBounds(20, 230, 200, 20);
		getContentPane().add(lblAtualizar);
		txfAtualizar = new JTextField();
		txfAtualizar.setBounds(180, 230, 100, 20);
		getContentPane().add(txfAtualizar);
		btnAtualizar = new JButton("Atualizar");
		btnDeletar.setBounds(300, 230, 95, 30);
		btnDeletar.add(btnDeletar);
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
					ClinicaController.deletar(id);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					e1.printStackTrace();
				}
			}
		});
		
		
		modelo = new DefaultTableModel();modelo = new DefaultTableModel()  {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false; 
			    }
		};

		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 460, 140);
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
