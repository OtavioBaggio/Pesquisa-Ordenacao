package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Principal {
    public static void main(String[] args) {
        
        List<Integer> listaBolha = new ArrayList<>();
        List<Integer> listaNormal = new ArrayList<>();
        List<Integer> listaSelecao = new ArrayList<>();
        List<Integer> listaInsercao = new ArrayList<>();
        List<Integer> listaAgitacao = new ArrayList<>();
        List<Integer> listaPente = new ArrayList<>();
        List<Integer> listaShellsort = new ArrayList<>();
        List<Integer> listaQuicksort = new ArrayList<>();

        Util.popularListaAleatoria(listaBolha, 10000, 100, 20000);
        Util.popularListaAleatoria(listaNormal, 10000, 100, 20000);
        Util.popularListaAleatoria(listaSelecao, 10000, 100, 20000);
        Util.popularListaAleatoria(listaInsercao, 10000, 100, 20000);
        Util.popularListaAleatoria(listaAgitacao, 10000, 100, 20000);
        Util.popularListaAleatoria(listaPente, 10000, 100, 20000);
        Util.popularListaAleatoria(listaShellsort, 10000, 100, 20000);
        Util.popularListaAleatoria(listaQuicksort, 10000, 100, 20000);

        // Sort nativo
        long tempoInicio = System.currentTimeMillis();
        Collections.sort(listaNormal);
        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por sort nativo: " + (tempoFim - tempoInicio) + " ms");

        System.out.println();

        // Bolha
        tempoInicio = System.currentTimeMillis();
        int[] resultadoBolha = Ordenacao.bolha(listaBolha);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por bolha: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoBolha[0]);
        System.out.println("Trocas: " + resultadoBolha[1]);

        System.out.println();

        // Selecao
        tempoInicio = System.currentTimeMillis();
        int[] resultadoSelecao = Ordenacao.selecao(listaSelecao);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por selecao: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoSelecao[0]);
        System.out.println("Trocas: " + resultadoSelecao[1]);

        System.out.println();

        // Insercao
        tempoInicio = System.currentTimeMillis();
        int[] resultadoInsercao = Ordenacao.insercao(listaInsercao);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por insercao: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoInsercao[0]);
        System.out.println("Trocas: " + resultadoInsercao[1]);
        
        System.out.println();


        /*
    * AGITAÇÃO - Shake Sort ou Cocktail

    - É baseado no Bolha, ou seja, é uma tentantiva de melhorar o Bolha.
    - Estável
    - Memória Interna
    - A estrutura possui 3 partes/porções (1a é a ordenada pelos menores; 2a é a desordenada; 3a é a ordenada pelos maiores)

    De fato é a aplicação do bolha da esquerda para direita e depois da direita para esquerda

    Há os índices/ponteiros ini e fim que marcam o início e o final da estrutura

    Observação: 
        i) se a estrutura estiver ordenada ou quase, o agitação terá excelente desempenho, como o bolha
        ii) atenção a lista deve ser duplamente encadeada  
    */
        // Agitacao:
        tempoInicio = System.currentTimeMillis();
        int[] resultadoAgitacao = Ordenacao.agitacao(listaAgitacao);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por agitacao: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoAgitacao[0]);
        System.out.println("Trocas: " + resultadoAgitacao[1]);

        System.out.println();

        /*
         * PENTE - Comb Sort
    - É baseado no Bolha, ou seja, é uma tentantiva de melhorar o Bolha.

    ATENÇÃO: a partir deste método, há COMPARAÇÕES a uma distância X. Isso gera uma pré-organização da estrutura, diminuindo número de comparações e trocas.

    Instável
    Memória Interna
    A estrutura possui 2 porções/partes (1a é a ordenada; 2a é a desordenada)

    Há as variáveis clássicas do bolha: i, houveTroca, tmp.
    Há a variável distancia que é calculada pelo tamanho da estrutura dividido por 1.3

    Adequado somente para listas ou estruturas prontas tipo lista de uma linguagem de programação
         */

        // Pente (Comb Sort):
        tempoInicio = System.currentTimeMillis();
        int[] resultadoPente = Ordenacao.agitacao(listaPente);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por Pente (Comb Sort): " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoPente[0]);
        System.out.println("Trocas: " + resultadoPente[1]);

        System.out.println();

        /*
         * SHELLSORT 
        É baseado no Inserção, ou seja, é uma tentativa de melhoria via o uso da ANÁLISE A DISTÂNCIA (tipo pente) Instável 
        Memória Interna

        Não é adequado para listas encadeadas

    n = 7
    0   1   2   3   4   5   6   
    7   1   4   2   3   9   8       distancia = 4
         */

        // Shellsort:
        tempoInicio = System.currentTimeMillis();
        int[] resultadoShellsort = Ordenacao.shell(listaShellsort);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por Shellsort: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoPente[0]);
        System.out.println("Trocas: " + resultadoPente[1]);

        System.out.println();

        //Quicksort:
        tempoInicio = System.currentTimeMillis();
        int[] resultadoQuickSort = Ordenacao.quickSort(listaQuicksort, 0, listaQuicksort.size() - 1);
        tempoFim = System.currentTimeMillis();
        System.out.println("Tempo da rotina ordenar por QuickSort: " + (tempoFim - tempoInicio) + " ms");
        System.out.println("Comparacoes: " + resultadoQuickSort[0]);
        System.out.println("Trocas: " + resultadoQuickSort[1]);
    }

}