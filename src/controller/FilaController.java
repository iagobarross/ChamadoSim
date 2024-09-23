package controller;

import br.edu.fateczl.Fila.Fila;
import model.Cliente;


public class FilaController {
	
	private int prioritarios;


	public FilaController() {
		super();
	}
	
	public void insereCliente(Cliente cliente, Fila<Cliente> f) {
		f.insert(cliente);
	}
	
	private Cliente atender (Fila<Cliente> f) {
		
		Cliente cliente = null;
		if(!f.isEmpty()) {
			try {
				cliente = f.remove();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("Fila vazia");
			return null;
		}
		return cliente;
	}
	
	public void chamarProximo(Fila<Cliente> filaPrioritarios, Fila<Cliente>fila) {
		
		Cliente clienteAtendido = null;
		
		if(!filaPrioritarios.isEmpty() && prioritarios < 3) {
			clienteAtendido = atender(filaPrioritarios);
			System.out.println("Atendendo prioritário : " + clienteAtendido);
			prioritarios++;
		} else if(!fila.isEmpty()) {
			clienteAtendido = atender(fila);
			System.out.println("Atendendo não-prioritário: " + clienteAtendido);
			prioritarios = 0;
		} else if (!filaPrioritarios.isEmpty()) {
			clienteAtendido = atender(filaPrioritarios);
			System.out.println("Atendendo prioritário : " + clienteAtendido);
		} else {
			System.out.println("Fila Vazia");
		}
	}
	

}
