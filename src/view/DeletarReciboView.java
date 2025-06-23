package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ReciboController;
import database.model.Recibo;

public class DeletarReciboView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
	private JLabel lblDeletar;
	private JTextField txfDeletar;
	private JButton btnDeletar;

    public DeletarReciboView() {
        setTitle("Visualizar - Recibo");
        setSize(450, 300);
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
						ReciboController.deletar(id);
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
        modelo.addColumn("ID Recibo");
        modelo.addColumn("ID Consulta");
        modelo.addColumn("Valor");
        modelo.addColumn("Data Emissão");
        modelo.addColumn("Forma de Pagamento");
        modelo.addColumn("Detalhes");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 420, 150);
        getContentPane().add(scroll);

        try {
            List<Recibo> reciboLista = ReciboController.listar();

            for (Recibo recibo : reciboLista) {
                String idRecibo = recibo.getIdReciboAsString();
                String idConsulta = recibo.getIdConsultaAsString();
                String valor = recibo.getValorAsString();
                String dataEmissao = recibo.getDataEmissaoAsString();
                String formaPagamento = recibo.getFormaPagamento();
                String detalhes = recibo.getDetalhes();

                modelo.addRow(new String[]{
                    idRecibo, idConsulta, valor, dataEmissao, formaPagamento, detalhes
                });
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
