package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.TutorController;
import database.model.Tutor;

public class VisualizarTutorView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public VisualizarTutorView() {
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
        scroll.setBounds(10, 10, 360, 250);
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

