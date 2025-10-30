/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelahash;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author laboratorio
 */
class Util{
    public static int hash(int numero, int tamanho){
        return numero % tamanho;
    }
}

public class TabelaHash_Exemplo {
    public static void main(String[] args) {
        
        //Exercicio 1) Refatorar o código para que ele não aceite numeros replicados
        //Exercicio 2) refatorar o código para que se possa buscar um número, informando sua posição na tabela
        //Exercicio 3) refatorar o código para buscar e remover o número
        
        //Cria o vetor de 10 posições, cada uma será uma lista:
        ArrayList<Integer>[] tabela = new ArrayList[10];
        
        //Inicializa cada posição do vetor com uma nova lista
        for(int i = 0; i < tabela.length; i++){
            tabela[i] = new ArrayList<>();
        }
        
        //Receber um numero:
        Scanner teclado = new Scanner(System.in);
        int numero, endereco;
        for(int i = 0; i < 5; i++){
            System.out.println("Numero: ");
            numero = teclado.nextInt();
            
            //Calcular o endereço do numero dentro da tabela para o espalamento:
            endereco = Util.hash(numero, tabela.length);
            System.out.println("Endereço gerado: " + endereco);
            
            //Exercicio 1: Refatorar o código para que ele não aceite numeros replicados
            if(!tabela[endereco].contains(numero)){
                //Inserir o numero
                tabela[endereco].add(numero);
            }else{
                System.out.println("NUMERO JÁ INSERIDO, TENTE OUTRO");
            }    
        }
        
        //Exercicio 2: refatorar o código para que se possa buscar um número, informando sua posição na tabela
        System.out.println("Digite um número para ver a sua posição: ");
        int numeroPosicao = teclado.nextInt();
        int posicaoNumero = -1;
        
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i].contains(numeroPosicao)){
                posicaoNumero = i;
                break;
            }
        }
        
        if(posicaoNumero != -1){
            System.out.println("Número se encontra na posição: " + posicaoNumero);
        }else{
            System.out.println("Número não encontrado!");
        }
        
        //Exercicio 3: refatorar o código para buscar e remover o número
        System.out.println("Digite um número para remover: ");
        int numeroParaRemover = teclado.nextInt();
        endereco = Util.hash(numeroParaRemover, tabela.length);
        
        if(tabela[endereco].remove(Integer.valueOf(numeroParaRemover))){
            System.out.println("Número removido com sucesso!");
        }else{
            System.out.println("Número não se encontra na tabela ou está fora da área de cobertura...");
        }
        
 
        // Exemplo: percorrendo o vetor e imprimindo o conteudo
        for(int i = 0; i < tabela.length; i++){
            System.out.println("Posição: " + i + ": " + tabela[i]);
        }
    }
}
