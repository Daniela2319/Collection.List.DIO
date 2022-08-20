package br.com.dio.collecion.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Exemploslist{
    public static void main(String[] args) {
       //Dada uma lista com 7 notas de um aluno[7,8.5,9.3,5,7,8,3.6] faça:
        System.out.println("Crie uma lista e adicione as sete notas: ");

        List<Double> notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(8.0);
        notas.add(3.6);

        System.out.println(notas.toString());

        System.out.println("Exiba a posicao da nota 5.0: " + notas.indexOf(5d));

        System.out.println("Adicione na lista a nota 8.0 na posicao 4: ");
        notas.add(4,8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d),6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 esta na lista: " + notas.contains(5d));

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        for (Double nota : notas)System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));


        Iterator<Double> iterator1 = notas.iterator();
        Double soma = 0d;
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            soma += next;

        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a media das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota 3.6");
        notas.remove(3.6);
        System.out.println(notas);

        System.out.println("Remova a nota da posicao 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menorer que 7 e exiba a lista: ");
        Iterator<Double> iterator2 = notas.iterator();
        while (iterator2.hasNext()) {
            Double next = iterator2.next();
            if (next < 7) iterator2.remove();
        }
        System.out.println(notas);

        System.out.println("Apagar toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confirar se a lista esta vazia: " + notas.isEmpty());

    }
}
