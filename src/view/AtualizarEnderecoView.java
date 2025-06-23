package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.EnderecoController;
import database.model.Endereco;

public class AtualizarEnderecoView extends JFrame {

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
    private JPanel pnlEndereco;

    public AtualizarEnderecoView() {
        setTitle("Atualizar - Endereço");
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

        modelo.addColumn("ID Endereço");
        modelo.addColumn("Rua");
        modelo.addColumn("Número");
        modelo.addColumn("Bairro");
        modelo.addColumn("Cidade");
        modelo.addColumn("Estado");
        modelo.addColumn("CEP");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Endereco> enderecoLista = EnderecoController.listar();
            for (Endereco endereco : enderecoLista) {
                modelo.addRow(new String[] {
                    endereco.getIdEnderecoAsString(),
                    endereco.getRua(),
                    endereco.getNumero(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getEstado(),
                    endereco.getCep()
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

                pnlEndereco = new JPanel();
                pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
                pnlEndereco.setBounds(0, 300, 700, 270); 
                pnlEndereco.setLayout(null);
                getContentPane().add(pnlEndereco);
                getContentPane().revalidate();
                getContentPane().repaint();
                pnlEndereco.setVisible(true);

                JLabel lblrua = new JLabel("Rua:");
                lblrua.setBounds(15, 15, 100, 20);
                pnlEndereco.add(lblrua);

                JTextField txfrua = new JTextField();
                txfrua.setBounds(15, 35, 100, 20);
                pnlEndereco.add(txfrua);

                JLabel lblnumero = new JLabel("Número:");
                lblnumero.setBounds(15, 60, 100, 20);
                pnlEndereco.add(lblnumero);

                JTextField txfnumero = new JTextField();
                txfnumero.setBounds(15, 80, 100, 20);
                pnlEndereco.add(txfnumero);

                JLabel lblbairro = new JLabel("Bairro:");
                lblbairro.setBounds(15, 105, 100, 20);
                pnlEndereco.add(lblbairro);

                JTextField txfbairro = new JTextField();
                txfbairro.setBounds(15, 125, 100, 20);
                pnlEndereco.add(txfbairro);

                JLabel lblcidade = new JLabel("Cidade:");
                lblcidade.setBounds(200, 15, 100, 20);
                pnlEndereco.add(lblcidade);

                JTextField txfcidade = new JTextField();
                txfcidade.setBounds(200, 35, 100, 20);
                pnlEndereco.add(txfcidade);

                JLabel lblestado = new JLabel("Estado:");
                lblestado.setBounds(200, 60, 100, 20);
                pnlEndereco.add(lblestado);

                JTextField txfestado = new JTextField();
                txfestado.setBounds(200, 80, 100, 20);
                pnlEndereco.add(txfestado);

                JLabel lblcep = new JLabel("CEP:");
                lblcep.setBounds(200, 105, 100, 20);
                pnlEndereco.add(lblcep);

                JTextField txfcep = new JTextField();
                txfcep.setBounds(200, 125, 100, 20);
                pnlEndereco.add(txfcep);

                JButton btnenviar = new JButton("Atualizar");
                btnenviar.setBounds(150, 220, 100, 25);
                pnlEndereco.add(btnenviar);
                
                JLabel lblcomplemento = new JLabel("Complemento:");
                lblcomplemento.setBounds(15, 150, 100, 20);
                pnlEndereco.add(lblcomplemento);
                
                JTextField txfcomplemento = new JTextField();
                txfcomplemento.setBounds(15, 170, 100, 20);
                pnlEndereco.add(txfcomplemento);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String rua = txfrua.getText();
                            String numero = txfnumero.getText();
                            String bairro = txfbairro.getText();
                            String cidade = txfcidade.getText();
                            String estado = txfestado.getText();
                            String cep = txfcep.getText();
                            String complemento = txfcomplemento.getText();
                            
                            EnderecoController.atualizar(id, cep, rua, numero, bairro, cidade, estado, complemento);
                            JOptionPane.showMessageDialog(rootPane, "Endereço atualizado com sucesso!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar endereço.");
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}