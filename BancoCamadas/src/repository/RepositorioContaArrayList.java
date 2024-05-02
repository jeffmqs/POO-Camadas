package repository;

import java.util.ArrayList;

import entity.Conta;

public class RepositorioContaArrayList implements IRepositorioConta {
	
	private ArrayList<Conta> contas;
	
	public RepositorioContaArrayList() {
		this.contas = new ArrayList<Conta>();
	}

	@Override
	public void inserirConta(Conta c) {
		this.contas.add(c);
	}

	@Override
	public void alterarConta(Conta c) {
		if (this.verificarExistenciaDeConta(c.getNumero())) {
			this.contas.set(this.buscarIndiceDeConta(c),c);
		}
		
	}

	@Override
	public void removerConta(Conta c) {
		this.contas.remove(c);
	}

	@Override
	public Conta buscarConta(int numero) {
		for (int i = 0; i < this.contas.size(); i++) {
			Conta temp = contas.get(i);
			if (temp.getNumero() == numero) 
				return temp;
		}
		return null;
	}
	
	private int buscarIndiceDeConta(Conta c) {
		return buscarIndiceDeConta(c.getNumero());
	}
	
	private int buscarIndiceDeConta(int numero) {
		for (int i = 0; i < this.contas.size(); i++) {
			Conta temp = contas.get(i);
			if (temp.getNumero() == numero) 
				return i;
		}
		return -1;
	}

	@Override
	public boolean verificarExistenciaDeConta(int numero) {
		return (this.buscarConta(numero) != null);
	}

	@Override
	public ArrayList<Conta> buscarTodas() {
		return contas;
	}

}
