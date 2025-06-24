package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.PetController;
import database.model.Pet;

public class DeletarPetView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    private JLabel lblDeletar;
	private JTextField txfDeletar;
	private JButton btnDeletar;    

    public DeletarPetView() {
        setTitle("Visualizar - Pet");
        setSize(600, 300);
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
						PetController.deletar(id);
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
        modelo.addColumn("Nascimento");
        modelo.addColumn("Espécie");
        modelo.addColumn("Raça");
        modelo.addColumn("ID Tutor");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 560, 150);
        getContentPane().add(scroll);

        try {
            List<Pet> petLista = PetController.listar();

            for (Pet pet : petLista) {
                String idPet = pet.getIdPetAsString();
                String nome = pet.getNome();
                String nascimento = pet.getDataNascimentoAsString();
                String especie = pet.getEspecie();
                String raca = pet.getRaca();
                String idTutor = pet.getIdTutorAsString();

                modelo.addRow(new String[]{idPet, nome, nascimento, especie, raca, idTutor});
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

