package facade;

import entity.Conta;
import java.util.ArrayList;
import repository.IRepositorioConta;
import repository.RepositorioContaArrayList;

public class Fachada implements IFachada {

  private IRepositorioConta repositorioConta;

  public Fachada() {
    this.repositorioConta = new RepositorioContaArrayList();
  }

  @Override
  public void inserirConta(Conta c) {
    repositorioConta.inserirConta(c);
  }

  @Override
  public void alterarConta(Conta c) {
    repositorioConta.alterarConta(c);
  }

  @Override
  public boolean removerConta(int numero) { // Alteração feita aqui
    Conta conta = repositorioConta.buscarConta(numero);
    if (conta != null) {
      repositorioConta.removerConta(conta);
      return true; // Retorna true se a conta foi removida com sucesso
    } else {
      return false; // Retorna false se a conta não foi encontrada para remover
    }
  }

  @Override
  public Conta buscarConta(int numero) {
    return repositorioConta.buscarConta(numero);
  }

  @Override
  public ArrayList<Conta> buscarTodas() {
    return repositorioConta.buscarTodas();
  }

  @Override
  public boolean verificarExistenciaDeConta(int numero) {
    return repositorioConta.verificarExistenciaDeConta(numero);
  }
}
