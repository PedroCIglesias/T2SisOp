public class Executavel {
    public enum Tipo {
    IN,
    OUT
    }
    final private Tipo tipo;
    final private String id;
    private int tamanho;

    public Executavel(Tipo tipo, String id){
        this.tipo = tipo;
        this.id = id;
    }
    public Executavel(Tipo tipo, String id, int tamanho){
        this.tipo = tipo;
        this.id = id;
        this.tamanho = tamanho;
    }
    public Tipo getTipo(){return tipo;}
    public String getId(){return id;}
    public int getTamanho(){return tamanho;}

}
