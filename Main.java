import java.util.Scanner;

import memoria.Memoria;
import memoria.ParticaoDefinida;
import memoria.ParticaoVariavel;
import memoria.PoliticaAlocacao;
import sisOp.SistemaOperacional;

public class Main {
    public static void main(String[] args) {
        Memoria memoria = null;
        SistemaOperacional sisOp;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de alocacao:");
        System.out.println("1. Particoes Variaveis");
        System.out.println("2. Particoes Definidas");
        System.out.print("Opcao: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.print("Informe o tamanho da memoria: ");
            int tamanhoMemoria = scanner.nextInt();

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
                return;
            }

            memoria = new Memoria(tamanhoMemoria,new ParticaoVariavel(politica));

            

        } else if (opcao == 2) {
            System.out.print("Informe o tamanho da memoria: ");
            int tamanhoMemoria = scanner.nextInt();
            memoria = new Memoria(tamanhoMemoria, new ParticaoDefinida());

        } else {
            System.out.println("Opcao invalida.");
        }

        sisOp = new SistemaOperacional(memoria);
        sisOp.executar();
        scanner.close();
    }
}