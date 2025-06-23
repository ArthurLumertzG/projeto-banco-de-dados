package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import database.model.Endereco;
import controller.EnderecoController;
import controller.ClinicaController;

public class AdicionarClinicaView extends JFrame {

    private JPanel pnlClinica;
    private JLabel lblNome;
    private JTextField txfNome;
    private JLabel lblCnpj;
    private JTextField txfCnpj;
    private JLabel lblTelefone;
    private JTextField txfTelefone;
    private JLabel lblEmail;
    private JTextField txfEmail;
    private JLabel lblEndereco;
    private JComboBox<Endereco> cbEndereco;
    private JButton btnEnviar;

    public AdicionarClinicaView() {
        setTitle("Clínica Veterinária - Clínica");
        setSize(400, 350);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponent();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        pnlClinica = new JPanel();
        pnlClinica.setBorder(BorderFactory.createTitledBorder("Cadastro de Clínica"));
        pnlClinica.setBounds(0, 0, 400, 350);
        pnlClinica.setLayout(null);
        getContentPane().add(pnlClinica);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(15, 25, 100, 20);
        pnlClinica.add(lblNome);
        txfNome = new JTextField();
        txfNome.setBounds(120, 25, 200, 20);
        pnlClinica.add(txfNome);

        lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(15, 65, 100, 20);
        pnlClinica.add(lblCnpj);
        txfCnpj = new JTextField();
        txfCnpj.setBounds(120, 65, 200, 20);
        pnlClinica.add(txfCnpj);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(15, 105, 100, 20);
        pnlClinica.add(lblTelefone);
        txfTelefone = new JTextField();
        txfTelefone.setBounds(120, 105, 200, 20);
        pnlClinica.add(txfTelefone);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(15, 145, 100, 20);
        pnlClinica.add(lblEmail);
        txfEmail = new JTextField();
        txfEmail.setBounds(120, 145, 200, 20);
        pnlClinica.add(txfEmail);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(15, 185, 100, 20);
        pnlClinica.add(lblEndereco);
        try {
            List<Endereco> listaEnderecos = EnderecoController.listar();
            cbEndereco = new JComboBox<>(new Vector<>(listaEnderecos));
            cbEndereco.setBounds(120, 185, 200, 20);
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
            pnlClinica.add(cbEndereco);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar endereços:\n" + exception.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(250, 260, 100, 25);
        pnlClinica.add(btnEnviar);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nome = txfNome.getText().trim();
                String cnpj = txfCnpj.getText().trim();
                String telefone = txfTelefone.getText().trim();
                String email = txfEmail.getText().trim();
                Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Preencha o campo Nome.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfNome.requestFocus();
                    return;
                }
                if (cnpj.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Preencha o campo CNPJ.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfCnpj.requestFocus();
                    return;
                }
                if (telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Preencha o campo Telefone.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfTelefone.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Preencha o campo Email.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfEmail.requestFocus();
                    return;
                }
                if (enderecoSelecionado == null) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Selecione um endereço válido.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbEndereco.requestFocus();
                    return;
                }

                try {
                    int idEndereco = enderecoSelecionado.getIdEndereco();
                    ClinicaController.inserir(nome, cnpj, telefone, email, idEndereco);
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Clínica cadastrada com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(AdicionarClinicaView.this,
                            "Erro ao salvar clínica:\n" + exception.getMessage(),
                            "Erro de Banco", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
            }
        });
    }
}
