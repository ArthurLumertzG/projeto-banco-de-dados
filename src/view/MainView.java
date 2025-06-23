package view;

import database.ConnectionFactory;

import javax.swing.*;
import java.awt.event.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Sistema da Clínica Veterinária");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

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

        if (acao.equals("Adicionar")) {
            switch (tabelaSelecionada) {
                case "Auxiliar":
                    new AdicionarAuxiliarView();
                    break;
                    
                case "Clinica":
                	new AdicionarClinicaView();
                	break;
                	
                case "Consulta":
                	new AdicionarConsultaView();
                	break;
                	
                case "Endereco":
                    new AdicionarEnderecoView();
                    break;
                    
                case "Pet":
                	new AdicionarPetView();
                	break;
                	
                case "Recibo":
                    new AdicionarReciboView();
                    break;
                    
                case "Tutor":
                    new AdicionarTutorView();
                    break;
                    
                case "Veterinario":
                	new AdicionarVeterinarioView();
                	break;
                
                default:
                    JOptionPane.showMessageDialog(this, "Formulário ainda não implementado.");
                    return;
            }
        }
        else if (acao.equals("Visualizar")) {
            switch (tabelaSelecionada) {
            case "Auxiliar":
                new VisualizarAuxiliarView();
                break;
                
            case "Clinica":
            	new VisualizarClinicaView();
            	break;
            	
            case "Consulta":
            	new VisualizarConsultaView();
            	break;
            	
            case "Endereco":
                new VisualizarEnderecoView();
                break;
                
            case "Pet":
            	new VisualizarPetView();
            	break;
            	
            case "Recibo":
                new VisualizarReciboView();
                break;
                
            case "Tutor":
                new VisualizarTutorView();
                break;
                
            case "Veterinario":
            	new VisualizarVeterinarioView();
            	break;
            
            default:
                JOptionPane.showMessageDialog(this, "Formulário ainda não implementado.");
                return;
        }
    } 
        else if (acao.equals("Atualizar")) {
        	 switch (tabelaSelecionada) {
             case "Auxiliar":
                 new AtualizarAuxiliarView();
                 break;
                 
             case "Clinica":
             	new AtualizarClinicaView();
             	break;
             	
             case "Consulta":
             	new AtualizarConsultaView();
             	break;
             	
             case "Endereco":
                 new AtualizarEnderecoView();
                 break;
                 
             case "Pet":
             	new AtualizarPetView();
             	break;
             	
             case "Recibo":
                 new AtualizarReciboView();
                 break;
                 
             case "Tutor":
                 new AtualizarTutorView();
                 break;
                 
             case "Veterinario":
             	new AtualizarVeterinarioView();
             	break;
             
             default:
                 JOptionPane.showMessageDialog(this, "Formulário ainda não implementado.");
                 return;
         }
        }
        else if (acao.equals("Deletar")) {
        	 switch (tabelaSelecionada) {
             case "Auxiliar":
                 new DeletarAuxiliarView();
                 break;
                 
             case "Clinica":
             	new DeletarClinicaView();
             	break;
             	
             case "Consulta":
             	new DeletarConsultaView();
             	break;
             	
             case "Endereco":
                 new DeletarEnderecoView();
                 break;
                 
             case "Pet":
             	new DeletarPetView();
             	break;
             	
             case "Recibo":
                 new DeletarReciboView();
                 break;
                 
             case "Tutor":
                 new DeletarTutorView();
                 break;
                 
             case "Veterinario":
             	new DeletarVeterinarioView();
             	break;
             
             default:
                 JOptionPane.showMessageDialog(this, "Formulário ainda não implementado.");
                 return;
         }
        } else {
        	JOptionPane.showMessageDialog(this, acao + " - Ação ainda não implementada para a tabela " + tabelaSelecionada);
        }
    }
     
    }


