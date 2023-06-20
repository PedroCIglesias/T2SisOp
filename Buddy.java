class Buddy {
    int tamanho;
    Buddy esquerda;
    Buddy direita;
    Buddy pai;

    Processo processo;

    public Buddy(int tamanho, Buddy pai) {
        this.tamanho = tamanho;
        this.esquerda = null;
        this.direita = null;
        this.pai = pai;
        this.processo = null;
    }

    public Buddy(int tamanho) {
        this.tamanho = tamanho;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.processo = null;
    }

    public void alocar(Processo processo2) {
        this.processo = processo2;
    }

    public void desalocar() {
        this.processo = null;
    }
}