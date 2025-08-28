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

    
    

}
