package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuxiliarView extends JFrame {

	private JPanel pnlAuxiliar;
	private JTextField txfnome;
	private JLabel lblnome;
	private JTextField txfcpf;
	private JLabel lblcpf;
	private JTextField txftelefone;
	private JLabel lbltelefone;
	private JTextField txfidClinica;
	private JLabel lblidClinica;
	private JTextField txfemail;
	private JLabel lblemail;
	private JTextField txfcrmv;
	private JLabel lblcrmv;
	private JTextField txfidEndereco;
	private JLabel lblidEndereco;
	private JButton btnenviar;

	public AuxiliarView() {
		setTitle("Clínica Veterinária");
		setSize(400, 300);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {

		pnlAuxiliar = new JPanel();
		pnlAuxiliar.setBorder(BorderFactory.createTitledBorder("Auxiliar"));
		pnlAuxiliar.setBounds(0, 0, 400, 300);
		pnlAuxiliar.setLayout(null);
		getContentPane().add(pnlAuxiliar);

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 15, 100, 20);
		pnlAuxiliar.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(15, 35, 150, 20);
		pnlAuxiliar.add(txfnome);

		lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(15, 60, 100, 20);
		pnlAuxiliar.add(lblcpf);
		txfcpf = new JTextField();
		txfcpf.setBounds(15, 80, 150, 20);
		pnlAuxiliar.add(txfcpf);

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 105, 100, 20);
		pnlAuxiliar.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(15, 125, 150, 20);
		pnlAuxiliar.add(txftelefone);

		lblidClinica = new JLabel("ID Clínica:");
		lblidClinica.setBounds(200, 15, 100, 20);
		pnlAuxiliar.add(lblidClinica);
		txfidClinica = new JTextField();
		txfidClinica.setBounds(200, 35, 150, 20);
		pnlAuxiliar.add(txfidClinica);

		lblemail = new JLabel("Email:");
		lblemail.setBounds(200, 60, 100, 20);
		pnlAuxiliar.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(200, 80, 150, 20);
		pnlAuxiliar.add(txfemail);

		lblcrmv = new JLabel("CRMV:");
		lblcrmv.setBounds(200, 105, 100, 20);
		pnlAuxiliar.add(lblcrmv);
		txfcrmv = new JTextField();
		txfcrmv.setBounds(200, 125, 150, 20);
		pnlAuxiliar.add(txfcrmv);

		lblidEndereco = new JLabel("ID Endereço:");
		lblidEndereco.setBounds(15, 150, 100, 20);
		pnlAuxiliar.add(lblidEndereco);
		txfidEndereco = new JTextField();
		txfidEndereco.setBounds(15, 170, 150, 20);
		pnlAuxiliar.add(txfidEndereco);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(150, 220, 100, 25);
		pnlAuxiliar.add(btnenviar);
	}
}
