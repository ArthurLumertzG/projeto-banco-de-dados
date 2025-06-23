package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import database.model.Tutor;
import controller.TutorController;
import controller.PetController;
import utils.DateLabelFormatter;

public class AdicionarPetView extends JFrame {

	private JPanel pnlPet;

	private JLabel lblnome;
	private javax.swing.JTextField txfnome;

	private JLabel lbldataNascimento;
	private JDatePickerImpl datePicker; 

	private JLabel lblespecie;
	private javax.swing.JTextField txfespecie;

	private JLabel lblraca;
	private javax.swing.JTextField txfraca;

	private JLabel lblTutor;
	private JComboBox<Tutor> cbTutor;

	private JButton btnenviar;

	public AdicionarPetView() {
		setTitle("Clínica Veterinária - Pet");
		setSize(400, 350);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void createComponent() {
		pnlPet = new JPanel();
		pnlPet.setBorder(BorderFactory.createTitledBorder("Cadastro de Pet"));
		pnlPet.setBounds(0, 0, 400, 350);
		pnlPet.setLayout(null);
		getContentPane().add(pnlPet);

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 25, 120, 20);
		pnlPet.add(lblnome);
		txfnome = new javax.swing.JTextField();
		txfnome.setBounds(150, 25, 200, 20);
		pnlPet.add(txfnome);

		lbldataNascimento = new JLabel("Data de Nascimento:");
		lbldataNascimento.setBounds(15, 55, 120, 20);
		pnlPet.add(lbldataNascimento);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(150, 55, 200, 30);
		pnlPet.add(datePicker);

		lblespecie = new JLabel("Espécie:");
		lblespecie.setBounds(15, 95, 120, 20);
		pnlPet.add(lblespecie);
		txfespecie = new javax.swing.JTextField();
		txfespecie.setBounds(150, 95, 200, 20);
		pnlPet.add(txfespecie);

		lblraca = new JLabel("Raça:");
		lblraca.setBounds(15, 135, 120, 20);
		pnlPet.add(lblraca);
		txfraca = new javax.swing.JTextField();
		txfraca.setBounds(150, 135, 200, 20);
		pnlPet.add(txfraca);

		lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(15, 175, 120, 20);
		pnlPet.add(lblTutor);
		try {
			List<Tutor> listaTutors = TutorController.listar();
			cbTutor = new JComboBox<>(new Vector<>(listaTutors));
			cbTutor.setBounds(150, 175, 200, 20);
			cbTutor.setRenderer(new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value instanceof Tutor) {
						Tutor t = (Tutor) value;
						setText(t.getIdTutor() + " – " + t.getNome());
					}
					return this;
				}
			});
			pnlPet.add(cbTutor);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar tutores:\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		// Botão Enviar
		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(250, 260, 100, 25);
		pnlPet.add(btnenviar);

		btnenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txfnome.getText().trim();
				Object dateValue = datePicker.getModel().getValue();
				String especie = txfespecie.getText().trim();
				String raca = txfraca.getText().trim();
				Tutor tutorSelecionado = (Tutor) cbTutor.getSelectedItem();

				if (nome.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Preencha o campo Nome.", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					txfnome.requestFocus();
					return;
				}
				if (dateValue == null) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Selecione a Data de Nascimento.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (especie.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Preencha o campo Espécie.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfespecie.requestFocus();
					return;
				}
				if (raca.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Preencha o campo Raça.", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					txfraca.requestFocus();
					return;
				}

				if (tutorSelecionado == null) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Selecione um tutor válido.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					cbTutor.requestFocus();
					return;
				}

				try {
					java.util.Date utilDate = (java.util.Date) dateValue;
					Instant instant = utilDate.toInstant();
					LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
					Date dataNascimento = Date.valueOf(localDate);

					int idTutor = tutorSelecionado.getIdTutor();

					PetController.inserir(idTutor, txfnome.getText().trim(), dataNascimento, especie, raca);

					JOptionPane.showMessageDialog(AdicionarPetView.this, "Pet cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(AdicionarPetView.this, "Erro ao salvar pet:\n" + ex.getMessage(),
							"Erro de Banco", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}
}
