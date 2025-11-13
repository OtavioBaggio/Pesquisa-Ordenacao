/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Entities.Sessao;
import java.util.HashMap;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        HashMap<String,Sessao> sessoes = new HashMap<>();
        
        Sessao sessao1 = new Sessao("991336889","Dados da Sessao 1: vava");
        
        sessoes.put(sessao1.numeroCelular,sessao1);
        
        System.out.println("Verificando existencia da sessao");
        String celularBusca = "991336889";
        
        Sessao sessaoEncontrada = sessoes.get(celularBusca);
        
        if(sessaoEncontrada != null){
            System.out.println("Sessao Encontrada: "+sessaoEncontrada.dadosSessao);
        }else{
            System.out.println("Sessão não encontrada");
        }
        
    }
    
}
