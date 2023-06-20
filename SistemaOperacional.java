import java.util.ArrayList;

class SistemaOperacional {
    private Memoria memoria;
    private Compilador compilador;

    public SistemaOperacional(Memoria memoria) {
        this.memoria = memoria;
        compilador = new Compilador();
    }

    public void executar() {
        ArrayList<Executavel> codigoExecutavel = compilador.lerArquivo("codigo.txt");
        for (Executavel executavel : codigoExecutavel){
            if(executavel.getTipo()==Executavel.Tipo.IN){
                memoria.alocaMemoria(executavel.getProcesso());
            }else{
                memoria.liberaMemoria(executavel.getProcesso());
            }
        }
    }
}