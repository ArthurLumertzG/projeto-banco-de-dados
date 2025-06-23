package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.VeterinarioController;
import database.model.Veterinario;

public class VisualizarVeterinarioView extends JFrame {
    
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public VisualizarVeterinarioView() {
        setTitle("Visualizar - Veterinário");
        setSize(650, 300);
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
        modelo.addColumn("ID Clínica");
        modelo.addColumn("CPF");
        modelo.addColumn("CRMV");
        modelo.addColumn("Email");
        modelo.addColumn("Especialidade");
        modelo.addColumn("Telefone");
        modelo.addColumn("ID Endereço");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 610, 250);
        getContentPane().add(scroll);

        try {
            List<Veterinario> veterinarioLista = VeterinarioController.listar();

            for (Veterinario veterinario : veterinarioLista) {
                String idVeterinario = veterinario.getIdVeterinarioAsString();
                String nome = veterinario.getNome();
                String idClinica = veterinario.getIdClinicaAsString();
                String cpf = veterinario.getCpf();
                String crmv = veterinario.getCrmv();
                String email = veterinario.getEmail();
                String especialidade = veterinario.getEspecialidade();
                String telefone = veterinario.getTelefone();
                String idEndereco = veterinario.getIdEnderecoAsString();

                modelo.addRow(new String[]{
                    idVeterinario, nome, idClinica, cpf, crmv, email, especialidade, telefone, idEndereco
                });
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
