package Entities;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe que contém os métodos de ordenação
 * necessários para ordenar os números à escolha do usuário
 * @author Otávio Baggio
 */
public class Ordenacao {
    
    /***
     * Método do Bubble Sort(Bolha)
     * Trabalha com o conceito de trocas, ou seja, enquanto houver trocas, 
     * o algoritmo não para. É considerado bolha, porque 'leva' 
     * os maiores para o final da estrutura
     * @param lista - de inteiros
     * @return 
     */
    public static int[] bolha(List<Integer> lista){
        boolean houveTroca = true;
        int qtdComparacoes = 0;
        int qtdTrocas = 0;
        
        while(houveTroca){
            houveTroca = false;
            for(int i = 0; i < lista.size() - 1; i++){
                qtdComparacoes++;
                if(lista.get(i) > lista.get(i + 1)){
                    qtdTrocas++;
                    houveTroca = true;
                    int tmp = lista.get(i);
                    lista.set(i , lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }
    
    /***
     * Método que aplica o seleção.
     * Em cada passo, seleciona o menor (ou maior) elemento e coloca na posição correta, trocando.
     * Passa o menor valor para a 1º posição, o segundo menor para a 2ª posição e assim sucessivamente.
     * @param lista - de inteiros
     * @return 
     */
    public static int[] selecao(List<Integer> lista) {
        int qtdComparacoes = 0;
        int qtdTrocas = 0;

        for (int i = 0; i < lista.size() - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (i != posMenor) {
                qtdTrocas++;
                int tmp = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, tmp);
            }
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }

    /***
     * Método que implementa o insertion Sort(Inserção).
     * constrói o vetor ordenado à esquerda, inserindo cada novo elemento na posição correta. 
     * Ele vai selecionando, comparando, ordenando e atribuindo ao grupo da esquerda
     * @param lista - de inteiros
     * @return 
     */
    public static int[] insercao(List<Integer> lista) {
        int qtdComparacoes = 0;
        int qtdTrocas = 0;

        for (int i = 1; i < lista.size(); i++) {
            int tmp = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > tmp) {
                qtdComparacoes++;
                lista.set(j + 1, lista.get(j));
                qtdTrocas++;
                j--;
            }
            if (j >= 0) {
                qtdComparacoes++;
            }
            lista.set(j + 1, tmp);
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }
    
    
    /***
     * Método do Shake Sort(Agitação)
     * É uma variação do bolha, mas a cada passada percorre o vetor nos dois 
     * sentidos (da esquerda para direita e depois da direita para esquerda), "sacudindo" os elementos.
     * @param lista - de inteiros
     * @return 
     */
    public static int[] agitacao(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.size() - 1;  // fim deve ser índice, não tamanho
        int qtdComparacoes = 0, qtdTrocas = 0;
    
        do {
            houveTroca = false;
            // Percorre da esquerda para a direita
            for (int i = ini; i < fim; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }
    
            if (!houveTroca) {
                break;
            }
    
            fim--;
    
            houveTroca = false;
            // Percorre da direita para a esquerda
            for (int i = fim; i > ini; i--) {
                qtdComparacoes++;
                if (lista.get(i) < lista.get(i - 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i - 1));
                    lista.set(i - 1, tmp);
                }
            }
    
            ini++;
    
        } while (houveTroca);
    
        return new int[]{qtdComparacoes, qtdTrocas};
    }

    /***
     * Método do Comb Sort(Pente).
     * variação do bolha. Usa um "gap" inicial maior e vai diminuindo 
     * (geralmente divide por 1,3) até chegar em 1. A ideia é eliminar 
     * "tartarugas" (elementos pequenos no final que demoram a subir no bolha).
     * @param lista
     * @return 
     */
    public static int[] pente(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int distancia = lista.size();
        int qtdComparacoes = 0, qtdTrocas = 0;

        do {
            distancia = (int) (distancia / 1.3);
            if(distancia < 1){
                distancia = 1;
            }
            houveTroca = false;
            for (int i = 0; i+distancia < lista.size(); i++){
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + distancia)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                }
            }
        } while (houveTroca || distancia > 1);

        return new int[] {qtdComparacoes, qtdTrocas};
    }

    /***
     * Método do shell Sort
     * generalização do inserção. Ordena elementos distantes, diminuindo o “gap” 
     * até virar 1 (aí sim, funciona como inserção).
     * @param lista
     * @return 
     */
    public static int[] shell(List<Integer> lista) {
        int i, j;
        int tmp;
        int qtdComparacoes = 0, qtdTrocas = 0;
        int distancia = 1;
        int referenciaTamanho = 3;
        int n = lista.size();
    
        // Calcula a distância inicial usando a sequência de incrementos de Knuth
        while (distancia < n / referenciaTamanho) {
            distancia = referenciaTamanho * distancia + 1;
        }
    
        while (distancia > 0) {
            for (i = distancia; i < n; i++) {
                tmp = lista.get(i);
                j = i - distancia;
                while (j >= 0) {
                    qtdComparacoes++;
                    if (tmp < lista.get(j)) {
                        lista.set(j + distancia, lista.get(j));
                        qtdTrocas++;
                        j -= distancia;
                    } else {
                        break;
                    }
                }
                lista.set(j + distancia, tmp);
                qtdTrocas++;
            }
            distancia = distancia / referenciaTamanho;
        }
    
        return new int[] {qtdComparacoes, qtdTrocas};
    }
    
    
     /***
     * Método do Quick Sort
     * Escolhe um pivô, divide o vetor em dois (menores que o pivô e maiores que o pivô)
     * e aplica o processo recursivamente.
     * @param lista
     * @return 
     */
    public static int[] quickSort(List<Integer> lista) {
        int[] dados = new int[2]; // [comparações, trocas]
        quickSortRec(lista, 0, lista.size() - 1, dados);
        return dados;
    }

    private static void quickSortRec(List<Integer> lista, int inicio, int fim, int[] dados) {
        if (inicio < fim) {
            int p = particiona(lista, inicio, fim, dados);
            quickSortRec(lista, inicio, p - 1, dados);
            quickSortRec(lista, p + 1, fim, dados);
        }
    }

    private static int particiona(List<Integer> lista, int inicio, int fim, int[] dados) {
        int pivo = lista.get(fim);
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            dados[0]++; // comparação
            if (lista.get(j) <= pivo) {
                i++;
                // troca manual
                int tmp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, tmp);
                dados[1]++; // troca
            }
        }
        // troca manual final
        int tmp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, tmp);
        dados[1]++; // troca

        return i + 1;
    }
    
    /**
     * Método do Heap Sort
     * Constrói um heap máximo a partir da lista e então extrai repetidamente 
     * o maior elemento (raiz do heap) para o final da lista, reduzindo o tamanho 
     * do heap a cada iteração.
     * @param lista Lista de inteiros
     * @return Array contendo o número de comparações e trocas
     */
    public static int[] heapSort(List<Integer> lista) {
        int[] dados = new int[2]; // [comparações, trocas]
        int n = lista.size();

        // Constrói o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i, dados);
        }

        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            int tmp = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, tmp);
            dados[1]++; // troca

            // Chama heapify na raiz reduzida
            heapify(lista, i, 0, dados);
        }

        return dados;
    }

    private static void heapify(List<Integer> lista, int n, int i, int[] dados) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // Verifica se o filho da esquerda é maior que a raiz
        if (esquerda < n) {
            dados[0]++; // comparação
            if (lista.get(esquerda) > lista.get(maior)) {
                maior = esquerda;
            }
        }

        // Verifica se o filho da direita é maior que o maior até agora
        if (direita < n) {
            dados[0]++; // comparação
            if (lista.get(direita) > lista.get(maior)) {
                maior = direita;
            }
        }

        // Se o maior não é a raiz
        if (maior != i) {
            int tmp = lista.get(i);
            lista.set(i, lista.get(maior));
            lista.set(maior, tmp);
            dados[1]++; // troca

            // Recursivamente aplica heapify na subárvore afetada
            heapify(lista, n, maior, dados);
        }
    }

    /**
     * Método do Merge Sort
     * Divide recursivamente a lista em duas metades até que cada parte tenha 
     * apenas um elemento, e então mescla essas partes de forma ordenada.
     * @param lista Lista de inteiros
     * @return Array contendo o número de comparações e trocas
     */
    public static int[] mergeSort(List<Integer> lista) {
        int[] dados = new int[2]; // [comparações, trocas]
        if (lista.size() > 1) {
            int[] aux = new int[lista.size()];
            mergeSortRec(lista, 0, lista.size() - 1, aux, dados);
        }
        return dados;
    }

    private static void mergeSortRec(List<Integer> lista, int inicio, int fim, int[] aux, int[] dados) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            // Ordena a primeira e a segunda metade
            mergeSortRec(lista, inicio, meio, aux, dados);
            mergeSortRec(lista, meio + 1, fim, aux, dados);

            // Mescla as duas metades ordenadas
            merge(lista, inicio, meio, fim, aux, dados);
        }
    }

    private static void merge(List<Integer> lista, int inicio, int meio, int fim, int[] aux, int[] dados) {
        // Copia os elementos para o array auxiliar
        for (int i = inicio; i <= fim; i++) {
            aux[i] = lista.get(i);
        }

        // Índices para percorrer as duas metades
        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        // Mescla as duas metades
        while (i <= meio && j <= fim) {
            dados[0]++; // comparação
            if (aux[i] <= aux[j]) {
                lista.set(k, aux[i]);
                i++;
            } else {
                lista.set(k, aux[j]);
                j++;
            }
            dados[1]++; // movimentação
            k++;
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i <= meio) {
            lista.set(k, aux[i]);
            dados[1]++; // movimentação
            i++;
            k++;
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j <= fim) {
            lista.set(k, aux[j]);
            dados[1]++; // movimentação
            j++;
            k++;
        }
    }

}
