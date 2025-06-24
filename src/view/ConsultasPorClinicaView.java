package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import controller.ClinicaController;
import controller.ConsultaController;
import controller.ReciboController;
import database.model.Auxiliar;
import database.model.FaturamentoMensal;
import database.model.TotalConsultas;

public class ConsultasPorClinicaView extends JFrame{

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private String quant;
	private String idClinica;
	private String nome;
	
	public ConsultasPorClinicaView() {
		
		setTitle("Consultas por clínica");
		setSize(400,300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
		
	
	 private void componentesCriar(){
		 modelo = new DefaultTableModel()  {
			    public boolean isCellEditable(int row, int column) {
			        return false; 
			    }
		};
		
		modelo.addColumn("Quantidade");
		modelo.addColumn("ID Clínica");
		modelo.addColumn("Nome Clínica");
		
		
		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 350, 300);
		getContentPane().add(scroll);	
		
		try {
			List<TotalConsultas> consultasLista = ClinicaController.listarTotalConsultas();
			
			for( TotalConsultas consulta : consultasLista ) {
				
				quant = consulta.getTotalConsultasAsString();
				idClinica = consulta.getIdClinicaAsString();
				nome = consulta.getNomeClinica();
				
				modelo.addRow( new String[] { quant, idClinica, nome});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}

}

