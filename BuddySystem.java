public class BuddySystem {
    private Buddy raiz;

    public BuddySystem(int tamanho){
        raiz = new Buddy(tamanho);
    }

    public void alocar(Processo processo){
        if(alocarRecursao(raiz, processo)==false){
            //lanca erro
        }else{
            imprimeBuddySystem();
        }
    }

    public void desalocar(Processo processo){
        if(desalocarRecursao(raiz,processo)==false){
            //lanca erro
        }   
        else
            imprimeBuddySystem();
    }

    private boolean alocarRecursao(Buddy buddy, Processo processo){
        if(buddy.tamanho/2 < processo.tamanho){
            if(buddy.processo==null)
                buddy.alocar(processo);
                return true;
        }
        if(processo.tamanho < buddy.tamanho){
            if(buddy.esquerda == null){
                buddy.esquerda = new Buddy(buddy.tamanho/2, buddy);
                buddy.direita = new Buddy(buddy.tamanho/2, buddy);
            }
            if(alocarRecursao(buddy.esquerda, processo)==false){
                if(alocarRecursao(buddy.direita,processo)==false){
                    return false;
                }    
            }
        }
        return false;
    }

    private boolean desalocarRecursao(Buddy buddy, Processo processo){
        if(buddy.processo!=null){
            if(buddy.processo.id.equals(processo.id)){
                buddy.processo=null;
                return true;
            }
        }
        if(buddy.esquerda!=null){
            if(desalocarRecursao(buddy.esquerda, processo)==false){
                if(desalocarRecursao(buddy.direita,processo)==false){
                    return false;
                }
            }    
        }
        return false;
    }
    public void imprimeBuddySystem(){
        imprimirBuddySystemRecursivo(raiz, 0);
    }

    private void imprimirBuddySystemRecursivo(Buddy buddy, int nivel) {
        if (buddy != null) {
            imprimirBuddySystemRecursivo(buddy.direita, nivel + 1);
            if(buddy.processo==null)
                System.out.println(obterEspacamento(nivel) + "|" + buddy.tamanho + "|" + "("+ buddy.processo.id +", " + buddy.processo.tamanho + ")");
            else
                System.out.println(obterEspacamento(nivel) + "|" + buddy.tamanho + "|");
            imprimirBuddySystemRecursivo(buddy.esquerda, nivel + 1);
        }
    }

    private String obterEspacamento(int nivel) {
       StringBuilder espacamento = new StringBuilder();
       for (int i = 0; i < nivel; i++) {
           espacamento.append("  ");
       }
       return espacamento.toString();
    }
}
