
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Otávio Baggio
 */
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
    
}
