package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import database.dao.AuxiliarDAO;
import database.model.Auxiliar;

public class VisualizarAuxiliarView extends JFrame{
		
		private JTable tabela;
		private DefaultTableModel modelo;
		private JScrollPane scroll;
		
		public VisualizarAuxiliarView() {
			
			setTitle("Visualizar - Auxiliar");
			setSize(700,300);
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
			scroll.setBounds(10, 10, 650, 300);
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
