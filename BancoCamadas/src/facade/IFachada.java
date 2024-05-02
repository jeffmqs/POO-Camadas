package facade;

import entity.Conta;
import java.util.ArrayList;

public interface IFachada {
  public void inserirConta(Conta c);

  public void alterarConta(Conta c);

  public boolean removerConta(int numero);

  public Conta buscarConta(int numero);

  public ArrayList<Conta> buscarTodas();

  public boolean verificarExistenciaDeConta(int numero);
}
