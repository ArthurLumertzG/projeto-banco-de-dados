package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarConsultaView extends JFrame {

	private JPanel pnlConsulta;
	private JTextField txfidVeterinario;
	private JLabel lblidVeterinario;
	private JTextField txfidEndereco;
	private JLabel lblidEndereco;
	private JTextField txfidPet;
	private JLabel lblidPet;
	private JTextField txfdataHora;
	private JLabel lbldataHora;
	private JTextField txfmotivo;
	private JLabel lblmotivo;
	private JTextField txfdiagnostico;
	private JLabel lbldiagnostico;
	private JTextField txftratamento;
	private JLabel lbltratamento;
	private JButton btnenviar;

	public AdicionarConsultaView() {
		setTitle("Clínica Veterinária - Consulta");
		setSize(400, 380);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {

		pnlConsulta = new JPanel();
		pnlConsulta.setBorder(BorderFactory.createTitledBorder("Consulta"));
		pnlConsulta.setBounds(0, 0, 400, 380);
		pnlConsulta.setLayout(null);
		getContentPane().add(pnlConsulta);

		lblidVeterinario = new JLabel("ID Veterinário:");
		lblidVeterinario.setBounds(15, 15, 100, 20);
		pnlConsulta.add(lblidVeterinario);
		txfidVeterinario = new JTextField();
		txfidVeterinario.setBounds(15, 35, 100, 20);
		pnlConsulta.add(txfidVeterinario);

		lblidEndereco = new JLabel("ID Endereço:");
		lblidEndereco.setBounds(200, 15, 100, 20);
		pnlConsulta.add(lblidEndereco);
		txfidEndereco = new JTextField();
		txfidEndereco.setBounds(200, 35, 100, 20);
		pnlConsulta.add(txfidEndereco);

		lblidPet = new JLabel("ID Pet:");
		lblidPet.setBounds(15, 60, 100, 20);
		pnlConsulta.add(lblidPet);
		txfidPet = new JTextField();
		txfidPet.setBounds(15, 80, 100, 20);
		pnlConsulta.add(txfidPet);

		lbldataHora = new JLabel("Data/Hora:");
		lbldataHora.setBounds(200, 60, 100, 20);
		pnlConsulta.add(lbldataHora);
		txfdataHora = new JTextField();
		txfdataHora.setBounds(200, 80, 100, 20);
		pnlConsulta.add(txfdataHora);

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

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(150, 280, 100, 25);
		pnlConsulta.add(btnenviar);
	}
}
