from util import Util as u

#Listas:
lista_numeros = []
lista2_numeros = []
lista_palavras = []

#populando com números randoms:
u.popular_Aleatorio_Numeros(lista_numeros, 10, 100, 500)
print("--- Números aleatórios ---")
u.exibir_Lista(lista_numeros)

# Copia para outra lista
lista2_numeros.extend(lista_numeros)

# Popula com palavras aleatórias
u.popular_Aleatorio_Palavras(lista_palavras, 10, 6)
print("\n--- Palavras aleatórias ---")
u.exibir_Lista(lista_palavras)

# Popula números a partir de arquivo
lista_numeros_arquivo = []
u.popular_Numeros_de_Arquivo(lista_numeros_arquivo, "numeros.txt")
print("\n--- Números do arquivo ---")
u.exibir_Lista(lista_numeros_arquivo)

# Popula palavras a partir de arquivo
lista_palavras_arquivo = []
u.popular_Palavras_de_Arquivo(lista_palavras_arquivo, "palavras.txt")
print("\n--- Palavras do arquivo ---")
u.exibir_Lista(lista_palavras_arquivo)