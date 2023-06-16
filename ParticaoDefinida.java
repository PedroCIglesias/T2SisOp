public class ParticaoDefinida implements Particao {
    private int tamanho;

    public ParticaoDefinida(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}