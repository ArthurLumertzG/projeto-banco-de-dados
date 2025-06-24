package view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AuxiliarController;
import controller.ClinicaController;
import database.model.Clinica;

public class AtualizarClinicaView extends JFrame {

	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel()  {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false; 
	    }
};

	private JScrollPane scroll;
	private JLabel lblAtualizar;
	private JTextField txfAtualizar;
	private JButton btnAtualizar;
	private JPanel pnlClinica;
	private JLabel lblidClinica;
	private JTextField txfidClinica;
	private JLabel lblnome;
	private JTextField txfnome;
	private JLabel lblcnpj;
	private JTextField txfcnpj;
	private JLabel lbltelefone;
	private JTextField txftelefone;
	private JTextField txfemail;
	private JLabel lblemail;
	private JLabel lblidEndereco;
	private JTextField txfidEndereco;
	protected String StringId;
	private JButton btnSelecionar;
	String nome;
	String cnpj;
	String telefone;
	String email;
	int idEndereco;

	public AtualizarClinicaView() {
		setTitle("Atualizar - Clínica");
		setSize(500, 600);
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
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(300, 230, 100, 30);
		getContentPane().add(btnSelecionar);
		
		modelo.addColumn("ID Clínica");
		modelo.addColumn("Nome");
		modelo.addColumn("CNPJ");
		modelo.addColumn("Email");
		modelo.addColumn("Telefone");
		modelo.addColumn("ID Endereço");
		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 10, 460, 140);
		getContentPane().add(scroll);
		
		try {
			List<Clinica> clinicaLista = ClinicaController.listar();

			for (Clinica clinica : clinicaLista) {
				String idClinica = clinica.getIdClinicaAsString();
				String nome = clinica.getNome();
				String cnpj = clinica.getCnpj();
				String email = clinica.getEmail();
				String telefone = clinica.getTelefone();
				String idEndereco = String.valueOf(clinica.getIdEndereco());

				modelo.addRow(new String[] {
					idClinica, nome, cnpj, email, telefone, idEndereco
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados da clínica", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		
		btnSelecionar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String StringId = txfAtualizar.getText().trim();
				if(StringId.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
					return;		
			}
				
				Integer id = Integer.parseInt(StringId);
				
				pnlClinica = new JPanel();
				pnlClinica.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Clínica"));
				pnlClinica.setBounds(0, 300, 700, 320);
				pnlClinica.setLayout(null);
				getContentPane().add(pnlClinica);
				getContentPane().revalidate();
                getContentPane().repaint();
                pnlClinica.setVisible(true);

				lblnome = new JLabel("Nome:");
				lblnome.setBounds(15, 55, 100, 20);
				pnlClinica.add(lblnome);
				txfnome = new JTextField();
				txfnome.setBounds(120, 55, 100, 20);
				pnlClinica.add(txfnome);

				lblcnpj = new JLabel("CNPJ:");
				lblcnpj.setBounds(15, 85, 100, 20);
				pnlClinica.add(lblcnpj);
				txfcnpj = new JTextField();
				txfcnpj.setBounds(120, 85, 100, 20);
				pnlClinica.add(txfcnpj);

				lbltelefone = new JLabel("Telefone:");
				lbltelefone.setBounds(15, 115, 100, 20);
				pnlClinica.add(lbltelefone);
				txftelefone = new JTextField();
				txftelefone.setBounds(120, 115, 100, 20);
				pnlClinica.add(txftelefone);

				lblemail = new JLabel("Email:");
				lblemail.setBounds(15, 145, 100, 20);
				pnlClinica.add(lblemail);
				txfemail = new JTextField();
				txfemail.setBounds(120, 145, 100, 20);
				pnlClinica.add(txfemail);

				lblidEndereco = new JLabel("ID Endereço:");
				lblidEndereco.setBounds(15, 175, 100, 20);
				pnlClinica.add(lblidEndereco);
				txfidEndereco = new JTextField();
				txfidEndereco.setBounds(120, 175, 100, 20);
				pnlClinica.add(txfidEndereco);

				btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(250, 230, 100, 25);
				pnlClinica.add(btnAtualizar);
				
				btnAtualizar.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							nome = txfnome.getText();
							cnpj = txfcnpj.getText();
							telefone = txftelefone.getText();
							email = txfemail.getText();
							idEndereco = Integer.parseInt(txfidEndereco.getText());
							ClinicaController.atualizar(id, nome, cnpj, telefone, email, idEndereco);
							JOptionPane.showMessageDialog(rootPane, "Clínica atualizada com sucesso!");
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(rootPane, "Id inválido."); 
							e1.printStackTrace();
						}
					}
				});
				
			
			}
		});	

	}
}
