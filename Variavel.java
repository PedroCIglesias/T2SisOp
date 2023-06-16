public class Variavel implements Particao {
    private int tamanho;
    private PoliticaAlocacao politicaAlocacao;

    public Variavel(int tamanho, PoliticaAlocacao politicaAlocacao) {
        this.tamanho = tamanho;
        this.politicaAlocacao = politicaAlocacao;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public PoliticaAlocacao getPoliticaAlocacao() {
        return politicaAlocacao;
    }

    public void setPoliticaAlocacao(PoliticaAlocacao politicaAlocacao) {
        this.politicaAlocacao = politicaAlocacao;
    }
}