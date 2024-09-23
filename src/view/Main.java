package view;

import br.edu.fateczl.Fila.*;
import javax.swing.JOptionPane;
import controller.FilaController;
import model.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Fila fila = new Fila();
		Fila filaPrioritarios = new Fila();
		FilaController fCont = new FilaController();
		
		int opc = 0;
		int contadorCliente = 0;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n1- Inserir Cliente\n2- Inserir Cliente Prioritário\n3- Atender\n9-Fim"));
			switch(opc) {
				case 1:
					String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
					Cliente cliente = new Cliente(contadorCliente+1, nome);
					fCont.insereCliente(cliente, fila);
					contadorCliente++;
					break;
				
				case 2:
					String nomePrioritario = JOptionPane.showInputDialog("Digite o nome do cliente: ");
					Cliente clientePrioritario = new Cliente(contadorCliente+1, nomePrioritario);
					fCont.insereCliente(clientePrioritario, filaPrioritarios);
					contadorCliente++;
					break;
					
				case 3:
					fCont.chamarProximo(filaPrioritarios, fila);
					break;
					
				case 9:
					JOptionPane.showMessageDialog(null, "Fim");
					System.exit(0);
					
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
					
			}
		}
		
	}

}
