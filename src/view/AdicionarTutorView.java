package view;

import java.awt.Component; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListCellRenderer;

import controller.TutorController;
import database.model.Endereco;
import controller.EnderecoController;

public class AdicionarTutorView extends JFrame {

	private JPanel pnlTutor;
	private JTextField txfnome;
	private JLabel lblnome;
	private JTextField txfcpf;
	private JLabel lblcpf;
	private JTextField txfemail;
	private JLabel lblemail;
	private JTextField txftelefone;
	private JLabel lbltelefone;
	private JComboBox<Endereco> cbEndereco;
	private JLabel lblidEndereco;
	private JButton btnenviar;

	public AdicionarTutorView() {

		setTitle("Clínica Veterinária - Tutor");
		setSize(350, 350);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 25, 100, 20);
		pnlTutor.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(15, 45, 100, 20);
		pnlTutor.add(txfnome);
		txfnome.getText();

		lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(15, 75, 100, 20);
		pnlTutor.add(lblcpf);
		txfcpf = new JTextField();
		txfcpf.setBounds(15, 95, 100, 20);
		pnlTutor.add(txfcpf);
		txfcpf.getText();

		lblemail = new JLabel("Email:");
		lblemail.setBounds(180, 25, 100, 20);
		pnlTutor.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(180, 45, 100, 20);
		pnlTutor.add(txfemail);
		txfemail.getText();

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 175, 100, 20);
		pnlTutor.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(15, 195, 100, 20);
		pnlTutor.add(txftelefone);
		txftelefone.getText();

		lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 225, 100, 20);
		pnlTutor.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(15, 245, 100, 20);
		pnlTutor.add(txfemail);
		txfemail.getText();

		lblidEndereco = new JLabel("Endereço:");
		lblidEndereco.setBounds(15, 275, 100, 20);
		pnlTutor.add(lblidEndereco);

		try {
			List<Endereco> listaEnderecos = EnderecoController.listar();
			cbEndereco = new JComboBox<>(new Vector<>(listaEnderecos));
			cbEndereco.setBounds(15, 295, 100, 20);

			cbEndereco.setRenderer(new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value instanceof Endereco) {
						Endereco endereco = (Endereco) value;
						setText(endereco.getIdEndereco() + " – " + endereco.getRua() + ", " + endereco.getCidade());
					}
					return this;
				}
			});

			pnlTutor.add(cbEndereco);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar endereços:\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(200, 330, 100, 25);

		btnenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txfnome.getText().trim();
				String cpf = txfcpf.getText().trim();
				String email = txfemail.getText().trim();
				String telefone = txftelefone.getText().trim();
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

				if (nome.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Preencha o campo Nome.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfnome.requestFocus();
					return;
				}
				if (cpf.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Preencha o campo CPF.", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					txfcpf.requestFocus();
					return;
				}
				if (email.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Preencha o campo Email.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfemail.requestFocus();
					return;
				}
				if (telefone.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Preencha o campo Telefone.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txftelefone.requestFocus();
					return;
				}
				if (enderecoSelecionado == null) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Selecione um endereço válido.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					cbEndereco.requestFocus();
					return;
				}

				try {
					int idEndereco = enderecoSelecionado.getIdEndereco();

					TutorController.inserir(nome, cpf, email, telefone, idEndereco);

					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Tutor cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "ID Endereço inválido: " + ex.getMessage(),
							"Erro de Formato", JOptionPane.ERROR_MESSAGE);
					cbEndereco.requestFocus();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(AdicionarTutorView.this, "Erro ao gravar tutor:\n" + ex.getMessage(),
							"Erro de Banco", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}

				dispose();
			}
		});

		pnlTutor.add(btnenviar);

	}
}
