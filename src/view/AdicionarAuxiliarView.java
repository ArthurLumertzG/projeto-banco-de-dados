package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

import database.model.Clinica;
import database.model.Endereco;
import database.model.Auxiliar;
import controller.ClinicaController;
import controller.EnderecoController;
import controller.AuxiliarController;

public class AdicionarAuxiliarView extends JFrame {

    private JPanel pnlAuxiliar;
    private JLabel lblNome;
    private javax.swing.JTextField txfNome;
    private JLabel lblCpf;
    private javax.swing.JTextField txfCpf;
    private JLabel lblTelefone;
    private javax.swing.JTextField txfTelefone;
    private JLabel lblClinica;
    private JComboBox<Clinica> cbClinica;
    private JLabel lblEmail;
    private javax.swing.JTextField txfEmail;
    private JLabel lblCrmv;
    private javax.swing.JTextField txfCrmv;
    private JLabel lblEndereco;
    private JComboBox<Endereco> cbEndereco;
    private JButton btnEnviar;

    public AdicionarAuxiliarView() {
        setTitle("Clínica Veterinária - Auxiliar");
        setSize(400, 300);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponent();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        pnlAuxiliar = new JPanel();
        pnlAuxiliar.setBorder(BorderFactory.createTitledBorder("Cadastro de Auxiliar"));
        pnlAuxiliar.setBounds(0, 0, 400, 300);
        pnlAuxiliar.setLayout(null);
        getContentPane().add(pnlAuxiliar);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(15, 15, 100, 20);
        pnlAuxiliar.add(lblNome);
        txfNome = new javax.swing.JTextField();
        txfNome.setBounds(15, 35, 150, 20);
        pnlAuxiliar.add(txfNome);

        lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(15, 60, 100, 20);
        pnlAuxiliar.add(lblCpf);
        txfCpf = new javax.swing.JTextField();
        txfCpf.setBounds(15, 80, 150, 20);
        pnlAuxiliar.add(txfCpf);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(15, 105, 100, 20);
        pnlAuxiliar.add(lblTelefone);
        txfTelefone = new javax.swing.JTextField();
        txfTelefone.setBounds(15, 125, 150, 20);
        pnlAuxiliar.add(txfTelefone);

        lblClinica = new JLabel("Clínica:");
        lblClinica.setBounds(200, 15, 100, 20);
        pnlAuxiliar.add(lblClinica);
        try {
            List<Clinica> listaClinicas = ClinicaController.listar();
            cbClinica = new JComboBox<>(new Vector<>(listaClinicas));
            cbClinica.setBounds(200, 35, 150, 20);
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
            pnlAuxiliar.add(cbClinica);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar clínicas:\n" + exception.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(200, 60, 100, 20);
        pnlAuxiliar.add(lblEmail);
        txfEmail = new javax.swing.JTextField();
        txfEmail.setBounds(200, 80, 150, 20);
        pnlAuxiliar.add(txfEmail);

        lblCrmv = new JLabel("CRMV:");
        lblCrmv.setBounds(200, 105, 100, 20);
        pnlAuxiliar.add(lblCrmv);
        txfCrmv = new javax.swing.JTextField();
        txfCrmv.setBounds(200, 125, 150, 20);
        pnlAuxiliar.add(txfCrmv);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(15, 150, 100, 20);
        pnlAuxiliar.add(lblEndereco);
        try {
            List<Endereco> listaEnderecos = EnderecoController.listar();
            cbEndereco = new JComboBox<>(new Vector<>(listaEnderecos));
            cbEndereco.setBounds(15, 170, 150, 20);
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
            pnlAuxiliar.add(cbEndereco);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar endereços:\n" + exception.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(150, 220, 100, 25);
        pnlAuxiliar.add(btnEnviar);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nome = txfNome.getText().trim();
                String cpf = txfCpf.getText().trim();
                String telefone = txfTelefone.getText().trim();
                Clinica clinicaSelecionada = (Clinica) cbClinica.getSelectedItem();
                String email = txfEmail.getText().trim();
                String crmv = txfCrmv.getText().trim();
                Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Preencha o campo Nome.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfNome.requestFocus();
                    return;
                }
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Preencha o campo CPF.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfCpf.requestFocus();
                    return;
                }
                if (telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Preencha o campo Telefone.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfTelefone.requestFocus();
                    return;
                }
                if (clinicaSelecionada == null) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Selecione uma clínica válida.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbClinica.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Preencha o campo Email.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfEmail.requestFocus();
                    return;
                }
                if (crmv.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Preencha o campo CRMV.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfCrmv.requestFocus();
                    return;
                }
                if (enderecoSelecionado == null) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Selecione um endereço válido.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbEndereco.requestFocus();
                    return;
                }

                try {
                    int idClinica = clinicaSelecionada.getIdClinica();
                    int idEndereco = enderecoSelecionado.getIdEndereco();
                    AuxiliarController.inserir(nome, cpf, crmv, email, idClinica, telefone, idEndereco);
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Auxiliar cadastrado com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(AdicionarAuxiliarView.this,
                            "Erro ao salvar auxiliar:\n" + exception.getMessage(),
                            "Erro de Banco", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
            }
        });
    }
}
