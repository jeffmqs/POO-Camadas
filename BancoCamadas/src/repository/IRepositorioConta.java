package repository;

import java.util.ArrayList;

import entity.Conta;

public interface IRepositorioConta {
	
	public void inserirConta(Conta c);
	public void alterarConta(Conta c);
	public void removerConta(Conta c);
	public Conta buscarConta(int numero);
	public boolean verificarExistenciaDeConta(int numero);
	public ArrayList<Conta> buscarTodas();

}
