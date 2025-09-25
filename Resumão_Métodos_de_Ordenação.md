# Resumão - Métodos de Ordenação 

## O que é ordenação?
  Ordenação é o processo de reorganizar os elementos de uma estrutura de dados (como vetores ou listas) segundo uma ordem específica, normalmente crescente ou decrescente.

  Categorias de Ordenação:

    Memória interna → dados cabem na memória RAM. (ex.: BubbleSort, QuickSort, MergeSort).
    Memória externa → dados são muito grandes e precisam de 
                      acesso em disco. (ex.: BucketSort, RadixSort, MergeSort adaptado).
  
  Papel na Ciência da Computação:
  
    Facilita a pesquisa de elementos (busca binária, índices).
    Otimiza processamento e manipulação de dados.
    É fundamental em sistemas de banco de dados, algoritmos e 
    aplicações práticas, como relatórios, classificação de usuários ou registros.

## Como se calcula ou mede a complexidade em algoritmos de ordenação?
  A complexidade mede o esforço computacional de um algoritmo em termos de:
    
    Comparações (quantas vezes os elementos são comparados).
    Trocas (quantas vezes os elementos são movidos ou substituídos).
    Tempo de execução (prático, em benchmarks).
    
  Ela é expressa usando a notação Big O:

    O(1) → constante
    O(logn) → logarítmica
    O(n) → linear
    O(n²) → quadrática
    O(n^x), 𝑂(𝑛!) → polinomial/fatorial


    Complexidade dos métodos estudados:
    Bolha: O(n²)
    Seleção: O(n²)
    Inserção: O(n²)
    Agitação: O(n²)
    Pente (Comb): O(n²)
    Shell: O(n log² n)

  Papel da complexidade e pesquisa:
  
    Avaliar eficiência do algoritmo
    Permitir comparação entre métodos
    Prever tempo de execução e consumo de recursos

## Algoritmos Estáveis e Instáveis
  ### Estável
  Mantém a ordem relativa de elementos iguais.
  Métodos estáveis:

    - Bolha
    - Inserção
    - Shake
    - Merge

  ### Instável
  A ordem relativa dos elementos iguais pode mudar durante a ordenação.
  Métodos instáveis:

    - Seleção
    - Shell
    - Pente 
    - Quick



## Qual o melhor método?
    Listas pequenas ou quase ordenadas → InsertionSort.
    Listas grandes e desordenadas → QuickSort ou MergeSort.
    Ordenação estável necessária → MergeSort, BucketSort, RadixSort.
    Pouca memória disponível → HeapSort.

# COMO FUNCIONA CADA MÉTODO?
## BOLHA - Bubble Sort
Como funciona: Trabalha com o conceito de trocas, ou seja, enquanto houver trocas, o algoritmo não para.
É considerado bolha, porque 'leva' os maiores para o final da estrutura

Complexidade: O(n²) no pior caso.

Estabilidade: ✅ Estável (não troca iguais de posição).

Memória: Interna (só usa o próprio vetor).

<img width="371" height="495" alt="image" src="https://github.com/user-attachments/assets/69436544-147e-4797-bca3-ba7fa9e5acc1" />

## SELEÇÃO - Selection Sort
Como funciona: em cada passo, seleciona o menor (ou maior) elemento e coloca na posição correta, trocando.
- Passa o menor valor para a 1º posição, o segundo menor para a 2ª posição e assim sucessivamente.

Complexidade: O(n²), independente da ordem inicial.

Estabilidade: ❌ Instável (pode trocar iguais).

Memória: Interna.

<img width="380" height="473" alt="image" src="https://github.com/user-attachments/assets/c74e86da-9d88-4fba-a99f-03222854d841" />

## INSERÇÃO - Insertion Sort
Como funciona: constrói o vetor ordenado à esquerda, inserindo cada novo elemento na posição correta.
Ele vai selecionando, comparando, ordenando e atribuindo ao grupo da esquerda

Complexidade: O(n²), mas eficiente em vetores quase ordenados.

Estabilidade: ✅ Estável.

Memória: Interna.

Observação: se a estrutura estiver ordenada ou quase, o inserção terá excelente desempenho

<img width="375" height="441" alt="image" src="https://github.com/user-attachments/assets/9eb0ceb4-f4ab-418d-9242-cc9a5181fd96" />

## AGITAÇÃO - Shake Sort ou Cocktail
Como funciona: variação do bolha, mas a cada passada percorre o vetor nos dois sentidos 
(da esquerda para direita e depois da direita para esquerda), "sacudindo" os elementos.

Complexidade: O(n²).

Estabilidade: ✅ Estável.

Memória: Interna.

### Exemplo:
Indices:

0 1 2 3 4 5 6 

7  1  4  2  3  9  8          -> elementos

🔹 Passada 1 (esquerda ➝ direita, ini=0 até fim=6)

(7,1) → troca → [1, 7, 4, 2, 3, 9, 8]

(7,4) → troca → [1, 4, 7, 2, 3, 9, 8]

(7,2) → troca → [1, 4, 2, 7, 3, 9, 8]

(7,3) → troca → [1, 4, 2, 3, 7, 9, 8]

(7,9) → ok

(9,8) → troca → [1, 4, 2, 3, 7, 8, 9]

👉 Agora o 9 está na última posição (fim=6 garantido).
Novo limite: fim = 5.

🔹 Passada 2 (direita ➝ esquerda, fim=5 até ini=0)

(8,7) → ok

(7,3) → ok

(3,2) → ok

(2,4) → troca → [1, 2, 4, 3, 7, 8, 9]

(2,1) → ok

👉 Agora o 1 está garantido no início (ini=0).
Novo limite: ini = 1.

🔹 Passada 3 (esquerda ➝ direita, ini=1 até fim=5)

(2,4) → ok

(4,3) → troca → [1, 2, 3, 4, 7, 8, 9]

(4,7) → ok

(7,8) → ok

👉 O maior da parte não ordenada já está no fim=5.
Novo limite: fim = 4.

🔹 Passada 4 (direita ➝ esquerda, fim=4 até ini=1)

(4,3) → ok

(3,2) → ok

(2,1) → ok

Nenhuma troca → já está ordenado.
O algoritmo termina aqui. ✅

## PENTE - Comb Sort
Como funciona: variação do bolha. Usa um "gap" inicial maior e vai diminuindo (geralmente divide por 1,3) até chegar em 1. 
A ideia é eliminar "tartarugas" (elementos pequenos no final que demoram a subir no bolha).

Complexidade: pior caso O(n²), mas em média mais rápido que bolha.

Estabilidade: ❌ Instável.

Memória: Interna.

<img width="832" height="494" alt="image" src="https://github.com/user-attachments/assets/db69c343-0e0c-49bd-b2d8-d6a4c1e95847" />

## SHELL SORT
Como funciona: generalização do inserção. Ordena elementos distantes, diminuindo o “gap” até virar 1 (aí sim, funciona como inserção).

Complexidade: depende da sequência de gaps; pior caso O(n²), mas em média muito melhor.

Estabilidade: ❌ Instável.

Memória: Interna.

<img width="1149" height="398" alt="image" src="https://github.com/user-attachments/assets/c62b73ac-7884-41fd-9a95-c8ee2a5dd989" />

## QUICK SORT
Como funciona: escolhe um pivô, divide o vetor em dois (menores que o pivô e maiores que o pivô) e aplica o processo recursivamente.

Complexidade: O(n log n) no melhor caso, mas O(n²) no pior (se o pivô for mal escolhido).

Estabilidade: ❌ Instável (a não ser que implementado de forma específica).

Memória: Interna (usa pilha da recursão).

<img width="1137" height="630" alt="image" src="https://github.com/user-attachments/assets/7bce9167-3e7d-4981-a60c-b0b094821f42" />

Aqui ele se divide:
<img width="463" height="88" alt="image" src="https://github.com/user-attachments/assets/b5ca4ca3-b266-47d4-bb78-f614c715063f" />
<img width="634" height="499" alt="image" src="https://github.com/user-attachments/assets/c4293c18-8d4b-4d75-94a3-8872454e2f15" />

No final:

<img width="691" height="195" alt="image" src="https://github.com/user-attachments/assets/4d64fece-f6a8-4c33-ad7a-dce88e7a55c4" />

## HEAP SORT
Como funciona: O Heapsort é um algoritmo de ordenação baseado na estrutura de dados heap, que é uma árvore binária completa onde cada nó obedece a uma das duas propriedades: max-heap ou min-heap.

    Max-Heap: A raiz de cada subárvore é sempre o maior elemento (o maior valor está no topo da árvore).

    Min-Heap: A raiz de cada subárvore é sempre o menor elemento.
No caso do Heapsort, utilizamos max-heap para ordenar os elementos em ordem crescente.

Passos:
Construção do Max-Heap: O primeiro passo do Heapsort é reorganizar a lista de entrada para garantir que ela se torne um max-heap. Isso é feito usando a operação heapify.

Ordenação: A partir do max-heap construído, o maior elemento (que está na raiz) é movido para o final da lista. Após essa troca, o tamanho do heap é reduzido em 1, e o heap é reorganizado (heapify) para manter a propriedade de max-heap. Este processo é repetido até que todos os elementos estejam ordenados.

Complexidade: Melhor/Pior caso: O(n log n), O tempo é 𝑂 ( 𝑛 log ⁡ 𝑛 ) porque a construção do heap leva 𝑂 ( 𝑛 ), mas a operação de extração e reinserção de elementos (heapify) ocorre 𝑛 n vezes e cada operação de heapify tem um custo de 𝑂 ( log ⁡ 𝑛 ).

Estabilidade: ❌ Instável

Memória: é considerado in-place, ou seja, ele utiliza apenas a memória necessária para armazenar os dados de entrada e uma quantidade constante de memória adicional para variáveis temporárias, como índices e variáveis auxiliares. Isso significa que ele não utiliza memória externa.

<img width="963" height="681" alt="{9E88EAAB-100B-4A18-92B9-B6EC9D97980E}" src="https://github.com/user-attachments/assets/d3773223-7f64-4a4b-b226-f5a289b956d7" />
<img width="947" height="617" alt="{A1EF738A-336D-4798-AE22-53F23F032386}" src="https://github.com/user-attachments/assets/69f7274b-dfd5-4ec3-bbb7-4bb72799d090" />
<img width="860" height="588" alt="{F560A1E9-A378-44F2-AC7A-A773A96CF6CC}" src="https://github.com/user-attachments/assets/7d6c2db7-6639-4e20-b10f-4f7877c08298" />
<img width="874" height="636" alt="{0AB3DD7A-615B-4ED4-A51B-1D6AE61D5DC8}" src="https://github.com/user-attachments/assets/0ea356cf-f775-4045-a9d6-8ba5cd869205" />
<img width="912" height="621" alt="{F89C26C2-5CB3-46AC-85C0-157D8027B88B}" src="https://github.com/user-attachments/assets/f4ac3f1b-1cda-474c-bdfd-70f3d9fb5ad2" />












