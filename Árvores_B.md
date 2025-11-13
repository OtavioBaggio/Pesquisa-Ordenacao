# Árvore B - Estrutura de Dados

## O que são Árvores B?

As **árvores B** são uma estrutura de dados balanceada que permite armazenamento eficiente de grandes volumes de dados. Elas são especialmente usadas em sistemas de arquivos e bancos de dados devido à sua alta performance em operações de busca, inserção e remoção.

## Propriedades de uma Árvore B

1. **Balanceamento**: A árvore é balanceada, ou seja, todas as folhas estão no mesmo nível, garantindo que as operações de busca e manipulação sejam eficientes.
2. **Nós Internos**: Cada nó pode conter múltiplas chaves e ponteiros para os filhos, ao invés de ter apenas uma chave como nas árvores binárias.
3. **Ordem da Árvore**: A ordem **m** de uma árvore B é o número máximo de filhos que um nó pode ter. Cada nó pode armazenar até **m - 1** chaves.

### Exemplo de Estrutura de um Nó:

Um nó de uma árvore B pode ser representado assim:

<img width="218" height="195" alt="{6E8EAF08-1B53-4835-8540-FA757D5994BD}" src="https://github.com/user-attachments/assets/8d8ab619-c621-46a6-906f-afa8153f4aa2" />



### Operações

1. **Busca**: A operação de busca começa pela raiz e, conforme a chave procurada, seguimos para os filhos apropriados até encontrar a chave ou determinar que ela não existe.
   
2. **Inserção**: Quando um nó se enche (atinge **m-1** chaves), ele é dividido, e a chave central é promovida ao nó pai. Isso mantém a árvore balanceada.

3. **Remoção**: Remover uma chave pode exigir a fusão de nós ou redistribuição de chaves entre os nós, para garantir o balanceamento da árvore.

## Exemplo de Inserção

Vamos usar uma árvore B de ordem 3 (m = 3) para ilustrar como as inserções ocorrem.

1. **Árvore Inicial**:
   
   A árvore começa vazia.

2. **Inserir 10**:

3. **Inserir 20**:

4. **Inserir 5**:
   
5. **Inserir 30** (Agora o nó precisa ser dividido):

A árvore resultante é:

<img width="156" height="97" alt="{D9B34E03-6B99-4C16-8CC3-CF3342B380A7}" src="https://github.com/user-attachments/assets/fb062abd-123e-409e-b429-b3da4a2c09c2" />


Isso mantém a árvore balanceada.

## Exercício resolvido no B-Tree Visualization:

<img width="562" height="303" alt="{EB8F2565-1D06-46A5-8A6A-ECB824C82B5C}" src="https://github.com/user-attachments/assets/a2c8a3b1-9d12-4b91-a5a1-8540630791fb" />








