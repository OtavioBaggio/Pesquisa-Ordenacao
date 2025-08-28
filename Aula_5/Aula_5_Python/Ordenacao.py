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