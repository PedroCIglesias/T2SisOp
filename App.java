import java.util.Scanner;

import memoria.Memoria;
import memoria.ParticaoDefinida;
import memoria.ParticaoVariavel;
import memoria.PoliticaAlocacao;
import sisOp.SistemaOperacional;

public class App {
  public static void start() {
    menu();
  }

  private static void menu() {
    Memoria memoria = null;
    SistemaOperacional sisOp;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      int tamanhoMemoria;

      while (true) {
        System.out.print("Informe o tamanho da memoria: ");
        tamanhoMemoria = scanner.nextInt();
        if (validaTamanhoMemoria(tamanhoMemoria))
          break;
        else
          System.out.println("Tamanho da memoria necessita ser uma potencia de 2 (dois)");
      }

      System.out.println("Selecione o tipo de alocacao:");
      System.out.println("1. Particoes Variaveis");
      System.out.println("2. Particoes Definidas (Buddy)");
      System.out.print("Opcao: ");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Selecione a politica de alocacao:");
        System.out.println("1. Worst-Fit");
        System.out.println("2. Circular-Fit");
        System.out.print("Opcao: ");
        int opcaoPolitica = scanner.nextInt();

        PoliticaAlocacao politica;

        if (opcaoPolitica == 1) {
          politica = PoliticaAlocacao.WORST_FIT;
        } else if (opcaoPolitica == 2) {
          politica = PoliticaAlocacao.CIRCULAR_FIT;
        } else {
          System.out.println("Opcao inválida de politica de alocacao.");
          continue;
        }

        memoria = new Memoria(tamanhoMemoria, new ParticaoVariavel(politica));

      } else if (opcao == 2) {
        memoria = new Memoria(tamanhoMemoria, new ParticaoDefinida());

      } else {
        System.out.println("Opcao invalida.");
        continue;
      }
      sisOp = new SistemaOperacional(memoria);
      sisOp.executar();
      break;
    }
    scanner.close();
  }

  private static boolean validaTamanhoMemoria(int tamanho) {
    return (tamanho & (tamanho - 1)) == 0 && tamanho != 0;
  }
}
