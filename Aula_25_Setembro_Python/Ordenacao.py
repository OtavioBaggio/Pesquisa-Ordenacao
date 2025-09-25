class Ordenacao:
    @staticmethod
    def bolha(lista):
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0
        while (houve_troca):    
            houve_troca = False
            for i in range (len(lista) - 1):
                qtd_comparacoes+=1
                if (lista[i] > lista[i+1]):
                    qtd_trocas+=1
                    houve_troca = True
                    tmp = lista[i]
                    lista[i] = lista[i+1]
                    lista[i+1] = tmp
                    
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def selecao(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(len(lista) - 1):
            posMenor = i
            for j in range(i+1, len(lista)):
                qtd_comparacoes+=1
                if (lista[j] < lista[posMenor]):
                    posMenor = j
            if (i != posMenor):
                qtd_trocas+=1
                tmp = lista[i]
                lista[i] = lista[posMenor]
                lista[posMenor] = tmp
        return qtd_comparacoes, qtd_trocas
    
    @staticmethod
    def insercao(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(1, len(lista)):
            tmp = lista[i]
            j = i - 1
            while j >= 0 and lista[j] > tmp:
                qtd_comparacoes += 1
                lista[j+1] = lista[j]
                qtd_trocas +=1
                j -= 1
            if j >= 0:
                qtd_comparacoes +=1
            lista[j+1] = tmp
        return qtd_comparacoes, qtd_trocas
    
    @staticmethod
    def agitacao(lista):
        houve_troca = True
        ini = 0
        fim = len(lista) - 1
        qtd_comparacoes = 0
        qtd_trocas = 0

        while houve_troca:
            houve_troca = False
            # Percorre da esquerda para a direita
            for i in range(ini, fim):
                qtd_comparacoes += 1
                if lista[i] > lista[i + 1]:
                    qtd_trocas += 1
                    houve_troca = True
                    tmp = lista[i]
                    lista[i] = lista[i + 1]
                    lista[i + 1] = tmp

            if not houve_troca:
                break

            fim -= 1

            houve_troca = False
            # Percorre da direita para a esquerda
            for i in range(fim, ini, -1):
                qtd_comparacoes += 1
                if lista[i] < lista[i - 1]:
                    qtd_trocas += 1
                    houve_troca = True
                    tmp = lista[i]
                    lista[i] = lista[i - 1]
                    lista[i - 1] = tmp

            ini += 1

        return qtd_comparacoes, qtd_trocas
    
    @staticmethod
    def pente(lista):
        distancia = len(lista)
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0

        while(houve_troca or distancia > 1):
            distancia = int(distancia / 1.3)
            if distancia < 1:
                distancia = 1
            houve_troca = False
            for i in range(len(lista) - distancia):
                qtd_comparacoes += 1
                if lista[i] > lista[i + distancia]:
                    lista[i], lista[i + distancia] = lista[i + distancia], lista[i]
                    qtd_trocas += 1
                    houve_troca = True
                    
        return qtd_comparacoes, houve_troca  
    
    @staticmethod
    def shell(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        distancia = 1
        referencia_tamanho = 3
        n = len(lista)

        # Calcula a distância inicial usando a sequência de incrementos de Knuth
        while distancia < n // referencia_tamanho:
            distancia = referencia_tamanho * distancia + 1

        while distancia > 0:
            for i in range(distancia, n):
                tmp = lista[i]
                j = i - distancia
                while j >= 0:
                    qtd_comparacoes += 1
                    if tmp < lista[j]:
                        lista[j + distancia] = lista[j]
                        qtd_trocas += 1
                        j -= distancia
                    else:
                        break
                lista[j + distancia] = tmp
                qtd_trocas += 1
            distancia = distancia // referencia_tamanho

        return [qtd_comparacoes, qtd_trocas]


    
    @staticmethod
    def particiona(lista, ini, fim):
        pivo = lista[ini]  # escolhe o primeiro elemento como pivô
        i = ini + 1
        j = fim
        qtd_comparacoes = 0
        qtd_trocas = 0

        while i <= j:
            # anda da esquerda para a direita até achar alguém maior que o pivô
            while i <= fim and lista[i] <= pivo:
                qtd_comparacoes += 1
                i += 1

            # anda da direita para a esquerda até achar alguém menor que o pivô
            while j > ini and lista[j] > pivo:
                qtd_comparacoes += 1
                j -= 1

            if i < j:
                qtd_trocas += 1
                lista[i], lista[j] = lista[j], lista[i]

        # coloca o pivô na posição correta
        qtd_trocas += 1
        lista[ini], lista[j] = lista[j], lista[ini]

        return j, qtd_comparacoes, qtd_trocas

    @staticmethod
    def quicksort(lista, ini, fim, qtd_comparacoes=0, qtd_trocas=0):
        if ini < fim:
            pivo, sub_comparacoes, sub_trocas = Ordenacao.particiona(lista, ini, fim)
            qtd_comparacoes += sub_comparacoes
            qtd_trocas += sub_trocas
            # Recursão para as duas partes
            qtd_comparacoes, qtd_trocas = Ordenacao.quicksort(lista, ini, pivo - 1, qtd_comparacoes, qtd_trocas)
            qtd_comparacoes, qtd_trocas = Ordenacao.quicksort(lista, pivo + 1, fim, qtd_comparacoes, qtd_trocas)
        
        return qtd_comparacoes, qtd_trocas
    

    @staticmethod
    def heapify(lista, n, i):
        """
        Método que reorganiza a lista para garantir a propriedade de max-heap
        """
        maior = i  # Inicializa o maior como raiz
        esquerda = 2 * i + 1  # Esquerda = 2*i + 1
        direita = 2 * i + 2  # Direita = 2*i + 2

        # Se o filho esquerdo é maior que a raiz
        if esquerda < n and lista[esquerda] > lista[maior]:
            maior = esquerda

        # Se o filho direito é maior que o maior até agora
        if direita < n and lista[direita] > lista[maior]:
            maior = direita

        # Se o maior não é a raiz, troque-os
        if maior != i:
            lista[i], lista[maior] = lista[maior], lista[i]  # Troca
            Ordenacao.heapify(lista, n, maior)  # Recursão para garantir max-heap em todas as subárvores

    @staticmethod
    def heapsort(lista):
        n = len(lista)
        qtd_comparacoes = 0
        qtd_trocas = 0

        # Construção do max-heap
        for i in range(n // 2 - 1, -1, -1):
            Ordenacao.heapify(lista, n, i)
            qtd_comparacoes += 1  # Contabiliza a comparação em heapify (não é exata, mas aproxima)
        
        # Extração dos elementos do heap um por um
        for i in range(n-1, 0, -1):
            lista[i], lista[0] = lista[0], lista[i]  # Troca
            qtd_trocas += 1
            Ordenacao.heapify(lista, i, 0)  # Reorganiza o heap

        return qtd_comparacoes, qtd_trocas
