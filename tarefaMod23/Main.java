package br.com.rpires.tarefaMod23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, por favor digite o nome e o gênero, separados por traço e vírgula.");
        System.out.println("Exemplo:\n" + "MARCIO-MASCULINO,LUARA-FEMININO,LETICIA-FEMININO\n");

        System.out.print("DIGITE: ");
        String input = scanner.nextLine();
        List<String> lista = processaEntrada(input);

        List<String> listaMulheres = filtrarMulheres(lista);
        List<String> listaHomens = filtrarHomens(lista);

        System.out.println("\nLista das Mulheres: ");
        listaMulheres.forEach(System.out::println);

        System.out.println("\nLista dos Homens: ");
        listaHomens.forEach(System.out::println);

        scanner.close();
    }

    // Método para processar a entrada do usuário e gerar a lista
    public static List<String> processaEntrada(String input) {
        List<String> lista = new ArrayList<>();
        String[] pessoas = input.split(",");
        for (String pessoa : pessoas) {
            lista.add(pessoa);
        }
        return lista;
    }

    // Método para filtrar as mulheres da lista
    public static List<String> filtrarMulheres(List<String> lista) {
        return lista.stream()
                .filter(p -> p.split("-")[1].equals("FEMININO"))
                .toList();
    }

    // Método para filtrar os homens da lista
    public static List<String> filtrarHomens(List<String> lista) {
        return lista.stream()
                .filter(p -> p.split("-")[1].equals("MASCULINO"))
                .toList();
    }
}