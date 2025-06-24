package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import database.dao.AuxiliarDAO;
import database.model.Auxiliar;

public class DeletarAuxiliarView extends JFrame{
		
		private JTable tabela;
		private DefaultTableModel modelo;
		private JScrollPane scroll;
		private JLabel lblDeletar;
		private JTextField txfDeletar;
		private JButton btnDeletar;
		
		public DeletarAuxiliarView() {
			
			setTitle("Deletar - Auxiliar");
			setSize(700,300);
			setLayout(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			componentesCriar();
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
		}
		
		private void componentesCriar() {
			
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
						AuxiliarController.deletar(id);
						JOptionPane.showMessageDialog(rootPane, "Deletado com sucesso!");
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
			modelo.addColumn("ID");
			modelo.addColumn("ID Clínica");
			modelo.addColumn("ID Endereco");
			modelo.addColumn("Nome");
			modelo.addColumn("CPF");
			modelo.addColumn("Email");
			modelo.addColumn("Telefone");
			modelo.addColumn("CRMV");
			
			
			tabela = new JTable(modelo);
			scroll = new JScrollPane(tabela);
			scroll.setBounds(10, 10, 650, 200);
			getContentPane().add(scroll);	
			
			try {
				List<Auxiliar> auxiliarLista = AuxiliarController.listar();
				
				for( Auxiliar auxiliar : auxiliarLista ) {
					
					String idAuxiliar = auxiliar.getIdAuxiliarAsString();
					String idClinica = auxiliar.getIdClinicaAsString();
					String idEndereco = auxiliar.getIdEnderecoAsString();
					String nome = auxiliar.getNome();
					String cpf = auxiliar.getCpf();
					String email = auxiliar.getEmail();
					String telefone = auxiliar.getTelefone();
					String crmv = auxiliar.getCrmv();
					
					modelo.addRow( new String[] {idAuxiliar, idClinica, idEndereco, nome, cpf, email, telefone, crmv});
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
	

}
