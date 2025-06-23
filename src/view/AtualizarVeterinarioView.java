package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.VeterinarioController;
import database.model.Veterinario;

public class AtualizarVeterinarioView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JScrollPane scroll;
    private JLabel lblAtualizar;
    private JTextField txfAtualizar;
    private JButton btnAtualizar;
    private JPanel pnlVeterinario;
    private JLabel lblnome;
    private JTextField txfnome;
    private JLabel lblidClinica;
    private JTextField txfidClinica;
    private JTextField txfcpf;
    private JLabel lblcpf;
    private JLabel lblcrmv;
    private JTextField txfcrmv;
    private JLabel lblemail;
    private JTextField txfemail;
    private JLabel lblespecialidade;
    private JTextField txfespecialidade;
    private JLabel lbltelefone;
    private JTextField txftelefone;
    private JLabel lblidEndereco;
    private JTextField txfidEndereco;
    private JButton btnenviar;

    public AtualizarVeterinarioView() {
        setTitle("Atualizar - Veterinário");
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        componentesCriar();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void componentesCriar() {
        lblAtualizar = new JLabel("Id da linha a ser atualizada:");
        lblAtualizar.setBounds(20, 230, 200, 20);
        getContentPane().add(lblAtualizar);

        txfAtualizar = new JTextField();
        txfAtualizar.setBounds(180, 230, 100, 20);
        getContentPane().add(txfAtualizar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(300, 225, 100, 30);
        getContentPane().add(btnAtualizar);

        modelo.addColumn("ID Veterinário");
        modelo.addColumn("Nome");
        modelo.addColumn("ID Clínica");
        modelo.addColumn("CPF");
        modelo.addColumn("CRMV");
        modelo.addColumn("Email");
        modelo.addColumn("Especialidade");
        modelo.addColumn("Telefone");
        modelo.addColumn("ID Endereço");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Veterinario> veterinarioLista = VeterinarioController.listar();
            for (Veterinario veterinario : veterinarioLista) {
                modelo.addRow(new String[] {
                    veterinario.getIdVeterinarioAsString(),
                    veterinario.getNome(),
                    veterinario.getIdClinicaAsString(),
                    veterinario.getCpf(),
                    veterinario.getCrmv(),
                    veterinario.getEmail(),
                    veterinario.getEspecialidade(),
                    veterinario.getTelefone(),
                    veterinario.getIdEnderecoAsString()
                });
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringId = txfAtualizar.getText().trim();
                if (stringId.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Id inválido.");
                    return;
                }

                Integer id = Integer.parseInt(stringId);

                pnlVeterinario = new JPanel();
                pnlVeterinario.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Veterinário"));
                pnlVeterinario.setBounds(0, 300, 700, 350);
                pnlVeterinario.setLayout(null);
                getContentPane().add(pnlVeterinario);
                getContentPane().revalidate();
                getContentPane().repaint();
                pnlVeterinario.setVisible(true);

                lblnome = new JLabel("Nome:");
                lblnome.setBounds(15, 25, 100, 20);
                pnlVeterinario.add(lblnome);
                txfnome = new JTextField();
                txfnome.setBounds(120, 25, 100, 20);
                pnlVeterinario.add(txfnome);

                lblidClinica = new JLabel("ID Clínica:");
                lblidClinica.setBounds(15, 50, 100, 20);
                pnlVeterinario.add(lblidClinica);
                txfidClinica = new JTextField();
                txfidClinica.setBounds(120, 50, 100, 20);
                pnlVeterinario.add(txfidClinica);

                lblcpf = new JLabel("CPF:");
                lblcpf.setBounds(15, 75, 100, 20);
                pnlVeterinario.add(lblcpf);
                txfcpf = new JTextField();
                txfcpf.setBounds(120, 75, 100, 20);
                pnlVeterinario.add(txfcpf);

                lblcrmv = new JLabel("CRMV:");
                lblcrmv.setBounds(15, 100, 100, 20);
                pnlVeterinario.add(lblcrmv);
                txfcrmv = new JTextField();
                txfcrmv.setBounds(120, 100, 100, 20);
                pnlVeterinario.add(txfcrmv);

                lblemail = new JLabel("Email:");
                lblemail.setBounds(300, 25, 100, 20);
                pnlVeterinario.add(lblemail);
                txfemail = new JTextField();
                txfemail.setBounds(405, 25, 100, 20);
                pnlVeterinario.add(txfemail);

                lblespecialidade = new JLabel("Especialidade:");
                lblespecialidade.setBounds(300, 50, 100, 20);
                pnlVeterinario.add(lblespecialidade);
                txfespecialidade = new JTextField();
                txfespecialidade.setBounds(405, 50, 100, 20);
                pnlVeterinario.add(txfespecialidade);

                lbltelefone = new JLabel("Telefone:");
                lbltelefone.setBounds(300, 75, 100, 20);
                pnlVeterinario.add(lbltelefone);
                txftelefone = new JTextField();
                txftelefone.setBounds(405, 75, 100, 20);
                pnlVeterinario.add(txftelefone);

                lblidEndereco = new JLabel("ID Endereço:");
                lblidEndereco.setBounds(300, 100, 100, 20);
                pnlVeterinario.add(lblidEndereco);
                txfidEndereco = new JTextField();
                txfidEndereco.setBounds(405, 100, 100, 20);
                pnlVeterinario.add(txfidEndereco);

                btnenviar = new JButton("Enviar");
                btnenviar.setBounds(300, 150, 100, 25);
                pnlVeterinario.add(btnenviar);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String nome = txfnome.getText();
                            String idClinicaStr = txfidClinica.getText();
                            String cpf = txfcpf.getText();
                            String crmv = txfcrmv.getText();
                            String email = txfemail.getText();
                            String especialidade = txfespecialidade.getText();
                            String telefone = txftelefone.getText();
                            String idEnderecoStr = txfidEndereco.getText();
                            
                            Integer idClinica = Integer.parseInt(idClinicaStr);
                            Integer idEndereco = Integer.parseInt(idEnderecoStr);
                            
                            VeterinarioController.atualizar(id, idEndereco, idClinica, nome, cpf, crmv, email, especialidade, telefone);
                            JOptionPane.showMessageDialog(rootPane, "Veterinário atualizado com sucesso!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar veterinário.");
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPane, "ID Clínica e ID Endereço devem ser números válidos.");
                        }
                    }
                });
            }
        });
    }
}