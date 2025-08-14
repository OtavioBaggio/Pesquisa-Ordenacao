using System;
using System.Collections.Generic;
using ordenacaoEmC_; // Supondo que o namespace da classe Util seja esse

namespace ordenacaoEmC_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<int> listaNumeros = new List<int>();
            List<int> lista2Numeros = new List<int>();
            List<string> listaPalavras = new List<string>();

            Util.PopularAleatorioNumeros(listaNumeros, 10, 100, 500);
            Util.ExibirListaNumeros(listaNumeros);

            lista2Numeros.AddRange(listaNumeros);

            Util.PopularAleatorioPalavras(listaPalavras, 10, 6);
            Util.ExibirListaPalavras(listaPalavras);
        }
    }
}
