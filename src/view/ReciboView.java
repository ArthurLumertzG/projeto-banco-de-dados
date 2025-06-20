package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ReciboController;
import utils.DateLabelFormatter;

public class ReciboView extends JFrame {

    private JPanel pnlRecibo;
    private JTextField txfidConsulta, txfvalor, txfformaPagamento, txfdetalhes;
    private JDatePickerImpl datePicker;
    private JButton btnenviar;

    public ReciboView() {
        setTitle("Clínica Veterinária");
        setSize(400, 260);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponent();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        pnlRecibo = new JPanel();
        pnlRecibo.setBorder(BorderFactory.createTitledBorder("Recibo"));
        pnlRecibo.setBounds(0, 0, 400, 260);
        pnlRecibo.setLayout(null);
        getContentPane().add(pnlRecibo);

        JLabel lblidConsulta = new JLabel("Id Consulta:");
        lblidConsulta.setBounds(15, 25, 100, 20);
        pnlRecibo.add(lblidConsulta);
        txfidConsulta = new JTextField();
        txfidConsulta.setBounds(15, 45, 100, 20);
        pnlRecibo.add(txfidConsulta);

        JLabel lblvalor = new JLabel("Valor:");
        lblvalor.setBounds(15, 75, 100, 20);
        pnlRecibo.add(lblvalor);
        txfvalor = new JTextField();
        txfvalor.setBounds(15, 95, 100, 20);
        pnlRecibo.add(txfvalor);
        
        JLabel lblformaPagamento = new JLabel("Forma de Pagamento:");
        lblformaPagamento.setBounds(180, 75, 150, 20);
        pnlRecibo.add(lblformaPagamento);
        txfformaPagamento = new JTextField();
        txfformaPagamento.setBounds(180, 95, 100, 20);
        pnlRecibo.add(txfformaPagamento);

        JLabel lbldataEmissao = new JLabel("Data de emissão:");
        lbldataEmissao.setBounds(15, 125, 100, 20);
        pnlRecibo.add(lbldataEmissao);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(15, 145, 200, 30);
        pnlRecibo.add(datePicker);

        JLabel lbldetalhes = new JLabel("Detalhes:");
        lbldetalhes.setBounds(180, 25, 100, 20);
        pnlRecibo.add(lbldetalhes);
        txfdetalhes = new JTextField();
        txfdetalhes.setBounds(180, 45, 100, 20);
        pnlRecibo.add(txfdetalhes);

        btnenviar = new JButton("Enviar");
        btnenviar.setBounds(150, 180, 100, 25);
        btnenviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idConsulta = Integer.parseInt(txfidConsulta.getText());
                    double valor = Double.parseDouble(txfvalor.getText());

                    Object obj = datePicker.getModel().getValue();
                    java.util.Date utilDate = (java.util.Date) obj;
                    Instant instant = utilDate.toInstant();
                    LocalDate local = instant.atZone(ZoneId.systemDefault()).toLocalDate();

                    Date dataEmissao = Date.valueOf(local); 

                    String formaPagamento = txfformaPagamento.getText();
                    String detalhes = txfdetalhes.getText();
                    
                    ReciboController.inserir(idConsulta, valor, dataEmissao, formaPagamento, detalhes);

                } catch (NumberFormatException ex) {
                    System.err.println("Erro ao converter número: " + ex.getMessage());
                } catch (IllegalArgumentException ex) {
                    System.err.println("Entrada inválida: " + ex.getMessage());
                } catch (SQLException eSQL) {
					eSQL.printStackTrace();
				}
                
                dispose();
            }
        });
        pnlRecibo.add(btnenviar);
    }
}
