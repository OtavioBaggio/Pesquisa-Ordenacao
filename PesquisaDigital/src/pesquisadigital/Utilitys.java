/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pesquisadigital;

/**
 *
 * @author laboratorio
 */
public class Utilitys {
    
   public int contarPalavras(StringBuffer texto){
       return texto.toString().split(" ").length;
       // OU:
       //String vetor[] = texto.toString().split(" ");
       //int total = vetor.length;
       //return total;
   } 
   
}
