package ui;

import entity.Conta;
import facade.Fachada;
import facade.IFachada;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceUsuario {

  private IFachada fachada;

  public InterfaceUsuario() {
    this.fachada = new Fachada(); // Instanciando a fachada para acessar os serviços
  }

  public void menuPrincipal() {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("-------- Menu Principal --------");
      System.out.println("1. Inserir Conta");
      System.out.println("2. Buscar Conta");
      System.out.println("3. Remover Conta");
      System.out.println("4. Alterar Conta");
      System.out.println("5. Verificar Existência de Conta");
      System.out.println("6. Imprimir Relatório com Todas as Contas");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          inserirConta();
          break;
        case 2:
          buscarConta();
          break;
        case 3:
          removerConta();
          break;
        case 4:
          alterarConta();
          break;
        case 5:
          verificarExistenciaConta();
          break;
        case 6:
          imprimirRelatorio();
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    } while (opcao != 0);

    scanner.close();
  }

  public void inserirConta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o número da conta: ");
    int numero = scanner.nextInt();
    // Preencher os demais dados da conta
    Conta conta = new Conta();
    conta.setNumero(numero);
    // Adicionar demais atributos da conta
    fachada.inserirConta(conta);
    System.out.println("Conta inserida com sucesso!");
  }

  public void buscarConta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o número da conta a ser buscada: ");
    int numero = scanner.nextInt();
    Conta conta = fachada.buscarConta(numero);
    if (conta != null) {
      System.out.println("Conta encontrada:");
      System.out.println("Número: " + conta.getNumero());
      // Imprimir demais informações da conta
    } else {
      System.out.println("Conta não encontrada!");
    }
  }

  public void removerConta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o número da conta a ser removida: ");
    int numero = scanner.nextInt();
    boolean removido = fachada.removerConta(numero);
    if (removido) {
      System.out.println("Conta removida com sucesso!");
    } else {
      System.out.println(
        "Não foi possível remover a conta. Verifique o número informado."
      );
    }
  }

  public void alterarConta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o número da conta a ser alterada: ");
    int numero = scanner.nextInt();
    Conta conta = fachada.buscarConta(numero);
    if (conta != null) {
      // Aqui você pode implementar a lógica para permitir a alteração dos dados da conta
      // Exemplo: solicitar novos dados ao usuário e setar na conta atual
      fachada.alterarConta(conta);
      System.out.println("Conta alterada com sucesso!");
    } else {
      System.out.println("Conta não encontrada!");
    }
  }

  public void verificarExistenciaConta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o número da conta a ser verificada: ");
    int numero = scanner.nextInt();
    boolean existe = fachada.verificarExistenciaDeConta(numero);
    if (existe) {
      System.out.println("A conta existe!");
    } else {
      System.out.println("A conta não existe!");
    }
  }

  public void imprimirRelatorio() {
    ArrayList<Conta> contas = fachada.buscarTodas();
    if (!contas.isEmpty()) {
      System.out.println("Relatório de Contas:");
      for (Conta conta : contas) {
        System.out.println("Número: " + conta.getNumero());
        // Imprimir demais informações da conta
      }
    } else {
      System.out.println(
        "Não há contas cadastradas para imprimir o relatório."
      );
    }
  }

  public static void main(String[] args) {
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
    interfaceUsuario.menuPrincipal();
  }
}
