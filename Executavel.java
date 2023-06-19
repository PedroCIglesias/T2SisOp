public class Executavel {
    public enum Tipo {
    IN,
    OUT
    }
    final private Tipo tipo;
    Processo processo;

    public Executavel(Tipo tipo, Processo processo){
        this.tipo = tipo;
        this.processo = processo;
    }

    public Tipo getTipo(){return tipo;}
    public String getId(){return processo.id;}
    public int getTamanho(){return processo.tamanho;}

}
