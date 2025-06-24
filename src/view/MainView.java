package view;

import database.ConnectionFactory;
import utils.DatabasePopulator;

import javax.swing.*;
import java.awt.event.*;

public class MainView extends JFrame {
	
	

    public MainView() {
    	
    	JButton btnFaturamento;
    	JButton btnConsultasporClinica;
    	JButton btnConsultasporMes;
    	JButton btnPopularBanco;
    	JLabel lblDesenvolvido;
    	
    	btnPopularBanco = new JButton("Popular banco de dados");
    	btnPopularBanco.setBounds(50, 550, 400, 20);
    	getContentPane().add(btnPopularBanco);
    	btnPopularBanco.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DatabasePopulator.populate();
				JOptionPane.showMessageDialog(rootPane, "Banco populado com sucesso");
			}
		});
    	
    	lblDesenvolvido = new JLabel("<html><span style='font-size:8px;'>"
    		    + "Desenvolvido por:<br>Arthur Lumertz, Carlos Miguel Webber, "
    		    + "Davi da Silva Valvassori e Gabriel Pereira José.</span></html>");
    		lblDesenvolvido.setBounds(5, 0, 600, 60);
    		getContentPane().add(lblDesenvolvido);
    	
    	btnFaturamento = new JButton("Consultar Faturamento mensal");
    	btnFaturamento.setBounds(50, 460, 400, 20);
    	getContentPane().add(btnFaturamento);
    	btnFaturamento.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new view.FaturamentoView();
			}
		});
    	
    	btnConsultasporClinica = new JButton("Consultar consultas por clínica");
    	btnConsultasporClinica.setBounds(50, 490, 400, 20);
    	getContentPane().add(btnConsultasporClinica);
    	btnConsultasporClinica.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new view.ConsultasPorClinicaView();
			}
		});
    	
    	btnConsultasporMes = new JButton("Consultar consultas realizadas em cada mês");
    	btnConsultasporMes.setBounds(50, 520, 400, 20);
    	getContentPane().add(btnConsultasporMes);
    	btnConsultasporMes.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new view.ConsultasPorMesView();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
    	
        setTitle("Sistema da Clínica Veterinária");
        setSize(500, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null); 

    
        ImageIcon logo = new ImageIcon("assets/logo.jpg"); 
        JLabel labelImagem = new JLabel(logo);
        labelImagem.setBounds((500 - logo.getIconWidth()) / 2, 50, logo.getIconWidth(), logo.getIconHeight());
        add(labelImagem);
       
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem visualizarItem = new JMenuItem("Visualizar Dados");
        JMenuItem adicionarItem = new JMenuItem("Adicionar Dados");
        JMenuItem deletarItem = new JMenuItem("Deletar Dados");
        JMenuItem atualizarItem = new JMenuItem("Atualizar Dados");
        JMenuItem sairItem = new JMenuItem("Sair");

        menu.add(visualizarItem);
        menu.add(adicionarItem);
        menu.add(deletarItem);
        menu.add(atualizarItem);
        menu.addSeparator();
        menu.add(sairItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        visualizarItem.addActionListener(e -> {
            try {
                selecionarTabela("Visualizar");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        adicionarItem.addActionListener(e -> {
            try {
                selecionarTabela("Adicionar");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        deletarItem.addActionListener(e -> {
            try {
                selecionarTabela("Deletar");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        atualizarItem.addActionListener(e -> {
            try {
                selecionarTabela("Atualizar");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        sairItem.addActionListener(e -> {
            ConnectionFactory.closeConnection();
            System.exit(0);
        });

        setVisible(true);
    }

    private void selecionarTabela(String acao) throws Exception {
        String[] tabelas = {"Auxiliar", "Clinica", "Consulta", "Endereco", "Pet", "Recibo", "Tutor", "Veterinario"};
        String tabelaSelecionada = (String) JOptionPane.showInputDialog(
                this,
                acao + " dados de qual tabela?",
                acao + " Dados",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tabelas,
                tabelas[0]
        );

        if (tabelaSelecionada == null) return;

        switch (acao) {
            case "Adicionar":
                switch (tabelaSelecionada) {
                    case "Auxiliar": new AdicionarAuxiliarView(); break;
                    case "Clinica": new AdicionarClinicaView(); break;
                    case "Consulta": new AdicionarConsultaView(); break;
                    case "Endereco": new AdicionarEnderecoView(); break;
                    case "Pet": new AdicionarPetView(); break;
                    case "Recibo": new AdicionarReciboView(); break;
                    case "Tutor": new AdicionarTutorView(); break;
                    case "Veterinario": new AdicionarVeterinarioView(); break;
                    default: JOptionPane.showMessageDialog(this, "Formulário ainda não implementado."); return;
                }
                break;

            case "Visualizar":
                switch (tabelaSelecionada) {
                    case "Auxiliar": new VisualizarAuxiliarView(); break;
                    case "Clinica": new VisualizarClinicaView(); break;
                    case "Consulta": new VisualizarConsultaView(); break;
                    case "Endereco": new VisualizarEnderecoView(); break;
                    case "Pet": new VisualizarPetView(); break;
                    case "Recibo": new VisualizarReciboView(); break;
                    case "Tutor": new VisualizarTutorView(); break;
                    case "Veterinario": new VisualizarVeterinarioView(); break;
                    default: JOptionPane.showMessageDialog(this, "Formulário ainda não implementado."); return;
                }
                break;

            case "Atualizar":
                switch (tabelaSelecionada) {
                    case "Auxiliar": new AtualizarAuxiliarView(); break;
                    case "Clinica": new AtualizarClinicaView(); break;
                    case "Consulta": new AtualizarConsultaView(); break;
                    case "Endereco": new AtualizarEnderecoView(); break;
                    case "Pet": new AtualizarPetView(); break;
                    case "Recibo": new AtualizarReciboView(); break;
                    case "Tutor": new AtualizarTutorView(); break;
                    case "Veterinario": new AtualizarVeterinarioView(); break;
                    default: JOptionPane.showMessageDialog(this, "Formulário ainda não implementado."); return;
                }
                break;

            case "Deletar":
                switch (tabelaSelecionada) {
                    case "Auxiliar": new DeletarAuxiliarView(); break;
                    case "Clinica": new DeletarClinicaView(); break;
                    case "Consulta": new DeletarConsultaView(); break;
                    case "Endereco": new DeletarEnderecoView(); break;
                    case "Pet": new DeletarPetView(); break;
                    case "Recibo": new DeletarReciboView(); break;
                    case "Tutor": new DeletarTutorView(); break;
                    case "Veterinario": new DeletarVeterinarioView(); break;
                    default: JOptionPane.showMessageDialog(this, "Formulário ainda não implementado."); return;
                }
                break;

            default:
                JOptionPane.showMessageDialog(this, acao + " - Ação ainda não implementada para a tabela " + tabelaSelecionada);
        }
    }
}
