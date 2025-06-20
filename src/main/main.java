package main;

import database.ConnectionFactory;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import controller.ClinicaController;
import database.model.Clinica;
import view.ReciboView;

public class main {

	public static void main(String[] args) {
		
		Integer opcaoMenu = 1;
		
		do {
			
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opcoes a seguir: \n"
					+ "1 - Visualizar dados\n2 - Adicionar dados \n3 - Deletar dados \n4 - Atualizar dados \n0 - Sair"));
			
			Integer opcaoTabelas = 1;
			
			switch (opcaoMenu) {
			case 1:
				opcaoTabelas = Integer.parseInt(JOptionPane.showInputDialog("Visualizar dados de qual tabela? \n"
						+ "1 - Auxilar \n2 - Clínica\n3 - Consulta\n4 - Endereco\n5 - Pet\n6 - Recibo\n7 - Tutor\n8 - Veterinário"));
				//passa o opcaoTabelas
				//visualizaçao de tabela
				break;
				
			case 2:
				opcaoTabelas = Integer.parseInt(JOptionPane.showInputDialog("Adicionar dados a qual tabela? \n"
						+ "1 - Auxilar \n2 - Clínica\n3 - Consulta\n4 - Endereco\n5 - Pet\n6 - Recibo\n7 - Tutor\n8 - Veterinário"));
			//passa o opcaoTabelas
				if (opcaoTabelas == 1) {
					new view.AuxiliarView();
				}
				else if(opcaoTabelas == 6) {
					new view.ReciboView();
				}
				else if(opcaoTabelas == 7) {
					new view.TutorView();
				}
				else if(opcaoTabelas == 4) {
					new view.EnderecoView();
				}
				break;
				
			case 3:
				opcaoTabelas = Integer.parseInt(JOptionPane.showInputDialog("Deletar dados de qual tabela? \n"
						+ "1 - Auxilar \n2 - Clínica\n3 - Consulta\n4 - Endereco\n5 - Pet\n6 - Recibo\n7 - Tutor\n8 - Veterinário"));
				//passa o opcaoTabelas
				break;
				
			case 4:
				opcaoTabelas = Integer.parseInt(JOptionPane.showInputDialog("Atualizar dados de qual tabela? \n"
						+ "1 - Auxilar \n2 - Clínica\n3 - Consulta\n4 - Endereco\n5 - Pet\n6 - Recibo\n7 - Tutor\n8 - Veterinário"));
				//passa o opcaoTabelas
				break;

			default:
				break;
			}
			
		} while (opcaoMenu == 0);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConnectionFactory.closeConnection();
    	}));

	}

}
