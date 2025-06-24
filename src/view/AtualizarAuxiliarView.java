package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import database.model.Auxiliar;

public class AtualizarAuxiliarView extends JFrame {

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
    private JPanel pnlAuxiliar;

    public AtualizarAuxiliarView() {
        setTitle("Atualizar - Auxiliar");
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

        modelo.addColumn("ID");
        modelo.addColumn("ID Clínica");
        modelo.addColumn("ID Endereco");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Email");
        modelo.addColumn("Telefone");
        modelo.addColumn("CRMV");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Auxiliar> auxiliarLista = AuxiliarController.listar();
            for (Auxiliar auxiliar : auxiliarLista) {
                modelo.addRow(new String[] {
                    auxiliar.getIdAuxiliarAsString(),
                    auxiliar.getIdClinicaAsString(),
                    auxiliar.getIdEnderecoAsString(),
                    auxiliar.getNome(),
                    auxiliar.getCpf(),
                    auxiliar.getEmail(),
                    auxiliar.getTelefone(),
                    auxiliar.getCrmv()
                });
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        btnAtualizar.addActionListener(new ActionListener() {

            private String crmv;
            private String nome;
            private String cpf;
            private String email;
            private String telefone;
            private int idEndereco;
            private int idClinica;

            @Override
            public void actionPerformed(ActionEvent e) {
                String stringId = txfAtualizar.getText().trim();
                if (stringId.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Id inválido.");
                    return;
                }

                Integer id = Integer.parseInt(stringId);

                pnlAuxiliar = new JPanel();
                pnlAuxiliar.setBorder(BorderFactory.createTitledBorder("Auxiliar"));
                pnlAuxiliar.setBounds(0, 300, 700, 270); 
                pnlAuxiliar.setLayout(null);
                getContentPane().add(pnlAuxiliar);
                getContentPane().revalidate();
                getContentPane().repaint();
                pnlAuxiliar.setVisible(true);

                JLabel lblnome = new JLabel("Nome:");
                lblnome.setBounds(15, 15, 100, 20);
                pnlAuxiliar.add(lblnome);

                JTextField txfnome = new JTextField();
                txfnome.setBounds(15, 35, 100, 20);
                pnlAuxiliar.add(txfnome);

                JLabel lblcpf = new JLabel("CPF:");
                lblcpf.setBounds(15, 60, 100, 20);
                pnlAuxiliar.add(lblcpf);

                JTextField txfcpf = new JTextField();
                txfcpf.setBounds(15, 80, 100, 20);
                pnlAuxiliar.add(txfcpf);

                JLabel lbltelefone = new JLabel("Telefone:");
                lbltelefone.setBounds(15, 105, 100, 20);
                pnlAuxiliar.add(lbltelefone);

                JTextField txftelefone = new JTextField();
                txftelefone.setBounds(15, 125, 100, 20);
                pnlAuxiliar.add(txftelefone);

                JLabel lblidClinica = new JLabel("ID Clínica:");
                lblidClinica.setBounds(200, 15, 100, 20);
                pnlAuxiliar.add(lblidClinica);

                JTextField txfidClinica = new JTextField();
                txfidClinica.setBounds(200, 35, 100, 20);
                pnlAuxiliar.add(txfidClinica);

                JLabel lblemail = new JLabel("Email:");
                lblemail.setBounds(200, 60, 100, 20);
                pnlAuxiliar.add(lblemail);

                JTextField txfemail = new JTextField();
                txfemail.setBounds(200, 80, 100, 20);
                pnlAuxiliar.add(txfemail);

                JLabel lblcrmv = new JLabel("CRMV:");
                lblcrmv.setBounds(200, 105, 100, 20);
                pnlAuxiliar.add(lblcrmv);

                JTextField txfcrmv = new JTextField();
                txfcrmv.setBounds(200, 125, 100, 20);
                pnlAuxiliar.add(txfcrmv);

                JLabel lblidEndereco = new JLabel("ID Endereço:");
                lblidEndereco.setBounds(15, 150, 100, 20);
                pnlAuxiliar.add(lblidEndereco);

                JTextField txfidEndereco = new JTextField();
                txfidEndereco.setBounds(15, 170, 100, 20);
                pnlAuxiliar.add(txfidEndereco);

                JButton btnenviar = new JButton("Atualizar");
                btnenviar.setBounds(150, 220, 100, 25);
                pnlAuxiliar.add(btnenviar);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            idEndereco = Integer.parseInt(txfidEndereco.getText());
                            crmv = txfcrmv.getText();
                            email = txfemail.getText();
                            idClinica = Integer.parseInt(txfidClinica.getText());
                            telefone = txftelefone.getText();
                            cpf = txfcpf.getText();
                            nome = txfnome.getText();
                            int idAuxiliar = Integer.parseInt(txfAtualizar.getText()); 
                            AuxiliarController.atualizar(idAuxiliar, nome, cpf, crmv, email, idClinica, telefone, idEndereco);
                            JOptionPane.showMessageDialog(rootPane, "Auxiliar atualizado com sucesso!");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}