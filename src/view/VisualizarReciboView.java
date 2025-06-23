package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ReciboController;
import database.model.Recibo;

public class VisualizarReciboView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public VisualizarReciboView() {
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
        scroll.setBounds(10, 10, 420, 250);
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
