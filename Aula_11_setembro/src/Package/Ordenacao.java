package Package;

import java.util.List;

public class Ordenacao {

    public static int[] bolha(List<Integer> lista){
        boolean houveTroca = true;
        int qtdComparacoes = 0;
        int qtdTrocas = 0;
        
        while(houveTroca){
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    int tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }
    
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

    // Particiona a lista e retorna o índice do pivô
    private static int particiona(List<Integer> lista, int ini, int fim) {
        int pivo = lista.get(ini); // Escolhendo o pivô
        int i = ini + 1;  // Índice que vai percorrer a lista da esquerda
        int j = fim;      // Índice que vai percorrer a lista da direita
        int tmp;

        while (true) {
            // Move i para a direita até encontrar um valor maior ou igual ao pivô
            while (i <= fim && lista.get(i) <= pivo) {
                i++;
            }

            // Move j para a esquerda até encontrar um valor menor ou igual ao pivô
            while (j > ini && lista.get(j) >= pivo) {
                j--;
            }

            // Se i passou j, termina o loop
            if (i >= j) {
                break;
            }

            // Caso contrário, troca os elementos
            tmp = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, tmp);
        }

        // Coloca o pivô na posição final e retorna o índice do pivô
        lista.set(ini, lista.get(j));
        lista.set(j, pivo);

        return j;
    }

    // Função recursiva do QuickSort
    public static int[] quickSort(List<Integer> lista, int ini, int fim) {
        int qtdComparacoes = 0;
        int qtdTrocas = 0;

        if (ini < fim) {
            int pivo = particiona(lista, ini, fim); // Particiona a lista
            qtdComparacoes++;  // A comparação do pivô

            // Recursão para a parte à esquerda
            int[] resultadoEsq = quickSort(lista, ini, pivo - 1);
            qtdComparacoes += resultadoEsq[0];
            qtdTrocas += resultadoEsq[1];

            // Recursão para a parte à direita
            int[] resultadoDir = quickSort(lista, pivo + 1, fim);
            qtdComparacoes += resultadoDir[0];
            qtdTrocas += resultadoDir[1];
        }

        return new int[] {qtdComparacoes, qtdTrocas};
    }

    
    

}
