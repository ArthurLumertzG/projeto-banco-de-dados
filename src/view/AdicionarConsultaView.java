package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import database.model.Veterinario;
import database.model.Auxiliar;
import database.model.Pet;
import controller.VeterinarioController;
import controller.AuxiliarController;
import controller.PetController;
import controller.ConsultaController;
import utils.DateLabelFormatter;

public class AdicionarConsultaView extends JFrame {

    private JPanel pnlConsulta;
    private JComboBox<Veterinario> cbVeterinario;
    private JLabel lblVeterinario;
    private JComboBox<Auxiliar> cbAuxiliar;
    private JLabel lblAuxiliar;
    private JComboBox<Pet> cbPet;
    private JLabel lblPet;
    private JDatePickerImpl datePicker;
    private JLabel lblDataHora;
    private JLabel lblMotivo;
    private javax.swing.JTextField txfMotivo;
    private JLabel lblDiagnostico;
    private javax.swing.JTextField txfDiagnostico;
    private JLabel lblTratamento;
    private javax.swing.JTextField txfTratamento;
    private JButton btnEnviar;

    public AdicionarConsultaView() {
        setTitle("Clínica Veterinária - Consulta");
        setSize(400, 380);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponent();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        pnlConsulta = new JPanel();
        pnlConsulta.setBorder(BorderFactory.createTitledBorder("Consulta"));
        pnlConsulta.setBounds(0, 0, 400, 380);
        pnlConsulta.setLayout(null);
        getContentPane().add(pnlConsulta);

        lblVeterinario = new JLabel("Veterinário:");
        lblVeterinario.setBounds(15, 20, 100, 20);
        pnlConsulta.add(lblVeterinario);
        try {
            List<Veterinario> listaVeterinarios = VeterinarioController.listar();
            cbVeterinario = new JComboBox<>(new Vector<>(listaVeterinarios));
            cbVeterinario.setBounds(15, 40, 150, 20);
            cbVeterinario.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Veterinario) {
                        Veterinario veterinario = (Veterinario) value;
                        setText(veterinario.getIdVeterinario() + " – " + veterinario.getNome());
                    }
                    return this;
                }
            });
            pnlConsulta.add(cbVeterinario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar veterinários:\n" + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        lblAuxiliar = new JLabel("Auxiliar:");
        lblAuxiliar.setBounds(200, 20, 100, 20);
        pnlConsulta.add(lblAuxiliar);
        try {
            List<Auxiliar> listaAuxiliares = AuxiliarController.listar();
            cbAuxiliar = new JComboBox<>(new Vector<>(listaAuxiliares));
            cbAuxiliar.setBounds(200, 40, 150, 20);
            cbAuxiliar.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Auxiliar) {
                        Auxiliar auxiliar = (Auxiliar) value;
                        setText(auxiliar.getIdAuxiliar() + " – " + auxiliar.getNome());
                    }
                    return this;
                }
            });
            pnlConsulta.add(cbAuxiliar);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar auxiliares:\n" + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        lblPet = new JLabel("Pet:");
        lblPet.setBounds(15, 80, 100, 20);
        pnlConsulta.add(lblPet);
        try {
            List<Pet> listaPets = PetController.listar();
            cbPet = new JComboBox<>(new Vector<>(listaPets));
            cbPet.setBounds(15, 100, 150, 20);
            cbPet.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Pet) {
                        Pet pet = (Pet) value;
                        setText(pet.getIdPet() + " – " + pet.getNome());
                    }
                    return this;
                }
            });
            pnlConsulta.add(cbPet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar pets:\n" + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        lblDataHora = new JLabel("Data/Hora:");
        lblDataHora.setBounds(200, 80, 100, 20);
        pnlConsulta.add(lblDataHora);
        UtilDateModel dateModel = new UtilDateModel();
        Properties dateProperties = new Properties();
        dateProperties.put("text.today", "Hoje");
        dateProperties.put("text.month", "Mês");
        dateProperties.put("text.year", "Ano");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, dateProperties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(200, 100, 150, 30);
        pnlConsulta.add(datePicker);

        lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(15, 140, 100, 20);
        pnlConsulta.add(lblMotivo);
        txfMotivo = new javax.swing.JTextField();
        txfMotivo.setBounds(15, 160, 150, 20);
        pnlConsulta.add(txfMotivo);

        lblDiagnostico = new JLabel("Diagnóstico:");
        lblDiagnostico.setBounds(15, 185, 100, 20);
        pnlConsulta.add(lblDiagnostico);
        txfDiagnostico = new javax.swing.JTextField();
        txfDiagnostico.setBounds(15, 205, 150, 20);
        pnlConsulta.add(txfDiagnostico);

        lblTratamento = new JLabel("Tratamento:");
        lblTratamento.setBounds(15, 230, 100, 20);
        pnlConsulta.add(lblTratamento);
        txfTratamento = new javax.swing.JTextField();
        txfTratamento.setBounds(15, 250, 150, 20);
        pnlConsulta.add(txfTratamento);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(150, 300, 100, 25);
        pnlConsulta.add(btnEnviar);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Veterinario veterinarioSelecionado = (Veterinario) cbVeterinario.getSelectedItem();
                Auxiliar auxiliarSelecionado = (Auxiliar) cbAuxiliar.getSelectedItem();
                Pet petSelecionado = (Pet) cbPet.getSelectedItem();
                Object selectedDate = datePicker.getModel().getValue();
                String motivo = txfMotivo.getText().trim();
                String diagnostico = txfDiagnostico.getText().trim();
                String tratamento = txfTratamento.getText().trim();

                if (veterinarioSelecionado == null) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Selecione um veterinário válido.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbVeterinario.requestFocus();
                    return;
                }
                if (auxiliarSelecionado == null) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Selecione um auxiliar válido.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbAuxiliar.requestFocus();
                    return;
                }
                if (petSelecionado == null) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Selecione um pet válido.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    cbPet.requestFocus();
                    return;
                }
                if (selectedDate == null) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Selecione a data e hora.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (motivo.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Preencha o campo Motivo.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfMotivo.requestFocus();
                    return;
                }
                if (diagnostico.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Preencha o campo Diagnóstico.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfDiagnostico.requestFocus();
                    return;
                }
                if (tratamento.isEmpty()) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Preencha o campo Tratamento.", "Campo Obrigatório",
                            JOptionPane.WARNING_MESSAGE);
                    txfTratamento.requestFocus();
                    return;
                }

                try {
                    java.util.Date utilDate = (java.util.Date) selectedDate;
                    Instant instant = utilDate.toInstant();
					LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
					Date dataConsulta = Date.valueOf(localDate);

                    int idVeterinario = veterinarioSelecionado.getIdVeterinario();
                    int idAuxiliar = auxiliarSelecionado.getIdAuxiliar();
                    int idPet = petSelecionado.getIdPet();

                    ConsultaController.inserir(idVeterinario, idAuxiliar, idPet, dataConsulta, motivo, diagnostico, tratamento);

                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Consulta cadastrada com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(AdicionarConsultaView.this,
                            "Erro ao salvar consulta:\n" + exception.getMessage(),
                            "Erro de Banco", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                } catch (Exception ex) {
					javax.swing.JOptionPane.showMessageDialog(AdicionarConsultaView.this,
							"Erro ao gravar consulta:\n" + ex.getMessage(), "Erro de Banco",
							javax.swing.JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
            }
        });
    }
}
