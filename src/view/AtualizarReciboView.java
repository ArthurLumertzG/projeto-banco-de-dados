package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ReciboController;
import database.model.Recibo;
import utils.DateLabelFormatter;

public class AtualizarReciboView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JScrollPane scroll;
    private JLabel lblAtualizar;
    private JTextField txfAtualizar;
    private JButton btnAtualizar;
    private JPanel pnlRecibo;
    private JLabel lblidConsulta;
    private JTextField txfidConsulta;
    private JLabel lblvalor;
    private JTextField txfvalor;
    private JTextField txfformaPagamento;
    private JLabel lblformaPagamento;
    private JLabel lbldetalhes;
    private JTextField txfdetalhes;
    private JButton btnenviar;
    private JDatePickerImpl datePicker;

    public AtualizarReciboView() {
        setTitle("Atualizar - Recibo");
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        componentesCriar();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void componentesCriar() {
        lblAtualizar = new JLabel("Id da linha a ser atualizada:");
        lblAtualizar.setBounds(20, 230, 200, 20);
        getContentPane().add(lblAtualizar);

        txfAtualizar = new JTextField();
        txfAtualizar.setBounds(180, 230, 100, 20);
        getContentPane().add(txfAtualizar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(300, 225, 100, 30);
        getContentPane().add(btnAtualizar);

        modelo.addColumn("ID Recibo");
        modelo.addColumn("ID Consulta");
        modelo.addColumn("Valor");
        modelo.addColumn("Data Emissão");
        modelo.addColumn("Forma Pagamento");
        modelo.addColumn("Detalhes");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Recibo> reciboLista = ReciboController.listar();
            for (Recibo recibo : reciboLista) {
                modelo.addRow(new String[] {
                    recibo.getIdReciboAsString(),
                    recibo.getIdConsultaAsString(),
                    recibo.getValorAsString(),
                    recibo.getDataEmissaoAsString(),
                    recibo.getFormaPagamento(),
                    recibo.getDetalhes()
                });
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringId = txfAtualizar.getText().trim();
                if (stringId.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Id inválido.");
                    return;
                }

                Integer id = Integer.parseInt(stringId);

                pnlRecibo = new JPanel();
                pnlRecibo.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Recibo"));
                pnlRecibo.setBounds(0, 300, 700, 350);
                pnlRecibo.setLayout(null);
                getContentPane().add(pnlRecibo);
                getContentPane().revalidate();
                getContentPane().repaint();
                pnlRecibo.setVisible(true);

                lblidConsulta = new JLabel("ID Consulta:");
                lblidConsulta.setBounds(15, 55, 100, 20);
                pnlRecibo.add(lblidConsulta);
                txfidConsulta = new JTextField();
                txfidConsulta.setBounds(120, 55, 100, 20);
                pnlRecibo.add(txfidConsulta);

                lblvalor = new JLabel("Valor:");
                lblvalor.setBounds(15, 85, 100, 20);
                pnlRecibo.add(lblvalor);
                txfvalor = new JTextField();
                txfvalor.setBounds(120, 85, 100, 20);
                pnlRecibo.add(txfvalor);

                JLabel lbldataEmissao = new JLabel("Data de Emissão:");
                lbldataEmissao.setBounds(15, 115, 100, 20);
                pnlRecibo.add(lbldataEmissao);

                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Hoje");
                p.put("text.month", "Mês");
                p.put("text.year", "Ano");

                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.setBounds(150, 115, 130, 20);
                pnlRecibo.add(datePicker);

                lblformaPagamento = new JLabel("Forma Pagamento:");
                lblformaPagamento.setBounds(15, 145, 150, 20);
                pnlRecibo.add(lblformaPagamento);
                txfformaPagamento = new JTextField();
                txfformaPagamento.setBounds(120, 145, 100, 20);
                pnlRecibo.add(txfformaPagamento);

                lbldetalhes = new JLabel("Detalhes:");
                lbldetalhes.setBounds(15, 175, 100, 20);
                pnlRecibo.add(lbldetalhes);
                txfdetalhes = new JTextField();
                txfdetalhes.setBounds(120, 175, 100, 20);
                pnlRecibo.add(txfdetalhes);

                btnenviar = new JButton("Enviar");
                btnenviar.setBounds(270, 200, 100, 25);
                pnlRecibo.add(btnenviar);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String idConsultaStr = txfidConsulta.getText();
                            String valorStr = txfvalor.getText();
                            Object dataEmissao = datePicker.getModel().getValue();
                            String formaPagamento = txfformaPagamento.getText();
                            String detalhes = txfdetalhes.getText();
                            
                            Integer idConsulta = Integer.parseInt(idConsultaStr);
                            Double valor = Double.parseDouble(valorStr);
                            
                            java.util.Date utilDate = (java.util.Date) dataEmissao;
                            Instant instant = utilDate.toInstant();
                            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                            Date dataFormatada = Date.valueOf(localDate);
                            
                            ReciboController.atualizar(id, idConsulta, valor, dataFormatada, formaPagamento, detalhes);
                            JOptionPane.showMessageDialog(rootPane, "Recibo atualizado com sucesso!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar recibo.");
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPane, "ID Consulta e Valor devem ser números válidos.");
                        }
                    }
                });
            }
        });
    }
}