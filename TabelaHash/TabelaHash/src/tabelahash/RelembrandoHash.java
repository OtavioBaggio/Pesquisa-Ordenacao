/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelahash;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author laboratorio
 */
public class RelembrandoHash {
    public static void main(String[] args) {
        
        Random gerador = new Random();
        HashSet<Integer> tabela = new HashSet<Integer>();
        int numero;
        int endereco;
        for(int i = 0; i < 10; i++){
            numero = gerador.nextInt(100);
            endereco = ("" + numero).hashCode();
            System.out.println("Numero: " + numero + ". Endereco: " + endereco);
            
            if(!tabela.add(numero)){
                System.out.println("numero ja inserido: " + numero + "Endereco: " + endereco);
            }
        }
        
        for(Integer item : tabela){
            System.out.println(item);
        }
    }
}
