import java.util.Map;

class Memoria {
    private int tamanhoMemoria;
    private Particao particao;

    public Memoria(int tamanhoMemoria, Particao particao) {
        this.tamanhoMemoria = tamanhoMemoria;
        this.particao = particao;
    }

    public void alocaMemoria(Executavel comando) {
    }
    public void liberaMemoria(Executavel comando) {
    }
}