package memoria;

import java.util.LinkedList;
import java.util.Queue;

import sisOp.Processo;

public class BuddySystem {
    private Buddy raiz;
    private int fragInterna;

    public BuddySystem(int tamanho) {
        raiz = new Buddy(tamanho);
    }

    public void alocar(Processo processo) {
        if (alocarRecursao(raiz, processo) == false) {
            // throw new ErroDeMemoria("erro");
        } else {
            imprimirBuddies();
        }
    }

    public void desalocar(Processo processo) {
        if (desalocarRecursao(raiz, processo) == false) {
            // throw new ErroDeMemoria("erro");
        } else {
            fechaBloco(raiz);
            fechaBloco(raiz);
            fechaBloco(raiz);
            imprimirBuddies();
        }
    }

    private boolean alocarRecursao(Buddy buddy, Processo processo) {
        if (buddy.tamanho / 2 < processo.tamanho) {
            if (buddy.processo == null) {
                buddy.alocar(processo);
                fragInterna += buddy.tamanho - processo.tamanho;
                return true;
            }
            return false;
        }
        if (processo.tamanho < buddy.tamanho) {
            if (buddy.esquerda == null) {
                buddy.esquerda = new Buddy(buddy.tamanho / 2, buddy);
                buddy.direita = new Buddy(buddy.tamanho / 2, buddy);
            }
            if (alocarRecursao(buddy.esquerda, processo) == false) {
                if (alocarRecursao(buddy.direita, processo) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean desalocarRecursao(Buddy buddy, Processo processo) {
        if (buddy.processo != null) {
            if (buddy.processo.id.equals(processo.id)) {
                fragInterna -= buddy.tamanho - buddy.processo.tamanho;
                buddy.processo = null;
                return true;
            }
        }
        if (buddy.esquerda != null) {
            if (desalocarRecursao(buddy.esquerda, processo) == false) {
                if (desalocarRecursao(buddy.direita, processo) == false) {
                    return false;
                }
            }
        } else
            return false;
        return true;
    }

    private Boolean fechaBloco(Buddy buddy) {
        if (buddy.esquerda != null) {
            return fechaBloco(buddy.esquerda);
        } else {
            if (buddy.processo == null) {
                if (buddy.equals(raiz)) {
                    return true;
                }
                if (buddy.pai.direita.esquerda != null) {
                    return fechaBloco(buddy.pai.direita);
                } else if (buddy.pai.direita.processo == null) {
                    buddy.pai.direita = null;
                    buddy.pai.esquerda = null;
                    return true;
                }
            }
        }
        return true;
    }

    public void imprimirBuddies() {
        System.out.println("Framentacao interna: " + fragInterna);

        Queue<Buddy> fila = new LinkedList<>();
        fila.offer(raiz);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();
            for (int i = 0; i < tamanhoNivel; i++) {
                Buddy buddy = fila.poll();
                if (buddy.processo == null) {
                    System.out.print("|" + buddy.tamanho + "| ");
                } else {
                    System.out.print("|" + buddy.processo.id + "| ");
                }
                if (buddy.esquerda != null)
                    fila.offer(buddy.esquerda);

                if (buddy.direita != null)
                    fila.offer(buddy.direita);
            }

            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}
