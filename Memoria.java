class Memoria {
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

        } else {
            buddySystem.alocar(processo);
        }
    }

    public void liberaMemoria(Processo processo) {
        if (particao instanceof ParticaoDefinida) {

        } else {
            buddySystem.desalocar(processo);
        }
    }
}