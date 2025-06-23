package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.PetController;
import database.model.Pet;

public class VisualizarPetView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public VisualizarPetView() {
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
        scroll.setBounds(10, 10, 560, 250);
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

