class SistemaOperacional {
    private Memoria memoria;
    private Compilador compilador;

    public SistemaOperacional(Memoria memoria) {
        this.memoria = memoria;
        compilador = new Compilador();
    }

    public void executar() {
        //Map<String, Integer> alocacoes = compilador.lerArquivo();
        //memoria.alocarMemoria(alocacoes);
    }
}