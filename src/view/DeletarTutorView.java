package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.TutorController;
import database.model.Tutor;

public class DeletarTutorView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
	private JLabel lblDeletar;
	private JTextField txfDeletar;
	private JButton btnDeletar;

    public DeletarTutorView() {
        setTitle("Visualizar - Tutor");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        componentesCriar();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    

    private void componentesCriar() {

        lblDeletar = new JLabel("Id da linha a ser excluida:");
			lblDeletar.setBounds(20, 230, 200, 20);
			getContentPane().add(lblDeletar);
			txfDeletar = new JTextField();
			txfDeletar.setBounds(180, 230, 100, 20);
			getContentPane().add(txfDeletar);
			btnDeletar = new JButton("Deletar");
			btnDeletar.setBounds(300, 225, 100, 30);
			getContentPane().add(btnDeletar);
			btnDeletar.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String StringId = txfDeletar.getText().trim();
					if(StringId.isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
						return;
					}
					Integer id = Integer.parseInt(StringId);
					
					try {
						TutorController.deletar(id);
						JOptionPane.showMessageDialog(rootPane, "Deletado com sucesso!");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
						e1.printStackTrace();
					}
				}
			});



        modelo = new DefaultTableModel()  {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false; 
				    }
		};
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("Email");
        modelo.addColumn("ID Endereço");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 360, 150);
        getContentPane().add(scroll);

        try {
            List<Tutor> tutorLista = TutorController.listar();

            for (Tutor tutor : tutorLista) {
                String idTutor = tutor.getIdTutorAsString();
                String nome = tutor.getNome();
                String cpf = tutor.getCpf();
                String telefone = tutor.getTelefone();
                String email = tutor.getEmail();
                String idEndereco = tutor.getIdEnderecoAsString();

                modelo.addRow(new String[]{idTutor, nome, cpf, telefone, email, idEndereco});
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

