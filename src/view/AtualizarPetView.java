package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.PetController;
import database.model.Pet;
import utils.DateLabelFormatter;

public class AtualizarPetView extends JFrame {

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
    private JPanel pnlPet;
    private JLabel lblidPet;
    private JTextField txfidPet;
    private JLabel lblnome;
    private JTextField txfnome;
    private JTextField txfespecie;
    private JLabel lblespecie;
    private JLabel lblraca;
    private JTextField txfraca;
    private JButton btnenviar;
    private JTextField txfidTutor;
    private JLabel lblidTutor;
	private JDatePickerImpl datePicker;

    public AtualizarPetView() {
        setTitle("Atualizar - Pet");
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

        modelo.addColumn("ID Pet");
        modelo.addColumn("Nome");
        modelo.addColumn("Data Nascimento");
        modelo.addColumn("Espécie");
        modelo.addColumn("Raça");
        modelo.addColumn("ID Tutor");

        tabela = new JTable(modelo);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 650, 200);
        getContentPane().add(scroll);

        try {
            List<Pet> petLista = PetController.listar();
            for (Pet pet : petLista) {
                modelo.addRow(new String[] {
                    pet.getIdPetAsString(),
                    pet.getNome(),
                    pet.getDataNascimentoAsString(),				
                    pet.getEspecie(),
                    pet.getRaca(),
                    pet.getIdTutorAsString()
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

        		pnlPet = new JPanel();
        		pnlPet.setBorder(BorderFactory.createTitledBorder("Clínica Veterinária - Pet"));
        		pnlPet.setBounds(0, 300, 700, 350);
        		pnlPet.setLayout(null);
        		getContentPane().add(pnlPet);
        		getContentPane().revalidate();
                getContentPane().repaint();
                pnlPet.setVisible(true);

        		lblnome = new JLabel("Nome:");
        		lblnome.setBounds(15, 55, 100, 20);
        		pnlPet.add(lblnome);
        		txfnome = new JTextField();
        		txfnome.setBounds(120, 55, 100, 20);
        		pnlPet.add(txfnome);

        		JLabel lbldataNascimento = new JLabel("Data de Nascimento:");
        		lbldataNascimento.setBounds(15, 85, 200, 20);
        		pnlPet.add(lbldataNascimento);

        		UtilDateModel model = new UtilDateModel();
        		Properties p = new Properties();
        		p.put("text.today", "Hoje");
        		p.put("text.month", "Mês");
        		p.put("text.year", "Ano");

        		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        		datePicker.setBounds(150, 85, 130, 20);
        		pnlPet.add(datePicker);
       

        		lblespecie = new JLabel("Espécie:");
        		lblespecie.setBounds(15, 115, 100, 20);
        		pnlPet.add(lblespecie);
        		txfespecie = new JTextField();
        		txfespecie.setBounds(120, 115, 100, 20);
        		pnlPet.add(txfespecie);

        		lblraca = new JLabel("Raça:");
        		lblraca.setBounds(15, 145, 100, 20);
        		pnlPet.add(lblraca);
        		txfraca = new JTextField();
        		txfraca.setBounds(120, 145, 100, 20);
        		pnlPet.add(txfraca);

        		lblidTutor = new JLabel("ID Tutor:");
        		lblidTutor.setBounds(15, 175, 100, 20);
        		pnlPet.add(lblidTutor);
        		txfidTutor = new JTextField();
        		txfidTutor.setBounds(120, 175, 100, 20);
        		pnlPet.add(txfidTutor);

        		btnenviar = new JButton("Enviar");
        		btnenviar.setBounds(270, 200, 100, 25);
        		pnlPet.add(btnenviar);

                btnenviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String nome = txfnome.getText();
                            Object dataNascimento = datePicker.getModel().getValue();
                            String especie = txfespecie.getText();
                            String raca = txfraca.getText();
                            String idTutorStr = txfidTutor.getText();
                            
                            Integer idTutor = Integer.parseInt(idTutorStr);
                            
                            java.util.Date utilDate = (java.util.Date) dataNascimento;
        					Instant instant = utilDate.toInstant();
        					LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        					Date dataFormatada = Date.valueOf(localDate);
                            
                            PetController.atualizar(id, idTutor, nome, dataFormatada, especie, raca);
                            JOptionPane.showMessageDialog(rootPane, "Pet atualizado com sucesso!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar pet.");
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPane, "ID Tutor deve ser um número válido.");
                        }
                    }
                });
            }
        });
    }
}