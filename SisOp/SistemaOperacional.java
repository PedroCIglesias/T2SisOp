package sisOp;

import java.util.ArrayList;

import memoria.Memoria;

public class SistemaOperacional {
    private Memoria memoria;
    private Compilador compilador;

    public SistemaOperacional(Memoria memoria) {
        this.memoria = memoria;
        compilador = new Compilador();
    }

    public void executar() {
        ArrayList<Executavel> codigoExecutavel = compilador.lerArquivo("codigo.txt");
        for (Executavel executavel : codigoExecutavel) {
            System.out.println(
                    executavel.getTipo() + "(" + executavel.processo.id + ", " + executavel.processo.tamanho + ")");
            if (executavel.getTipo() == Executavel.Tipo.IN) {
                memoria.alocaMemoria(executavel.getProcesso());
            } else {
                memoria.liberaMemoria(executavel.getProcesso());
            }
        }
    }
}