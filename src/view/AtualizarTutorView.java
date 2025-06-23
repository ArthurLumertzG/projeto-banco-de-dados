package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.TutorController;
import database.model.Tutor;

public class AtualizarTutorView extends JFrame {

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
    private JPanel pnlTutor;
    private JLabel lblnome;
    private JTextField txfnome;
    private JLabel lblcpf;
    private JTextField txfcpf;
    private JTextField txftelefone;
    private JLabel lbltelefone;
    private JLabel lblemail;
    private JTextField txfemail;
    private JLabel lblidEndereco;
    private JTextField txfidEndereco;
    private JButton btnenviar;

    public AtualizarTutorView() {
        setTitle("Atualizar - Tutor");
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

        modelo.addColumn("ID Tutor");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("Email");
        modelo.addColumn("ID Endereço");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Tutor> tutorLista = TutorController.listar();
            for (Tutor tutor : tutorLista) {
                modelo.addRow(new String[] {
                    tutor.getIdTutorAsString(),
                    tutor.getNome(),
                    tutor.getCpf(),
                    tutor.getTelefone(),
                    tutor.getEmail(),
                    tutor.getIdEnderecoAsString()
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

                pnlTutor = new JPanel();
                pnlTutor.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Tutor"));
                pnlTutor.setBounds(0, 300, 700, 350);
                pnlTutor.setLayout(null);
                getContentPane().add(pnlTutor);
                getContentPane().revalidate();
                getContentPane().repaint();
                pnlTutor.setVisible(true);

                lblnome = new JLabel("Nome:");
                lblnome.setBounds(15, 55, 100, 20);
                pnlTutor.add(lblnome);
                txfnome = new JTextField();
                txfnome.setBounds(120, 55, 100, 20);
                pnlTutor.add(txfnome);

                lblcpf = new JLabel("CPF:");
                lblcpf.setBounds(15, 85, 100, 20);
                pnlTutor.add(lblcpf);
                txfcpf = new JTextField();
                txfcpf.setBounds(120, 85, 100, 20);
                pnlTutor.add(txfcpf);

                lbltelefone = new JLabel("Telefone:");
                lbltelefone.setBounds(15, 115, 100, 20);
                pnlTutor.add(lbltelefone);
                txftelefone = new JTextField();
                txftelefone.setBounds(120, 115, 100, 20);
                pnlTutor.add(txftelefone);

                lblemail = new JLabel("Email:");
                lblemail.setBounds(15, 145, 100, 20);
                pnlTutor.add(lblemail);
                txfemail = new JTextField();
                txfemail.setBounds(120, 145, 100, 20);
                pnlTutor.add(txfemail);

                lblidEndereco = new JLabel("ID Endereço:");
                lblidEndereco.setBounds(15, 175, 100, 20);
                pnlTutor.add(lblidEndereco);
                txfidEndereco = new JTextField();
                txfidEndereco.setBounds(120, 175, 100, 20);
                pnlTutor.add(txfidEndereco);

                btnenviar = new JButton("Enviar");
                btnenviar.setBounds(270, 200, 100, 25);
                pnlTutor.add(btnenviar);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String nome = txfnome.getText();
                            String cpf = txfcpf.getText();
                            String telefone = txftelefone.getText();
                            String email = txfemail.getText();
                            String idEnderecoStr = txfidEndereco.getText();
                            
                            Integer idEndereco = Integer.parseInt(idEnderecoStr);
                            
                            TutorController.atualizar(id, nome, cpf, email, telefone, idEndereco);
                            JOptionPane.showMessageDialog(rootPane, "Tutor atualizado com sucesso!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar tutor.");
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPane, "ID Endereço deve ser um número válido.");
                        }
                    }
                });
            }
        });
    }
}