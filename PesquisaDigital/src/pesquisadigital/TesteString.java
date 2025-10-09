/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pesquisadigital;

/**
 *
 * @author laboratorio
 */
public class TesteString {
    public static void main(String[] args) {
        String string = new String();
        StringBuffer stringbuffer = new StringBuffer();
        StringBuilder stringbuilder = new StringBuilder();
        
        string = "turma de pesquisa e ordenação";
        System.out.println(string.replace("ordenação", "olá"));
        stringbuffer = new StringBuffer("explicação sobre pesquisa digital");
        stringbuilder = new StringBuilder("Texto muito grande");
        
        System.out.println(string.indexOf("ordenação"));
        System.out.println(stringbuffer.lastIndexOf("ordenação"));
        System.out.println("");
        
        //Algoritmos Genéticos:
        //Cromossomo - estado - objeto -> Conjunto de genes
        //pai - "00000000001111111111"
        //mãe - "99999999997777777777"
        
        //filho1 = primeiraParteDoPai + segundaParteDaMae - 00000000007777777777
        //filho2 = primeiraParteDaMãe + segundaParteDoPai - 99999999991111111111
        
        StringBuffer pai = new StringBuffer("00000000001111111111");
        StringBuffer mae = new StringBuffer("99999999997777777777");
        
        String primeiraPartePai = pai.substring(0, (pai.length()/2));
        String segumdaPartePai = pai.substring(0, (pai.length()/2));
        
        String primeiraParteMae = mae.substring(0, (mae.length()/2));
        String segundaParteMae = mae.substring(0, (mae.length()/2));
        
        String filhoMiguelito = primeiraPartePai + segundaParteMae;
        String filhoBaggio = primeiraParteMae + segumdaPartePai;
        
        System.out.println("Filho Miguelito: " + filhoMiguelito);
        System.out.println("Filho Baggio: " + filhoBaggio);
    }
}
