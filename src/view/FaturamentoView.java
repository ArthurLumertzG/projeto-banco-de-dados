package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import controller.ReciboController;
import database.model.Auxiliar;
import database.model.FaturamentoMensal;

public class FaturamentoView extends JFrame{

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	
	public FaturamentoView() {
		
		setTitle("Faturamento mensal");
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
		
		modelo.addColumn("Valor");
		modelo.addColumn("Mês");
		
		
		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 350, 300);
		getContentPane().add(scroll);	
		
		try {
			List<FaturamentoMensal> faturamentoLista = ReciboController.faturamentoMensal();
			
			for( FaturamentoMensal faturamento : faturamentoLista ) {
				String mes;
				String valor;
				mes = faturamento.getMes();
				valor = faturamento.getFaturamentoMensalAsString();
				modelo.addRow( new String[] { valor, mes});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}

}
