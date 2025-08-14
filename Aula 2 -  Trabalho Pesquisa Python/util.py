import random

class Util:
    """Classe responsável pelas funções de inserções de listas de palavras e numeros"""

    @staticmethod
    def popular_Aleatorio_Numeros(lista, quantidade, inicio, fim):
        """Popula a lista com números inteiros randoms"""
        for _ in range(quantidade):
            lista.append(random.randrange(inicio, fim))
    
    @staticmethod
    def exibir_Lista(lista):
        """Exibe oque tem na lista"""
        for item in lista:
            print(item)
    
    @staticmethod
    def popular_Aleatorio_Palavras(lista, quantidade, tamanho):
        """Popula a lista com palavras aleatórias"""
        letras = "abcdefghijklmnopqrstuvwxyz "
        for _ in range(quantidade):
            palavra_gerada = "".join(
                letras[random.randrange(len(letras))]
                for _ in range(tamanho)
            )
            lista.append(palavra_gerada)

    @staticmethod
    def popular_Numeros_de_Arquivo(lista, nome_arquivo):
        """Função que le os numeros do arquivo txt e add na lista"""
        try:
            with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
                for linha in arquivo:
                    for valor in linha.split():
                        if valor.isdigit():
                            lista.append(int(valor))
        except FileExistsError:
            print(f"Arquivo '{nome_arquivo}' não encontrado.")
    
    @staticmethod
    def popular_Palavras_de_Arquivo(lista, nome_arquivo):
        """Le as palavras do arquivo txt e add na lista"""
        try:
            with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
                for linha in arquivo:
                    for palavra in linha.split():
                        lista.append(palavra)
        except FileNotFoundError:
            print(f"Arquivo '{nome_arquivo}' não encontrado.")
