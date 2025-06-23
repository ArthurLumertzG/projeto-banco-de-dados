package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;
import java.util.List;
import java.util.Vector;

import database.model.Consulta;
import database.model.Pet;
import controller.ConsultaController;
import controller.PetController;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ReciboController;
import utils.DateLabelFormatter;

public class AdicionarReciboView extends JFrame {

	private JPanel pnlRecibo;
	private JTextField txfvalor, txfformaPagamento, txfdetalhes;
	private JDatePickerImpl datePicker;
	private JButton btnenviar;
	private JComboBox<Consulta> cbConsulta;

	public AdicionarReciboView() {
		setTitle("Clínica Veterinária - Recibo");
		setSize(400, 260);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		try {
			List<Consulta> listaConsultas = ConsultaController.listar();
			cbConsulta = new JComboBox<>(new Vector<>(listaConsultas));
			cbConsulta.setBounds(15, 45, 100, 20);
			cbConsulta.setRenderer(new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value instanceof Consulta) {
						Consulta consulta = (Consulta) value;

						Pet petConsulta;
						try {
							petConsulta = PetController.buscarPorId(consulta.getIdPet());
							String nomePetConsulta = petConsulta.getNome();

							setText(consulta.getIdConsultaAsString() + " – " + nomePetConsulta + " ("
									+ consulta.getDataHoraAsString() + ")");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return this;
				}
			});
			pnlRecibo.add(cbConsulta);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar consultas:\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

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
				Consulta consultaSelecionada = (Consulta) cbConsulta.getSelectedItem();
				String valorStr = txfvalor.getText().trim();
				Object dateObj = datePicker.getModel().getValue();
				String formaPagamento = txfformaPagamento.getText().trim();
				String detalhes = txfdetalhes.getText().trim();

				if (consultaSelecionada == null) {
					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Selecione uma consulta válida.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					cbConsulta.requestFocus();
					return;
				}

				if (valorStr.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Preencha o campo Valor.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfvalor.requestFocus();
					return;
				}

				if (dateObj == null) {
					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Selecione a Data de Emissão.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (formaPagamento.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Preencha a Forma de Pagamento.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfformaPagamento.requestFocus();
					return;
				}

				if (detalhes.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Preencha o campo Detalhes.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfdetalhes.requestFocus();
					return;
				}

				try {
					int idConsulta = consultaSelecionada.getIdConsulta();
					double valor = Double.parseDouble(valorStr);

					java.util.Date utilDate = (java.util.Date) dateObj;
					Instant instant = utilDate.toInstant();
					LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
					Date dataEmissao = Date.valueOf(localDate);

					ReciboController.inserir(idConsulta, valor, dataEmissao, formaPagamento, detalhes);

					JOptionPane.showMessageDialog(AdicionarReciboView.this, "Recibo cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException ex) {
					javax.swing.JOptionPane.showMessageDialog(AdicionarReciboView.this,
							"Valor ou Id Consulta inválido: " + ex.getMessage(), "Erro de Formato",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				} catch (SQLException ex) {
					javax.swing.JOptionPane.showMessageDialog(AdicionarReciboView.this,
							"Erro ao gravar recibo:\n" + ex.getMessage(), "Erro de Banco",
							javax.swing.JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}

				dispose();
			}
		});
		pnlRecibo.add(btnenviar);
	}
}
