================================================================================
                    RESUMÃO - PESQUISA EM ESTRUTURAS DE DADOS
================================================================================

================================================================================
1. O QUE É PESQUISA?
================================================================================

PESQUISAR = Localizar algo de forma simples e direta através de um endereço

DOIS PROCESSOS DISTINTOS:
  • Pesquisar/Buscar (indexOf) - localizar elemento específico
  • Recuperar (Retrieve) - busca significativa em grandes volumes
    → Usa INDEXAÇÃO (índices que apontam conteúdos)
    → Etiquetação + Tabela Hash

ANALOGIA: FAT (File Allocation Table) em pendrives


================================================================================
2. LOCALIZAR vs RECUPERAR
================================================================================

LOCALIZAR                    |  RECUPERAR
-----------------------------|----------------------------------
Busca simples e direta       |  Busca significativa
Pequenos volumes             |  Grandes volumes
indexOf, search              |  Sistemas de indexação
Acesso direto                |  Usa índices e estruturas auxiliares


================================================================================
3. COMPLEXIDADE DAS PESQUISAS
================================================================================

TIPO           | COMPLEXIDADE | REQUISITO          | QUANDO USAR
---------------|--------------|--------------------|--------------------------
SEQUENCIAL     | O(n)         | Nenhum             | Dados desordenados
BINÁRIA        | O(log n)     | DADOS ORDENADOS!   | Dados ordenados
DIGITAL        | O(n)         | Estrutura especial | Strings, prefixos
HASH           | O(1)         | Função hash        | Acesso direto por chave

⚠️ REGRAS DE OURO:
  • SE ESTÁ ORDENADO → Binária ou Sequencial
  • SE ESTÁ DESORDENADO → Apenas Sequencial (ou Hash)


================================================================================
4. FLUXO: ARMAZENAR → "ORDENAR" → PESQUISAR
================================================================================

1. ARMAZENAR os dados
2. ORDENAR (APENAS SE FOR USAR BINÁRIA!)
3. PESQUISAR com algoritmo apropriado

⚠️ IMPORTANTE:
  • PRECISO ORDENAR SOMENTE PARA BINÁRIA
  • TABELA HASH NÃO ORDENA e não precisa ordenação


================================================================================
5. ALGORITMO: PESQUISA BINÁRIA
================================================================================

PRÉ-REQUISITO: Dados OBRIGATORIAMENTE ORDENADOS

ALGORITMO:
  1. início = 0, fim = tamanho - 1
  2. Enquanto início ≤ fim:
     a. meio = (início + fim) / 2
     b. Se array[meio] == valor → ENCONTROU!
     c. Se array[meio] < valor → início = meio + 1
     d. Se array[meio] > valor → fim = meio - 1
  3. Se não encontrou → NÃO EXISTE

COMPLEXIDADE: O(log n)
FILOSOFIA: Dividir para Conquistar (elimina metade a cada iteração)

EXEMPLO: Buscar 7 em [1, 3, 5, 7, 9, 11, 13]
  • Passo 1: meio = 7 (posição 3) → ENCONTROU! ✓


================================================================================
6. ALGORITMO: PESQUISA DIGITAL (TRIE)
================================================================================

CONCEITO: Pesquisa caractere por caractere

CARACTERÍSTICAS:
  • Cada nó = um caractere
  • Caminho da raiz até nó = palavra/chave
  • Útil para: autocompletar, dicionários, roteamento

COMPLEXIDADE: O(m) onde m = tamanho da chave

ESTRUTURA VISUAL:
         raiz
        /  |  \
       c   d   t
      /    |    \
     a     o     o
    /      |      \
   t      g       p
 (cat)  (dog)  (top)


================================================================================
6.1 IMPLEMENTAÇÃO: PESQUISA BINÁRIA (PYTHON)
================================================================================

```python
def pesquisa_binaria(lista, alvo):
    esquerda = 0
    direita = len(lista) - 1

    while esquerda <= direita:
        meio = (esquerda + direita) // 2

        if lista[meio] == alvo:
            return meio  # Retorna o índice que encontrou
        elif lista[meio] < alvo:
            esquerda = meio + 1     # Busca pela direita
        else:
            direita = meio - 1      # Busca pela esquerda

    return -1  # Não encontrou

# Exemplo de uso:
# Índice:  0  1  2  3   4   5   6
numeros = [5, 6, 8, 10, 14, 80, 95]
resultado = pesquisa_binaria(numeros, 10)

print(f"Tamanho da lista: {len(numeros)}")
print(f"Encontrado no índice: {resultado}")
```

SAÍDA ESPERADA:
  Tamanho da lista: 7
  Encontrado no índice: 3

OBSERVAÇÕES IMPORTANTES:
  • Lista DEVE estar ordenada
  • Usa // (divisão inteira) para calcular meio
  • Retorna -1 se não encontrar
  • Retorna o ÍNDICE se encontrar


================================================================================
7. TEORIA: TABELAS HASH
================================================================================

DEFINIÇÃO:
  Tabela Hash = Lista de tamanho n onde cada posição é uma lista de dados

FÓRMULA:
  Chave → Função Hash → Endereço → Valor

ESTRUTURA:
  • Elemento com CHAVE
  • FUNÇÃO HASH calcula ENDEREÇO
  • POSIÇÃO na tabela armazena VALOR


--------------------------------------------------------------------------------
7.1 FUNÇÃO HASH DE ENDEREÇAMENTO
--------------------------------------------------------------------------------

OBJETIVO: Transformar chave em índice válido da tabela

EXEMPLO SIMPLES:
  hash(chave) = chave % tamanho_tabela

EXEMPLO PRÁTICO:
  Tabela tamanho 10
  Chave 25 → 25 % 10 = 5 → posição 5
  Chave 35 → 35 % 10 = 5 → COLISÃO!

BOA FUNÇÃO HASH:
  ✓ Distribui uniformemente
  ✓ Rápida de calcular
  ✓ Minimiza colisões


--------------------------------------------------------------------------------
7.2 TRATAMENTO DE COLISÕES
--------------------------------------------------------------------------------

Quando duas chaves → mesmo endereço:

1. ENCADEAMENTO (Chaining): Cada posição = lista ligada
2. ENDEREÇAMENTO ABERTO: Procura próxima posição livre


--------------------------------------------------------------------------------
7.3 VANTAGENS E DESVANTAGENS
--------------------------------------------------------------------------------

VANTAGENS:
  ✅ NÃO precisa ordenar
  ✅ Acesso O(1) caso médio
  ✅ Inserção/remoção eficientes

DESVANTAGENS:
  ❌ Pode ter colisões
  ❌ Ocupa mais memória


================================================================================
7.4 IMPLEMENTAÇÃO: TABELA HASH COM ALUNOS (JAVA)
================================================================================

```java
import java.util.HashSet;
import java.util.Scanner;

class Aluno {
    int matricula;
    String nome;
    
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Aluno{" + "matricula = " + matricula + 
               ", nome = " + nome + '}';
    }
    
    // FUNÇÃO HASH - Calcula endereço baseado na matrícula
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.matricula;
        return hash;
    }
    
    // Verifica se dois alunos são iguais (mesma matrícula)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Aluno other = (Aluno) obj;
        return this.matricula == other.matricula;
    }
}

public class HashExemplo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // HashSet = Tabela Hash do Java
        HashSet<Aluno> tabela = new HashSet<>();
        String nome;
        int matricula;
        
        Aluno aluno;
        for(int i = 0; i < 5; i++) {
            System.out.println("Nome: ");
            nome = sc.nextLine();
            System.out.println("Matricula: ");
            matricula = sc.nextInt();
            sc.nextLine();
            
            aluno = new Aluno(matricula, nome);
            
            // Calcula o endereço hash
            int endereco = aluno.hashCode();
            
            System.out.println("Aluno: " + aluno + 
                             ". Endereco: " + endereco);
            
            // Tenta adicionar - se já existe, avisa
            if(!tabela.add(aluno)) {
                System.out.println("Aluno ja inserido: " + 
                                  aluno + " Endereco: " + endereco);
            }
            sc.nextLine();
        }
        
        System.out.println("Mostrando a tabela...");
        for(Aluno item : tabela) {
            System.out.println(item);
        }
    }
}
```

COMPONENTES IMPORTANTES:

1. FUNÇÃO HASH (hashCode):
   hash = 97 * hash + matricula
   → Transforma matrícula em endereço

2. MÉTODO EQUALS:
   → Compara se dois alunos são iguais (mesma matrícula)
   → Evita duplicatas

3. HashSet<Aluno>:
   → Estrutura de tabela hash do Java
   → add() retorna false se elemento já existe

4. FLUXO:
   Matrícula → hashCode() → Endereço → Posição na tabela

EXEMPLO DE EXECUÇÃO:
  Input: matricula = 12345, nome = "João"
  hashCode() calcula: 97 * 7 + 12345 = 13024
  Aluno armazenado no endereço 13024

OBSERVAÇÕES:
  • Matrícula = CHAVE única
  • HashSet impede duplicatas automaticamente
  • hashCode() = função hash personalizada
  • Complexidade O(1) para inserção e busca


================================================================================
8. AS 3 PRINCIPAIS ESTRUTURAS DE DADOS
================================================================================

--------------------------------------------------------------------------------
8.1 ARRAY (VETOR/LISTA)
--------------------------------------------------------------------------------
CONCEITO: Estrutura sequencial contígua, elementos indexados

VANTAGENS:
  ✅ Acesso direto O(1)
  ✅ Simples
  ✅ Eficiente em memória

USAR QUANDO: Tamanho conhecido, acesso rápido por posição


--------------------------------------------------------------------------------
8.2 LISTA LIGADA (LINKED LIST)
--------------------------------------------------------------------------------
CONCEITO: Estrutura dinâmica, cada nó aponta para o próximo

VANTAGENS:
  ✅ Tamanho dinâmico
  ✅ Inserção/remoção O(1) com referência
  ✅ Não precisa memória contígua

USAR QUANDO: Muitas inserções/remoções, tamanho imprevisível


--------------------------------------------------------------------------------
8.3 ÁRVORE (TREE)
--------------------------------------------------------------------------------
CONCEITO: Estrutura hierárquica com raiz e filhos

VANTAGENS:
  ✅ Busca O(log n) se balanceada
  ✅ Dados hierárquicos
  ✅ Mantém ordenação

USAR QUANDO: Dados hierárquicos, busca eficiente


================================================================================
9. RESUMO COMPARATIVO
================================================================================

ASPECTO              | SEQUENCIAL  | BINÁRIA      | HASH
---------------------|-------------|--------------|-------------
Ordenação necessária?| Não         | SIM!         | Não
Complexidade         | O(n)        | O(log n)     | O(1)
Melhor uso           | Pequeno vol.| Ordenados    | Acesso chave
Estrutura            | Array/Lista | Array ord.   | Tabela+Função


================================================================================
10. EXEMPLO PRÁTICO: BUSCA BINÁRIA DO 24
================================================================================

LISTA: [10, 15, 20, 24, 25, 30, 35, 40, 45]
ÍNDICE: 0   1   2   3   4   5   6   7   8

ITERAÇÃO 1:
  início=0, fim=8, meio=4
  array[4]=25 > 24 → buscar esquerda
  Comparação 1 ✓

ITERAÇÃO 2:
  início=0, fim=3, meio=1
  array[1]=15 < 24 → buscar direita
  Comparação 2 ✓

ITERAÇÃO 3:
  início=2, fim=3, meio=2
  array[2]=20 < 24 → buscar direita
  Comparação 3 ✓

ITERAÇÃO 4:
  início=3, fim=3, meio=3
  array[3]=24 == 24 → ENCONTRADO!
  Comparação 4 ✓

RESPOSTA: 4 COMPARAÇÕES
CAMINHO: posições 4 → 1 → 2 → 3


================================================================================
11. DICAS PARA A PROVA
================================================================================

✅ MEMORIZE:
  • Binária PRECISA ordenação
  • Hash NÃO precisa ordenação
  • Sequencial funciona sempre
  • Complexidades: O(n), O(log n), O(1)

✅ SAIBA IMPLEMENTAR:
  • Algoritmo binária (dividir ao meio)
  • Conceito pesquisa digital (árvore caracteres)

✅ ENTENDA:
  • Tabela hash = chave + função hash + endereço
  • Função hash transforma chave em índice
  • Colisões precisam tratamento

✅ FÓRMULAS IMPORTANTES:
  • meio = (início + fim) / 2
  • hash(chave) = chave % tamanho_tabela

✅ REGRA DE OURO:
  ORDENADO? → Binária ou Sequencial
  DESORDENADO? → Sequencial ou Hash


================================================================================
                            FIM DO RESUMÃO
                         BOA SORTE NA PROVA! 🚀
================================================================================