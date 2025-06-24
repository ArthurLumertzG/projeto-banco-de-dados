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
import database.model.TotalConsultasMes;

public class ConsultasPorMesView extends JFrame{

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private String quant;
	private String mes;
	
	public ConsultasPorMesView() throws Exception {
		
		setTitle("Consultas por mês");
		setSize(400,300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
		
	
	 private void componentesCriar() throws Exception{
		 modelo = new DefaultTableModel()  {
			    public boolean isCellEditable(int row, int column) {
			        return false; 
			    }
		};
		
		modelo.addColumn("Quantidade");
		modelo.addColumn("Mês");
		
		
		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 350, 300);
		getContentPane().add(scroll);	
		
		try {
			List<TotalConsultasMes> consultasPorMesLista = ConsultaController.listarTotalConsultasMes();
			
			for( TotalConsultasMes consulta : consultasPorMesLista ) {
				
				quant = consulta.getTotalConsultasMesAsString();
				mes = consulta.getMes();
				modelo.addRow( new String[] { quant, mes});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}

}

