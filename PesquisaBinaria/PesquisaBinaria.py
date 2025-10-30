#    Método de Pesquisa binária
 
def pesquisa_binaria(lista, alvo):
    esquerda = 0
    direita = len(lista) - 1

    while esquerda <= direita:
        meio = (esquerda + direita) // 2

        if lista[meio] == alvo:
            return meio  # Retorna o indice que encontrou
        elif lista[meio] < alvo:
            esquerda = meio + 1     # Busca pela direita
        else:
            direita = esquerda - 1  # Busca pela esquerda

    return -1  # Não encontrou

# Indice:  0  1  2  3   4   5   6
numeros = [5, 6, 8, 10, 14, 80, 95]
resultado = pesquisa_binaria(numeros, 10)

print(f"Tamanho da lista: {len(numeros)}")
print(f"Encontrado no índice: {resultado}")