package br.com.dio.collection.map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
/*
 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
 modelo = gol - consumo = 14,4km/l
 modelo = uno - consumo = 15,6 km/l
 modelo = mobi - consumo = 16,1 km/l
 modelo = hb20 - consumo = 14,5 km/l
 modelo = kwid - consumo = 15,6 km/l
 */
//Formas iniciar MAP
//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        //tipo chave e tipo valor
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            //preenchendo map
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        //exibe todos os items
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        //altera o valor gol
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        //verifica se exite a chave
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        //pegamos o valor do objeto
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        //nao tem metodo para mostrar os indices
//        System.out.println("Exiba o terceiro modelo adicionado: ");

        System.out.println("Exiba os modelos: ");
        //chave e do tipo string
        Set<String> modelos = carrosPopulares.keySet();
        //print os modelos
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        //tipo double
        Collection<Double> consumos = carrosPopulares.values();
        //mostra todos os valores
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");

        //pega o maximo com uma collection
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());

        //retorna um entry set e cada um dentro do set é desse valor map.Entry<String, Double>
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();


        String modeloMaisEficiente = "";
        //for each
        for (Map.Entry<String, Double> entry : entries) {
            //compara valores se 1 for igual ao outro
            if (entry.getValue().equals(consumoMaisEficiente)) {
                //se for igual um ao outro ele atribui a variavel
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o modelo menos econômico e seu consumo: " );

        //atribui a uma variavel o consumo menos eficiente
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        //inicializa uma variavel
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()) {
            //se o entry for igual ao consumo menos eficiente
            if(entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        //conseguimos chamar o iterator porque o retorno do carros populares é uma collection
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        //enquanto o iterator tem proximo
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        //captura a soma e divide pelo tamanho
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println(carrosPopulares);


        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            //se igual a 15.6 remove
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);


        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        //exibe todos os dados inseridos
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        //ordenando as chaves com treeMAP
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        //limpa o dicionario
        System.out.println("Apague o dicionario de carros: ");
        carrosPopulares.clear();

        //verifica se está vazio
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
