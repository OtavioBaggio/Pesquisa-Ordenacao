/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<String> listaPalavras = new ArrayList<>();
        
        Util.popularAleatorioNumeros(listaNumeros, 10, 100, 500);
        Util.exibirListaNumeros(listaNumeros);
        
        //lista2Numeros = addAll(listaNumeros);
        
        Util.popularAleatorioPalavras(listaPalavras, 10, 6);
        Util.exibirListaPalavras(listaPalavras);
        
        
        
    }
    
}
