
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Otávio Baggio
 */
public class Principal {
    public static void main(String[] args) {
        List<Integer> listaBolha = new ArrayList<>();
        List<Integer> listaNormal = new ArrayList<>();
        List<Integer> listaSelecao = new ArrayList<>();
        List<Integer> listaInsercao = new ArrayList<>();

        Util.popularListaAleatoria(listaBolha, 10000, 100, 20000);
        Util.popularListaAleatoria(listaNormal, 10000, 100, 20000);
        Util.popularListaAleatoria(listaSelecao, 10000, 100, 20000);
        Util.popularListaAleatoria(listaInsercao, 10000, 100, 20000);

        // Sort nativo
        long tempoInicio = System.currentTimeMillis();
        Collections.sort(listaNormal);
        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por sort nativo: " + (tempoFim - tempoInicio) + " ms");

        // Bolha
        tempoInicio = System.currentTimeMillis();
        int[] resultadoBolha = Ordenacao.bolha(listaBolha);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por bolha: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoBolha[0]);
        System.out.println("Trocas: " + resultadoBolha[1]);

        // Selecao
        tempoInicio = System.currentTimeMillis();
        int[] resultadoSelecao = Ordenacao.selecao(listaSelecao);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por selecao: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoSelecao[0]);
        System.out.println("Trocas: " + resultadoSelecao[1]);

        // Insercao
        tempoInicio = System.currentTimeMillis();
        int[] resultadoInsercao = Ordenacao.insercao(listaInsercao);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por insercao: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoInsercao[0]);
        System.out.println("Trocas: " + resultadoInsercao[1]);
    }
}
