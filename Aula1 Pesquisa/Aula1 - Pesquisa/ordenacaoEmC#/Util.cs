using System;
using System.Collections.Generic;
using System.Text;

namespace ordenacaoEmC_
{
    internal class Util
    {
        /// <summary>
        /// Popula uma lista de inteiros com valores aleatórios dentro de um intervalo.
        /// </summary>
        public static void PopularAleatorioNumeros(List<int> lista, long quantidade, int inicio, int fim)
        {
            Random gerador = new Random();
            for (int i = 0; i < quantidade; i++)
            {
                lista.Add(gerador.Next(inicio, fim + 1));
            }
        }

        /// <summary>
        /// Exibe uma lista de números inteiros.
        /// </summary>
        public static void ExibirListaNumeros(List<int> lista)
        {
            foreach (int item in lista)
            {
                Console.WriteLine(item);
            }
        }

        /// <summary>
        /// Gera e adiciona palavras aleatórias em uma lista.
        /// </summary>
        public static void PopularAleatorioPalavras(List<string> lista, long quantidade, int tamanho)
        {
            string letras = "abcdefghijklmnopqrstuvwxyz";
            Random gerador = new Random();

            for (int q = 0; q < quantidade; q++)
            {
                StringBuilder palavra = new StringBuilder();

                for (int i = 0; i < tamanho; i++)
                {
                    char letraSorteada = letras[gerador.Next(letras.Length)];
                    palavra.Append(letraSorteada);
                }

                lista.Add(palavra.ToString());
            }
        }

        /// <summary>
        /// Exibe uma lista de palavras.
        /// </summary>
        public static void ExibirListaPalavras(List<string> lista)
        {
            foreach (string item in lista)
            {
                Console.WriteLine(item);
            }
        }
    }
}
