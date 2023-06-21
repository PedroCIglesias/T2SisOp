package memoria;

import sisOp.Processo;

public class Memoria {
    private int tamanhoMemoria;
    private Particao particao;
    private BuddySystem buddySystem;

    public Memoria(int tamanhoMemoria, Particao particao) {
        this.tamanhoMemoria = tamanhoMemoria;
        this.particao = particao;
        this.buddySystem = new BuddySystem(tamanhoMemoria);
    }

    public void alocaMemoria(Processo processo) {
        if (particao instanceof ParticaoDefinida) {
            buddySystem.alocar(processo);
        } else {
        }
    }

    public void liberaMemoria(Processo processo) {
        if (particao instanceof ParticaoDefinida) {
            buddySystem.desalocar(processo);
        } else {
        }
    }
}