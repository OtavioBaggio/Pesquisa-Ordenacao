/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author laboratorio
 */
public class Sessao {
    public String numeroCelular;
    public String dadosSessao;

    public Sessao(String numeroCelular, String dadosSessao) {
        this.numeroCelular = numeroCelular;
        this.dadosSessao = dadosSessao;
    }

    @Override
    public String toString() {
        return "Sessao{" + "numeroCelular=" + numeroCelular + ", dadosSessao=" + dadosSessao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.numeroCelular);
        hash = 97 * hash + Objects.hashCode(this.dadosSessao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.numeroCelular, other.numeroCelular)) {
            return false;
        }
        return Objects.equals(this.dadosSessao, other.dadosSessao);
    }
    
    public static Sessao pegar(HashSet<Sessao> sessoes, Sessao chave){
        for(Sessao s : sessoes){
            if(s.equals(chave)){
                return s;
            }
        }
        return null;
    }
    
}
