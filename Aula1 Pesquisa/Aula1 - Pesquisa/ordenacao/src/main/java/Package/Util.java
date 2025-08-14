/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laboratorio
 */
public class Util {
    /***
     * Método estático que popula uma lista de números inteiros com valores aleatórios
     * @param lista estrutura de armazenamento dos numeros
     * @param quantidade de números a serem gerados
     * @param inicio valor inicial da extemsão do numero gerado
     * @param fim valor final da extensão do número gerado
     */
    public static void popularAleatorioNumeros(ArrayList<Integer> lista, long quantidade, int inicio, int fim){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            lista.add(gerador.nextInt(fim - inicio + 1) + inicio);
        }
    }
    
    /***
     * Método estático que gera palavras aleatórias
     * @param lista armazena as palavras geradas
     * @param quantidade de palavras a serem geradas
     * @param tamanhoPalavra de palavras a serem geradas
     */
    public static void popularAleatorioPalavras(ArrayList<String> lista, long quantidade, int tamanho){
        String letras = "abcdefghijklmnopqrstuvwxyz";
        Random gerador = new Random();
        
        for(; quantidade > 0; quantidade--){
            String palavraGerada = "";
            char letraSorteada;
            for(int i = 0; i < tamanho; i++){
                letraSorteada = letras.charAt(gerador.nextInt(letras.length()));
                palavraGerada = palavraGerada + letraSorteada;
            }
            
            lista.add(palavraGerada);
        }
    }
    
    /***
     * Método estático que exibe uma lista de números inteiros
     * @param lista contendo números inteiros
     */
    public static void exibirListaNumeros(ArrayList<Integer> lista){
        for(Integer item : lista){
            System.out.println(item);
        }
    }
    
    /***
     * Método estático para exibir lista de palavras
     * @param lista contendo palavras
     */
    public static void exibirListaPalavras(ArrayList<String> lista){
        for(String item : lista){
            System.out.println(item);
        }
    }
    
}
