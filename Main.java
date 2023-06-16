import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de alocação:");
        System.out.println("1. Partições Variáveis");
        System.out.println("2. Partições Dinâmicas");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.print("Informe o tamanho da memória: ");
            int tamanhoMemoria = scanner.nextInt();

            System.out.println("Selecione a política de alocação:");
            System.out.println("1. Worst-Fit");
            System.out.println("2. Circular-Fit");
            System.out.print("Opção: ");
            int opcaoPolitica = scanner.nextInt();

            PoliticaAlocacao politica;

            if (opcaoPolitica == 1) {
                politica = PoliticaAlocacao.WORST_FIT;
            } else if (opcaoPolitica == 2) {
                politica = PoliticaAlocacao.CIRCULAR_FIT;
            } else {
                System.out.println("Opção inválida de política de alocação.");
                return;
            }

            

        } else if (opcao == 2) {
            System.out.print("Informe o tamanho da memória: ");
            int tamanhoMemoria = scanner.nextInt();


        } else {
            System.out.println("Opção inválida.");
        }
        scanner.close();
    }
}