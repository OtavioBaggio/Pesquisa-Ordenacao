
import java.util.List;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Otávio Baggio
 */
public class Util {
    public static void popularListaAleatoria(List<Integer> lista, int quantidade, int inicio, int fim){
        Random rand = new Random();
        for(int i = 0; i < quantidade; i++){
            lista.add(rand.nextInt(fim - inicio + 1) + inicio);
        }
    }
    
    public static void exibirLista(List<Integer> lista, String frase){
        System.out.println(frase);
        for(int item : lista){
            System.out.println(item);
        }
    }
}
