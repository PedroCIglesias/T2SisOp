package SisOp;

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
    public Processo getProcesso(){return processo;}

}
