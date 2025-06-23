package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarVeterinarioView extends JFrame {

	private JPanel pnlVeterinario;

	private JTextField txfidVeterinario;
	private JLabel lblidVeterinario;

	private JTextField txfnome;
	private JLabel lblnome;

	private JTextField txfidClinica;
	private JLabel lblidClinica;

	private JTextField txfcpf;
	private JLabel lblcpf;

	private JTextField txfcrmv;
	private JLabel lblcrmv;

	private JTextField txfemail;
	private JLabel lblemail;

	private JTextField txfespecialidade;
	private JLabel lblespecialidade;

	private JTextField txftelefone;
	private JLabel lbltelefone;

	private JTextField txfidEndereco;
	private JLabel lblidEndereco;

	private JButton btnenviar;

	public AdicionarVeterinarioView() {
		setTitle("Clínica Veterinária - Veterinário");
		setSize(450, 450);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {
		pnlVeterinario = new JPanel();
		pnlVeterinario.setBorder(BorderFactory.createTitledBorder("Cadastro de Veterinário"));
		pnlVeterinario.setBounds(0, 0, 450, 450);
		pnlVeterinario.setLayout(null);
		getContentPane().add(pnlVeterinario);

		lblidVeterinario = new JLabel("ID Veterinário:");
		lblidVeterinario.setBounds(15, 25, 100, 20);
		pnlVeterinario.add(lblidVeterinario);
		txfidVeterinario = new JTextField();
		txfidVeterinario.setBounds(130, 25, 100, 20);
		pnlVeterinario.add(txfidVeterinario);

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 55, 100, 20);
		pnlVeterinario.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(130, 55, 100, 20);
		pnlVeterinario.add(txfnome);

		lblidClinica = new JLabel("ID Clínica:");
		lblidClinica.setBounds(15, 85, 100, 20);
		pnlVeterinario.add(lblidClinica);
		txfidClinica = new JTextField();
		txfidClinica.setBounds(130, 85, 100, 20);
		pnlVeterinario.add(txfidClinica);

		lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(15, 115, 100, 20);
		pnlVeterinario.add(lblcpf);
		txfcpf = new JTextField();
		txfcpf.setBounds(130, 115, 100, 20);
		pnlVeterinario.add(txfcpf);

		lblcrmv = new JLabel("CRMV:");
		lblcrmv.setBounds(15, 145, 100, 20);
		pnlVeterinario.add(lblcrmv);
		txfcrmv = new JTextField();
		txfcrmv.setBounds(130, 145, 100, 20);
		pnlVeterinario.add(txfcrmv);

		lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 175, 100, 20);
		pnlVeterinario.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(130, 175, 100, 20);
		pnlVeterinario.add(txfemail);

		lblespecialidade = new JLabel("Especialidade:");
		lblespecialidade.setBounds(15, 205, 100, 20);
		pnlVeterinario.add(lblespecialidade);
		txfespecialidade = new JTextField();
		txfespecialidade.setBounds(130, 205, 100, 20);
		pnlVeterinario.add(txfespecialidade);

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 235, 100, 20);
		pnlVeterinario.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(130, 235, 100, 20);
		pnlVeterinario.add(txftelefone);

		lblidEndereco = new JLabel("ID Endereço:");
		lblidEndereco.setBounds(15, 265, 100, 20);
		pnlVeterinario.add(lblidEndereco);
		txfidEndereco = new JTextField();
		txfidEndereco.setBounds(130, 265, 100, 20);
		pnlVeterinario.add(txfidEndereco);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(300, 350, 100, 25);
		pnlVeterinario.add(btnenviar);
	}
}
