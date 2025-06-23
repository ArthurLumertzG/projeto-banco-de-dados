package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarEnderecoView extends JFrame {

	private JPanel pnlEndereco;

	private JTextField txfcep;
	private JLabel lblcep;

	private JTextField txfrua;
	private JLabel lblrua;

	private JTextField txfnumero;
	private JLabel lblnumero;

	private JTextField txfbairro;
	private JLabel lblbairro;

	private JTextField txfcidade;
	private JLabel lblcidade;

	private JTextField txfestado;
	private JLabel lblestado;

	private JTextField txfcomplemento;
	private JLabel lblcomplemento;

	private JButton btnenviar;

	public AdicionarEnderecoView() {
		setTitle("Clínica Veterinária - Endereço");
		setSize(400, 400);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {
		pnlEndereco = new JPanel();
		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Endereço"));
		pnlEndereco.setBounds(0, 0, 400, 400);
		pnlEndereco.setLayout(null);
		getContentPane().add(pnlEndereco);

		lblcep = new JLabel("CEP:");
		lblcep.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblcep);
		txfcep = new JTextField();
		txfcep.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfcep);

		lblrua = new JLabel("Rua:");
		lblrua.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblrua);
		txfrua = new JTextField();
		txfrua.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfrua);

		lblnumero = new JLabel("Número:");
		lblnumero.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblnumero);
		txfnumero = new JTextField();
		txfnumero.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfnumero);

		lblbairro = new JLabel("Bairro:");
		lblbairro.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblbairro);
		txfbairro = new JTextField();
		txfbairro.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfbairro);

		lblcidade = new JLabel("Cidade:");
		lblcidade.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblcidade);
		txfcidade = new JTextField();
		txfcidade.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfcidade);

		lblestado = new JLabel("Estado:");
		lblestado.setBounds(15, 70, 100, 20);
		pnlEndereco.add(lblestado);
		txfestado = new JTextField();
		txfestado.setBounds(15, 85, 100, 20);
		pnlEndereco.add(txfestado);

		lblcomplemento = new JLabel("Complemento:");
		lblcomplemento.setBounds(15, 225, 100, 20);
		pnlEndereco.add(lblcomplemento);
		txfcomplemento = new JTextField();
		txfcomplemento.setBounds(120, 225, 100, 20);
		pnlEndereco.add(txfcomplemento);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(270, 300, 100, 25);
		pnlEndereco.add(btnenviar);
	}
}
