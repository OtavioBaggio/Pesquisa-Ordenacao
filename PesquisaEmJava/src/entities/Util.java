package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/***
 * Classe Utilitária que contém as funções e a lógica essencial para o funcionamento do programa
 */
public class Util {
	
	/***
	 * Função que popula a lista com números inteiros aleatórios
	 * @param lista - Lista de inteiros que vai ser populada
	 * @param quantidade - de numeros a serem gerados
	 * @param inicio - valor minimo de intervalo
	 * @param fim - valor maximo do intervalo
	 */
	public static void popularAleatorioNumeros(ArrayList<Integer> lista, int quantidade, int inicio, int fim) {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            lista.add(random.nextInt(fim - inicio) + inicio);
        }
    }
	
	/***
	 * Função que exibi a lista
	 * @param lista - de elementos a ser exibida
	 */
    public static <T> void exibirLista(ArrayList<T> lista) {
        for (T item : lista) {
            System.out.println(item);
        }
    }
    
    /***
     * Função que popula a lista com palavras aleatórias
     * @param lista - a ser populada com as palavras
     * @param quantidade - de palavras geradas
     * @param tamanho - da palavra
     */
    public static void popularAleatorioPalavras(ArrayList<String> lista, int quantidade, int tamanho) {
        Random random = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyz ";
        for (int i = 0; i < quantidade; i++) {
            StringBuilder palavra = new StringBuilder();
            for (int j = 0; j < tamanho; j++) {
                palavra.append(letras.charAt(random.nextInt(letras.length())));
            }
            lista.add(palavra.toString());
        }
    }
    
    /***
     * Lê números de um arquivo de texto e os adiciona à lista.
     * Ignora valores que não são números inteiros.
     * @param lista - de inteiros
     * @param nomeArquivo - arquivo de texto a ser lido
     */
    public static void popularNumerosDeArquivo(ArrayList<Integer> lista, String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] valores = linha.split("\\s+");
                for (String valor : valores) {
                    try {
                        lista.add(Integer.parseInt(valor));
                    } catch (NumberFormatException e) {
                        //Ignora valores que não são números
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo '" + nomeArquivo + "' não encontrado.");
        }
    }
    
    /***
     * Lê as palavras do arquivo e add na lista
     * @param lista - de palavras
     * @param nomeArquivo - de texto a ser lido
     */
    public static void popularPalavrasDeArquivo(ArrayList<String> lista, String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("\\s+");
                for (String palavra : palavras) {
                    lista.add(palavra);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo '" + nomeArquivo + "' não encontrado.");
        }
    }

}
