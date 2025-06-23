package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.EnderecoController;

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
		setSize(400, 330);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createComponent();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void createComponent() {
		pnlEndereco = new JPanel();
		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Cadastro de Endereço"));
		pnlEndereco.setBounds(0, 0, 400, 330);
		pnlEndereco.setLayout(null);
		getContentPane().add(pnlEndereco);

		lblcep = new JLabel("CEP:");
		lblcep.setBounds(15, 25, 100, 20);
		pnlEndereco.add(lblcep);
		txfcep = new JTextField();
		txfcep.setBounds(120, 25, 200, 20);
		pnlEndereco.add(txfcep);

		lblrua = new JLabel("Rua:");
		lblrua.setBounds(15, 55, 100, 20);
		pnlEndereco.add(lblrua);
		txfrua = new JTextField();
		txfrua.setBounds(120, 55, 200, 20);
		pnlEndereco.add(txfrua);

		lblnumero = new JLabel("Número:");
		lblnumero.setBounds(15, 85, 100, 20);
		pnlEndereco.add(lblnumero);
		txfnumero = new JTextField();
		txfnumero.setBounds(120, 85, 200, 20);
		pnlEndereco.add(txfnumero);

		lblbairro = new JLabel("Bairro:");
		lblbairro.setBounds(15, 115, 100, 20);
		pnlEndereco.add(lblbairro);
		txfbairro = new JTextField();
		txfbairro.setBounds(120, 115, 200, 20);
		pnlEndereco.add(txfbairro);

		lblcidade = new JLabel("Cidade:");
		lblcidade.setBounds(15, 145, 100, 20);
		pnlEndereco.add(lblcidade);
		txfcidade = new JTextField();
		txfcidade.setBounds(120, 145, 200, 20);
		pnlEndereco.add(txfcidade);

		lblestado = new JLabel("Estado:");
		lblestado.setBounds(15, 175, 100, 20);
		pnlEndereco.add(lblestado);
		txfestado = new JTextField();
		txfestado.setBounds(120, 175, 200, 20);
		pnlEndereco.add(txfestado);

		lblcomplemento = new JLabel("Complemento:");
		lblcomplemento.setBounds(15, 205, 100, 20);
		pnlEndereco.add(lblcomplemento);
		txfcomplemento = new JTextField();
		txfcomplemento.setBounds(120, 205, 200, 20);
		pnlEndereco.add(txfcomplemento);

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(250, 250, 100, 25);
		pnlEndereco.add(btnenviar);

		btnenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cep = txfcep.getText().trim();
				String rua = txfrua.getText().trim();
				String numero = txfnumero.getText().trim();
				String bairro = txfbairro.getText().trim();
				String cidade = txfcidade.getText().trim();
				String estado = txfestado.getText().trim();
				String complemento = txfcomplemento.getText().trim();

				if (cep.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo CEP.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfcep.requestFocus();
					return;
				}
				if (rua.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo Rua.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfrua.requestFocus();
					return;
				}
				if (numero.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo Número.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfnumero.requestFocus();
					return;
				}
				if (bairro.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo Bairro.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfbairro.requestFocus();
					return;
				}
				if (cidade.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo Cidade.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfcidade.requestFocus();
					return;
				}
				if (estado.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Preencha o campo Estado.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfestado.requestFocus();
					return;
				}

				try {

					EnderecoController.inserir(cep, rua, numero, bairro, cidade, estado, complemento);

					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Endereço cadastrado com sucesso!",
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this, "Número inválido: " + ex.getMessage(),
							"Erro de Formato", JOptionPane.ERROR_MESSAGE);
					txfnumero.requestFocus();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(AdicionarEnderecoView.this,
							"Erro ao gravar endereço:\n" + ex.getMessage(), "Erro de Banco", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}
}
