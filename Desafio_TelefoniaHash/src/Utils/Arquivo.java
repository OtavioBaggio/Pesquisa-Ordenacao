/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Entities.Sessao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;




/**
 *
 * @author laboratorio
 */
public class Arquivo {
    
    public static void carregarArquivo(HashMap<String,Sessao> sessoes, String caminho) {
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            linha = linha.trim();
            if (!linha.isEmpty()){
                String[] partes = linha.split(";",2);
                if(partes.length == 2){
                    String numeroCelular = partes[0];
                    String dadosSessao = partes[1];
                    
                    Sessao sessao = new Sessao(numeroCelular, dadosSessao);
                    sessoes.put(numeroCelular, sessao);
                }else{
                    System.out.println("Alguma linha(s) do arquivo não está no formato desejado!");
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

}
    
    
}
