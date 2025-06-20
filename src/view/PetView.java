package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PetView extends JFrame {

	private JPanel pnlPet;

	private JTextField txfidPet;
	private JLabel lblidPet;

	private JTextField txfnome;
	private JLabel lblnome;

	private JTextField txfdataNascimento;
	private JLabel lbldataNascimento;

	private JTextField txfespecie;
	private JLabel lblespecie;

	private JTextField txfraca;
	private JLabel lblraca;

	private JTextField txfidTutor;
	private JLabel lblidTutor;

	private JButton btnenviar;

	public PetView() {
		setTitle("Clínica Veterinária - Pet");
		setSize(400, 350);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {
		pnlPet = new JPanel();
		pnlPet.setBorder(BorderFactory.createTitledBorder("Cadastro de Pet"));
		pnlPet.setBounds(0, 0, 400, 350);
		pnlPet.setLayout(null);
		getContentPane().add(pnlPet);

		lblidPet = new JLabel("ID Pet:");
		lblidPet.setBounds(15, 25, 100, 20);
		pnlPet.add(lblidPet);
		txfidPet = new JTextField();
		txfidPet.setBounds(120, 25, 100, 20);
		pnlPet.add(txfidPet);

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 55, 100, 20);
		pnlPet.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(120, 55, 100, 20);
		pnlPet.add(txfnome);

		lbldataNascimento = new JLabel("Data de Nascimento:");
		lbldataNascimento.setBounds(15, 85, 150, 20);
		pnlPet.add(lbldataNascimento);
		txfdataNascimento = new JTextField();
		txfdataNascimento.setBounds(150, 85, 100, 20);
		pnlPet.add(txfdataNascimento);

		lblespecie = new JLabel("Espécie:");
		lblespecie.setBounds(15, 115, 100, 20);
		pnlPet.add(lblespecie);
		txfespecie = new JTextField();
		txfespecie.setBounds(120, 115, 100, 20);
		pnlPet.add(txfespecie);

		lblraca = new JLabel("Raça:");
		lblraca.setBounds(15, 145, 100, 20);
		pnlPet.add(lblraca);
		txfraca = new JTextField();
		txfraca.setBounds(120, 145, 100, 20);
		pnlPet.add(txfraca);

		lblidTutor = new JLabel("ID Tutor:");
		lblidTutor.setBounds(15, 175, 100, 20);
		pnlPet.add(lblidTutor);
		txfidTutor = new JTextField();
		txfidTutor.setBounds(120, 175, 100, 20);
		pnlPet.add(txfidTutor);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(270, 250, 100, 25);
		pnlPet.add(btnenviar);
	}
}
