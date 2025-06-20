package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TutorView extends JFrame {

	private JPanel pnlTutor;
	private JTextField txfidTutor;
	private JLabel lblidTutor;
	private JTextField txfnome;
	private JLabel lblnome;
	private JTextField txfcpf;
	private JLabel lblcpf;
	private JTextField txfemail;
	private JLabel lblemail;
	private JTextField txftelefone;
	private JLabel lbltelefone;
	private JButton btnenviar;
    private JTextField txfidEndereco;
	private JLabel lblidEndereco;

	public TutorView() {

		setTitle("Clínica Veterinária - Tutor");
		setSize(350, 300);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {

		pnlTutor = new JPanel();
		pnlTutor.setBorder(BorderFactory.createTitledBorder("Cadastro de Tutor"));
		pnlTutor.setBounds(0, 0, 350, 300);
		pnlTutor.setLayout(null);
		getContentPane().add(pnlTutor);

		lblidTutor = new JLabel("ID Tutor:");
		lblidTutor.setBounds(15, 15, 100, 20);
		pnlTutor.add(lblidTutor);
		txfidTutor = new JTextField();
		txfidTutor.setBounds(15, 35, 100, 20);
		pnlTutor.add(txfidTutor);
		txfidTutor.getText();

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 60, 100, 20);
		pnlTutor.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(15, 80, 100, 20);
		pnlTutor.add(txfnome);
		txfnome.getText();

		lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(15, 105, 100, 20);
		pnlTutor.add(lblcpf);
		txfcpf = new JTextField();
		txfcpf.setBounds(15, 125, 100, 20);
		pnlTutor.add(txfcpf);
		txfcpf.getText();

		lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 150, 100, 20);
		pnlTutor.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(15, 170, 100, 20);
		pnlTutor.add(txfemail);
		txfemail.getText();

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 195, 100, 20);
		pnlTutor.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(15, 215, 100, 20);
		pnlTutor.add(txftelefone);
		txftelefone.getText();

        lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 150, 100, 20);
		pnlTutor.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(15, 170, 100, 20);
		pnlTutor.add(txfemail);
		txfemail.getText();

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(200, 245, 100, 25);
		pnlTutor.add(btnenviar);

	}
}
