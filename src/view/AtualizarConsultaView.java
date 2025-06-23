package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ClinicaController;
import controller.ConsultaController;
import database.model.Consulta;
import utils.DateLabelFormatter;

public class AtualizarConsultaView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JLabel lblAtualizar;
	private JTextField txfAtualizar;
	private JButton btnAtualizar;
	protected JPanel pnlConsulta;
	protected JLabel lblidVeterinario;
	protected JTextField txfidVeterinario;
	protected JLabel lblidPet;
	protected JTextField txfidPet;
	protected JLabel lbldataHora;
	protected JTextField txfdataHora;
	protected JTextField txfmotivo;
	protected JLabel lblmotivo;
	protected JLabel lbldiagnostico;
	protected JTextField txfdiagnostico;
	protected JLabel lbltratamento;
	protected JTextField txftratamento;
	protected JButton btnenviar;
	protected JLabel lblidAuxiliar;
	protected JTextField txfidAuxiliar;
	protected JDatePickerImpl datePicker;

	public AtualizarConsultaView() throws Exception {
		
		lblAtualizar = new JLabel("Id da linha a ser atualizada:");
		lblAtualizar.setBounds(20, 230, 200, 20);
		getContentPane().add(lblAtualizar);
		txfAtualizar = new JTextField();
		txfAtualizar.setBounds(180, 230, 100, 20);
		getContentPane().add(txfAtualizar);
		btnAtualizar = new JButton("Selecionar");
		btnAtualizar.setBounds(300, 225, 100, 30);
		getContentPane().add(btnAtualizar);
		
		setTitle("Atualizar - Consultas");
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		componentesCriar();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void componentesCriar() throws Exception {
		modelo = new DefaultTableModel()  {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false; 
				    }
		};
		modelo.addColumn("ID Consulta");
		modelo.addColumn("ID Veterinário");
		modelo.addColumn("ID Auxiliar");
		modelo.addColumn("ID Pet");
		modelo.addColumn("Data/Hora");
		modelo.addColumn("Motivo");
		modelo.addColumn("Diagnóstico");
		modelo.addColumn("Tratamento");

		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 760, 140);
		getContentPane().add(scroll);

		try {
			List<Consulta> consultaLista = ConsultaController.listar();

			for (Consulta consulta : consultaLista) {
				String idConsulta = consulta.getIdConsultaAsString();
				String idVeterinario = consulta.getIdVeterinarioAsString();
				String idAuxiliar = consulta.getIdAuxiliarAsString();
				String idPet = consulta.getIdPetAsString();
				String dataHora = consulta.getDataHoraAsString();
				String motivo = consulta.getMotivo();
				String diagnostico = consulta.getDiagnostico();
				String tratamento = consulta.getTratamento();

				modelo.addRow(new String[] {
					idConsulta, idVeterinario, idAuxiliar, idPet, dataHora, motivo, diagnostico, tratamento
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados da consulta", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		btnAtualizar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String StringId = txfAtualizar.getText().trim();
				if(StringId.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					return;
				}
				Integer id = Integer.parseInt(StringId);
				
				pnlConsulta = new JPanel();
				pnlConsulta.setBorder(BorderFactory.createTitledBorder("Consulta"));
				pnlConsulta.setBounds(0, 300, 700, 380);
				pnlConsulta.setLayout(null);
				getContentPane().add(pnlConsulta);
				getContentPane().revalidate();
                getContentPane().repaint();
                pnlConsulta.setVisible(true);

				lblidVeterinario = new JLabel("ID Veterinário:");
				lblidVeterinario.setBounds(15, 15, 100, 20);
				pnlConsulta.add(lblidVeterinario);
				txfidVeterinario = new JTextField();
				txfidVeterinario.setBounds(15, 35, 100, 20);
				pnlConsulta.add(txfidVeterinario);

				lblidPet = new JLabel("ID Pet:");
				lblidPet.setBounds(15, 60, 100, 20);
				pnlConsulta.add(lblidPet);
				txfidPet = new JTextField();
				txfidPet.setBounds(15, 80, 100, 20);
				pnlConsulta.add(txfidPet);

				JLabel lbldataHora = new JLabel("Data/Hora:");
				lbldataHora.setBounds(200, 60, 100, 20);
				pnlConsulta.add(lbldataHora);

				UtilDateModel model = new UtilDateModel();
				Properties p = new Properties();
				p.put("text.today", "Hoje");
				p.put("text.month", "Mês");
				p.put("text.year", "Ano");

				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
				datePicker.setBounds(200, 80, 130, 30);
				pnlConsulta.add(datePicker);

				lblmotivo = new JLabel("Motivo:");
				lblmotivo.setBounds(15, 105, 100, 20);
				pnlConsulta.add(lblmotivo);
				txfmotivo = new JTextField();
				txfmotivo.setBounds(15, 125, 100, 20);
				pnlConsulta.add(txfmotivo);

				lbldiagnostico = new JLabel("Diagnóstico:");
				lbldiagnostico.setBounds(15, 150, 100, 20);
				pnlConsulta.add(lbldiagnostico);
				txfdiagnostico = new JTextField();
				txfdiagnostico.setBounds(15, 170, 100, 20);
				pnlConsulta.add(txfdiagnostico);

				lbltratamento = new JLabel("Tratamento:");
				lbltratamento.setBounds(15, 195, 100, 20);
				pnlConsulta.add(lbltratamento);
				txftratamento = new JTextField();
				txftratamento.setBounds(15, 215, 100, 20);
				pnlConsulta.add(txftratamento);

				lblidAuxiliar = new JLabel("ID auxiliar:");
				lblidAuxiliar.setBounds(200, 105, 100, 20);
				pnlConsulta.add(lblidAuxiliar);
				txfidAuxiliar = new JTextField();
				txfidAuxiliar.setBounds(200, 125, 100, 20);
				pnlConsulta.add(txfidAuxiliar);
				
				btnenviar = new JButton("Enviar");
				btnenviar.setBounds(150, 215, 100, 25);
				pnlConsulta.add(btnenviar);
				
				btnenviar.addActionListener( new ActionListener() {
					
					private int idVeterinario;
					private int idAuxiliar;
					private int idPet;
					private Date dataHora;
					private String motivo;
					private String diagnostico;
					private String tratamento;
					private int idEndereco;

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							idVeterinario = Integer.parseInt(txfidVeterinario.getText());
							idAuxiliar = Integer.parseInt(txfidAuxiliar.getText());
							idPet = Integer.parseInt(txfidPet.getText());
							Object dateObj = datePicker.getModel().getValue();
							motivo = txfmotivo.getText();
							diagnostico = txfdiagnostico.getText();
							tratamento = txftratamento.getText();
							ConsultaController.atualizar(id, idVeterinario, idAuxiliar, idPet, dataHora,
							 motivo, diagnostico, tratamento);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				});
			}
		});
	}
}
