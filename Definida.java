public class Definida implements Particao {
    private int tamanho;

    public Definida(int tamanho) {
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