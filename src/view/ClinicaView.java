package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClinicaView extends JFrame {

	private JPanel pnlClinica;

	private JTextField txfidClinica;
	private JLabel lblidClinica;

	private JTextField txfnome;
	private JLabel lblnome;

	private JTextField txfcnpj;
	private JLabel lblcnpj;

	private JTextField txftelefone;
	private JLabel lbltelefone;

	private JTextField txfemail;
	private JLabel lblemail;

	private JTextField txfidEndereco;
	private JLabel lblidEndereco;

	private JButton btnenviar;

	public ClinicaView() {
		setTitle("Clínica Veterinária - Clínica");
		setSize(400, 350);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {
		pnlClinica = new JPanel();
		pnlClinica.setBorder(BorderFactory.createTitledBorder("Cadastro de Clínica"));
		pnlClinica.setBounds(0, 0, 400, 350);
		pnlClinica.setLayout(null);
		getContentPane().add(pnlClinica);

		lblidClinica = new JLabel("ID Clínica:");
		lblidClinica.setBounds(15, 25, 100, 20);
		pnlClinica.add(lblidClinica);
		txfidClinica = new JTextField();
		txfidClinica.setBounds(120, 25, 100, 20);
		pnlClinica.add(txfidClinica);

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 55, 100, 20);
		pnlClinica.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(120, 55, 100, 20);
		pnlClinica.add(txfnome);

		lblcnpj = new JLabel("CNPJ:");
		lblcnpj.setBounds(15, 85, 100, 20);
		pnlClinica.add(lblcnpj);
		txfcnpj = new JTextField();
		txfcnpj.setBounds(120, 85, 100, 20);
		pnlClinica.add(txfcnpj);

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 115, 100, 20);
		pnlClinica.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(120, 115, 100, 20);
		pnlClinica.add(txftelefone);

		lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 145, 100, 20);
		pnlClinica.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(120, 145, 100, 20);
		pnlClinica.add(txfemail);

		lblidEndereco = new JLabel("ID Endereço:");
		lblidEndereco.setBounds(15, 175, 100, 20);
		pnlClinica.add(lblidEndereco);
		txfidEndereco = new JTextField();
		txfidEndereco.setBounds(120, 175, 100, 20);
		pnlClinica.add(txfidEndereco);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(270, 250, 100, 25);
		pnlClinica.add(btnenviar);
	}
}
