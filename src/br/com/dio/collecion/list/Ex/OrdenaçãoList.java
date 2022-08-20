package br.com.dio.collecion.list.Ex;

/* Dados as seguintes informações sobre Cão da Camila, crie uma lista e
ordene esta lista exibindo: ( nome - idade - cor);

Cão1 = nome : Jon, idade: 18, cor: preto
Cão 2 = nome : Simba, idade: 6, cor: tigrado
Cão 3 = nome : Jon, idade: 12, cor: amerelo
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaçãoList {
    public static void main(String[] args) {

        List<Cao> cachorros = new ArrayList<>(){{
            add(new Cao("Jon",18, "preto" ));
            add(new Cao("Simba", 6, "tigrado" ));
            add(new Cao("Jon", 12, "amarelo" ));
        }};

        System.out.println("--\tOrdem de Insercao\t---");
        System.out.println(cachorros);

        System.out.println("--\tOrdem Aliatoria\t---");
        Collections.shuffle(cachorros);
        System.out.println(cachorros);

        System.out.println("--\tOrdem Natural(nome)\t---");
        Collections.sort(cachorros);
        System.out.println(cachorros);

        System.out.println("--\tOrdem de Idade\t---");
      //  Collections.sort(cachorros, new ComparatorIdade());
        cachorros.sort(new ComparatorIdade());
        System.out.println(cachorros);

        System.out.println("--\tOrdem de Cor\t---");
        cachorros.sort(new ComparatorCor());
        System.out.println(cachorros);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
        Collections.sort(cachorros,new ComparatorNomeIdadeCor());
        System.out.println(cachorros);

    }

}

class Cao implements Comparable<Cao>{
    private String nome;
    private Integer idade;
    private String cor;

    public Cao(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cao o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}

class ComparatorIdade implements Comparator<Cao>{
    @Override
    public int compare(Cao c1, Cao c2) {
        return Integer.compare(c1.getIdade(), c2.getIdade());
    }
}

class ComparatorCor implements Comparator<Cao>{
    @Override
    public int compare(Cao c1, Cao c2) {
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

class ComparatorNomeIdadeCor implements Comparator<Cao>{
    @Override
    public int compare(Cao c1, Cao c2) {
       int nome = c1.getNome().compareToIgnoreCase(c2.getNome());
       if (nome!= 0) return nome; //Nome forem diferentes ordenado por nomes.

       int cor = c1.getCor().compareToIgnoreCase(c1.getCor());
       if (cor!= 0) return cor; // Nome foram iguais sera ordenado por cor diferentes.

       return Integer.compare(c1.getIdade(), c2.getIdade());
    }    //Nome e cor são iguais sera ordenado por idades.
}