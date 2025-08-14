package application;

import java.util.ArrayList;

import entities.Util;

public class Main {

	public static void main(String[] args) {
		// Listas:
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<Integer> lista2Numeros = new ArrayList<>();
        ArrayList<String> listaPalavras = new ArrayList<>();

        //Populando com números aleatórios
        Util.popularAleatorioNumeros(listaNumeros, 10, 100, 500);
        System.out.println("--- Números aleatórios ---");
        Util.exibirLista(listaNumeros);

        //Copia para outra lista
        lista2Numeros.addAll(listaNumeros);

        //Popula com palavras aleatórias
        Util.popularAleatorioPalavras(listaPalavras, 10, 6);
        System.out.println("\n--- Palavras aleatórias ---");
        Util.exibirLista(listaPalavras);

        //Popula números a partir de arquivo
        ArrayList<Integer> listaNumerosArquivo = new ArrayList<>();
        Util.popularNumerosDeArquivo(listaNumerosArquivo, "numeros.txt");
        System.out.println("\n--- Números do arquivo ---");
        Util.exibirLista(listaNumerosArquivo);

        // Popula palavras a partir de arquivo
        ArrayList<String> listaPalavrasArquivo = new ArrayList<>();
        Util.popularPalavrasDeArquivo(listaPalavrasArquivo, "palavras.txt");
        System.out.println("\n--- Palavras do arquivo ---");
        Util.exibirLista(listaPalavrasArquivo);

	}

}
