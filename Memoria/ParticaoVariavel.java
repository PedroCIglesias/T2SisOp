package memoria;
public class ParticaoVariavel implements Particao {
    private PoliticaAlocacao politicaAlocacao;

    public ParticaoVariavel( PoliticaAlocacao politicaAlocacao) {
        this.politicaAlocacao = politicaAlocacao;
    }

    public PoliticaAlocacao getPoliticaAlocacao() {
        return politicaAlocacao;
    }

    public void setPoliticaAlocacao(PoliticaAlocacao politicaAlocacao) {
        this.politicaAlocacao = politicaAlocacao;
    }
}