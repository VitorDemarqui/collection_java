package br.com.dio.collection.list;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);

Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        //instanciando lista tipo gato
        //adicionando novos gatos
        //adicionando 2 chaves pois estamos adicionando na instancia do objeto
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 12, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 18, "amarelo"));
        }};
        meusGatos.sort(Comparator.comparing(Gato::getNome));


        System.out.println("--\tOrdem de Inserção\t---");
        //o padrao é sempre a ordem de inserção
        System.out.println(meusGatos);

        System.out.println("--\tOrdem aleatória\t---");
        //shuffle embaralha os items da list
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t---");
        //sort compara precisa implementar o comparable
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t---");
//        Collections.sort(meusGatos, new ComparatorIdade());//tranforma a lista e deixa os gatos comparar por idade

        meusGatos.sort(new ComparatorIdade());//utiliza o metodo comparador
        System.out.println(meusGatos);

        System.out.println("--\tOrdem cor\t---");
//        Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());//passado o comparator de cores
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
        //Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

//implementa a classe comparável para comparação
//indica que vai querer comparar gatos
//e sobrescreve o metodo compareTo

class Gato implements Comparable<Gato>{
    private final String nome;
    private final Integer idade;
    private final String cor;

    public Gato(String nome, Integer idade, String cor) {
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

    //sobresceve pois senao fosse sobrescrito apareceria o endereço de memória
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        //compara o getnome
        //o metodo compare to retorna um int para organizar
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}


//implementa interface comparator para comparar gatos
class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        //compara gato 1 e gato 2
        //comapra inteiros e nos retorna ou 0 ou 1 ou -1 para ordenar a lista
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

//implementa interface comparator para comparar gatos
class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        //comparando a cor string dos gatos que sao string
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        //se o nome for igual ele será igual a 0
        //se o nome for diferente de 0 quer dizer que é igual
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor !=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}