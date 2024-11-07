package application;

import entities.Arvore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arvore<Integer> arvore = new Arvore<Integer>();
        arvore.adicionar(10);
        arvore.adicionar(5);
        arvore.adicionar(6);
        arvore.adicionar(12);
        arvore.adicionar(14);
        arvore.adicionar(16);

        System.out.println("Em-ordem");
        arvore.emOrdem(arvore.getRaiz());


        arvore.remover(10);

        System.out.println("Em-ordem");
        arvore.emOrdem(arvore.getRaiz());

        /*System.out.println("Pré-ordem");
        arvore.preOrdem(arvore.getRaiz());

        System.out.println("Pós-ordem");
        arvore.posOrdem(arvore.getRaiz());*/

    }
}