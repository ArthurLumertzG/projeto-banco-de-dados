package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

import database.model.Endereco;
import database.model.Clinica;   
import controller.EnderecoController;
import controller.ClinicaController;   
import controller.VeterinarioController;

public class AdicionarVeterinarioView extends JFrame {

	private JPanel pnlVeterinario;

	private JTextField txfnome;
	private JLabel lblnome;

	 private JComboBox<Clinica> cbClinica; 
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

	private JComboBox<Endereco> cbEndereco;
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

		lblnome = new JLabel("Nome:");
		lblnome.setBounds(15, 25, 100, 20);
		pnlVeterinario.add(lblnome);
		txfnome = new JTextField();
		txfnome.setBounds(130, 25, 100, 20);
		pnlVeterinario.add(txfnome);

		lblidClinica = new JLabel("ID Clínica:");
		lblidClinica.setBounds(15, 55, 100, 20);
		pnlVeterinario.add(lblidClinica);

		try {
            List<Clinica> listaClinicas = ClinicaController.listar();
            cbClinica = new JComboBox<>(new Vector<>(listaClinicas));
            cbClinica.setBounds(130, 55, 100, 20);

            cbClinica.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Clinica) {
                        Clinica clinica = (Clinica) value;
                        setText(clinica.getIdClinica() + " – " + clinica.getNome());
                    }
                    return this;
                }
            });

            pnlVeterinario.add(cbClinica);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar clínicas:\n" + ex.getMessage(),
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }

		lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(15, 85, 100, 20);
		pnlVeterinario.add(lblcpf);
		txfcpf = new JTextField();
		txfcpf.setBounds(130, 85, 100, 20);
		pnlVeterinario.add(txfcpf);

		lblcrmv = new JLabel("CRMV:");
		lblcrmv.setBounds(15, 115, 100, 20);
		pnlVeterinario.add(lblcrmv);
		txfcrmv = new JTextField();
		txfcrmv.setBounds(130, 115, 100, 20);
		pnlVeterinario.add(txfcrmv);

		lblemail = new JLabel("Email:");
		lblemail.setBounds(15, 145, 100, 20);
		pnlVeterinario.add(lblemail);
		txfemail = new JTextField();
		txfemail.setBounds(130, 145, 100, 20);
		pnlVeterinario.add(txfemail);

		lblespecialidade = new JLabel("Especialidade:");
		lblespecialidade.setBounds(15, 175, 100, 20);
		pnlVeterinario.add(lblespecialidade);
		txfespecialidade = new JTextField();
		txfespecialidade.setBounds(130, 175, 100, 20);
		pnlVeterinario.add(txfespecialidade);

		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(15, 205, 100, 20);
		pnlVeterinario.add(lbltelefone);
		txftelefone = new JTextField();
		txftelefone.setBounds(130, 205, 100, 20);
		pnlVeterinario.add(txftelefone);

		lblidEndereco = new JLabel("Endereço:");
		lblidEndereco.setBounds(15, 235, 100, 20);
		pnlVeterinario.add(lblidEndereco);

		try {
			List<Endereco> listaEnderecos = EnderecoController.listar();
			cbEndereco = new JComboBox<>(new Vector<>(listaEnderecos));
			cbEndereco.setBounds(130, 235, 100, 20);

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

			pnlVeterinario.add(cbEndereco);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar endereços:\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		btnenviar = new JButton("Enviar");
		btnenviar.setBounds(300, 350, 100, 25);
		pnlVeterinario.add(btnenviar);

		btnenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txfnome.getText().trim();
				Clinica clinicaSelecionada = (Clinica) cbClinica.getSelectedItem();
				String cpf = txfcpf.getText().trim();
				String crmv = txfcrmv.getText().trim();
				String email = txfemail.getText().trim();
				String especialidade = txfespecialidade.getText().trim();
				String telefone = txftelefone.getText().trim();
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();
	
				if (nome.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo Nome.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfnome.requestFocus();
					return;
				}
				if (clinicaSelecionada == null) {
                    JOptionPane.showMessageDialog(AdicionarVeterinarioView.this,
                        "Selecione uma clínica válida.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
                    cbClinica.requestFocus();
                    return;
                }
				if (cpf.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo CPF.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfcpf.requestFocus();
					return;
				}
				if (crmv.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo CRMV.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfcrmv.requestFocus();
					return;
				}
				if (email.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo Email.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfemail.requestFocus();
					return;
				}
				if (especialidade.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo Especialidade.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txfespecialidade.requestFocus();
					return;
				}
				if (telefone.isEmpty()) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Preencha o campo Telefone.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					txftelefone.requestFocus();
					return;
				}
				if (enderecoSelecionado == null) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Selecione um endereço válido.",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					cbEndereco.requestFocus();
					return;
				}

				try {
					int idClinica = clinicaSelecionada.getIdClinica();
					int idEndereco = enderecoSelecionado.getIdEndereco();

					VeterinarioController.inserir(idClinica, idEndereco, nome, cpf, crmv, email, especialidade,
							telefone);

					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this, "Veterinário cadastrado com sucesso!",
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this,
							"ID Clínica inválido: " + ex.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
					cbClinica.requestFocus();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(AdicionarVeterinarioView.this,
							"Erro ao gravar veterinário:\n" + ex.getMessage(), "Erro de Banco",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}
}
