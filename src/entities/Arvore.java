package entities;

public class Arvore <T extends Comparable>{

    private Elemento<T> raiz;

    public Arvore(){
        raiz = null;
    }

    public Elemento<T> getRaiz(){
        return raiz;
    }

    public void adicionar(T valor){
        Elemento<T> novoElemento = new Elemento<T>(valor);
        if(raiz == null){
            raiz = novoElemento;
        }else{
            Elemento<T> atual = this.raiz;
            while(true){
                if(novoElemento.getValor().compareTo(atual.getValor()) == -1){
                    if(atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }else{
                    if(atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }

    public boolean remover(T valor){
        Elemento<T> atual = this.raiz;
        Elemento<T> paiAtual = null;
        while(atual != null){
            if (atual.getValor().equals(valor)){
                break;
            }else if(valor.compareTo(atual.getValor()) == -1){
                paiAtual = atual;
                atual = atual.getEsquerda();
            }else{
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }

        if(atual != null){

            if(atual.getDireita() != null){

                Elemento<T> substituto = atual.getDireita();
                Elemento<T> paiSubstituto = atual;

                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }
                substituto.setEsquerda(atual.getEsquerda());
                if(paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(substituto);
                    } else {
                        paiAtual.setDireita(substituto);
                    }
                }else {
                    this.raiz = substituto;
                }


                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){
                    paiSubstituto.setEsquerda(null);
                }else {
                    paiSubstituto.setDireita(null);
                }



            } else if (atual.getEsquerda() != null) {
                Elemento<T> substituto = atual.getEsquerda();
                Elemento<T> paiSubstituto = atual;

                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }
                if(paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(substituto);
                    } else {
                        paiAtual.setDireita(substituto);
                    }
                }else {
                    this.raiz = substituto;
                }


                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){
                    paiSubstituto.setEsquerda(null);
                }else {
                    paiSubstituto.setDireita(null);
                }

            }else {
                if(paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(null);
                    } else {
                        paiAtual.setDireita(null);
                    }
                }else{
                    this.raiz = null;
                }
            }

            return true;
        }else{
            return false;
        }
    }

    public void emOrdem(Elemento<T> atual){
        if(atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Elemento<T> atual){
        if(atual != null){
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Elemento<T> atual){
        if(atual != null){
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }



}
