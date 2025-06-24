package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.VeterinarioController;
import database.model.Veterinario;

public class DeletarVeterinarioView extends JFrame {
    
   	private JTable tabela;
		private DefaultTableModel modelo;
		private JScrollPane scroll;
		private JLabel lblDeletar;
		private JTextField txfDeletar;
		private JButton btnDeletar;

    public DeletarVeterinarioView() {
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
						VeterinarioController.deletar(id);
						JOptionPane.showMessageDialog(rootPane, "Deletado com sucesso!");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
						e1.printStackTrace();
					}
				}
			});
			
			
			modelo = new DefaultTableModel();
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
        scroll.setBounds(10, 10, 610, 150);
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
            //id da linha ser excluida vai ter que ter um text field e um botao excluir

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
