package br.com.dio.collection.list;


import java.util.*;

class ExemploList {
    public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

//      List notas = new ArrayList(); //antes do java 5


//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
// passa como parametro os elementos que queremos adicionar

        /*List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //passa uma lista e transforma em aray
        nao pode adicionar nem remover items
        notas.add(10d);
        System.out.println(notas);*/


        /*List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //torna nossa lista imutavel igual a de cima
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);*/

        System.out.println("Crie uma lista e adicione as sete notas: ");

        //ArrayList<Double> notas = new ArrayList<>(); //generics contem elementos do tipo double diamond operator
        List<Double> notas = new ArrayList<Double>(); //Generics(jdk 5) - Diamond Operator(jdk 7)
        notas.add(7d);//adicionando items na lista o d tranforma em double
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas.toString());//imprime toda a lista

        //index off indica a posicao do item da lista que queremos mostrar
        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);//adiciona ao idx  4 o elemento 8
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6.0); //set altera alguma posicao, pegamos a posicao do elemento 5 e trocamos por 6
        System.out.println(notas);

        //confere se existe a nota 5 esta na lista
        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        //para cada double da lista nota exibe o nota
        for (Double nota : notas) System.out.println(nota);


        //get é recebe a posição e nos retorna qual o elemento está na posicao
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        //recebe uma colection e calcula qual o valor minimo da collection passada
        //double implementa interface comparable
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        //recebe uma colection e calcula qual o valor max da collection passada
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        //iterator Permite percorrer cada elemento em uma coleção, um após o outro.
        Iterator<Double> iterator = notas.iterator();
        //soma = 0
        Double soma = 0d;
        //enquanto iterator tiver proximo
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        //calcula a quantidade de elementos que temos dentro do list
        //notas size é o tamanho
        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        //remove o valor 0 do list
        //se nao transformar em double remove a posicao 0
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        //remove posicao 0
        System.out.println("Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");


        //remove em loop tudo que for menor que 7 remove if
        notas.removeIf(next -> next < 7);
        System.out.println(notas);

        //apaga toda a lista
        //apaga todos os items da lista
        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        //metodo isEmpty se tiver vazia retorna true
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

/*
Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:

        System.out.println("Crie uma lista chamada notas2 " +
                "e coloque todos os elementos da list Arraylist nessa nova lista: ");

        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: ");

        System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
*/

    }
}
