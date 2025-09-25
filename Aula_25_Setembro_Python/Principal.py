from util import Util
from Ordenacao import Ordenacao as ord
import time
 
lista_bolha = []
lista_normal = []
lista_selecao = []
lista_insercao = []
lista_agitacao = []
lista_pente = []
lista_shell = []
lista_quick = []
lista_heap = []

Util.popular_lista_aleatoria(lista_bolha, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_normal, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_selecao, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_insercao, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_agitacao, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_pente, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_shell, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_quick, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_heap, 10000, 100, 20000)

#sort:
tempoInicio = time.time()
lista_normal.sort()
tempoFim = time.time()
print("Tempo da rotina ordenar por sort nativo: ", (tempoFim - tempoInicio) , "s", '\n')        

#Bolha: 
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.bolha(lista_bolha)
tempoFim = time.time()
print("Tempo da rotina ordenar por bolha: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')  

#Selecao:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.selecao(lista_selecao)
tempoFim = time.time()
print("Tempo da rotina ordenar por selecao: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')  

#Insercao:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.insercao(lista_insercao)
tempoFim = time.time()
print("Tempo da rotina ordenar por insercao: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')

#Agitacao:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.agitacao(lista_agitacao)
tempoFim = time.time()
print("Tempo da rotina ordenar por Agitacao: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')

# Pente:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.pente(lista_pente)
tempoFim = time.time()
print("Tempo da rotina ordenar por Pente (Comb Sort): ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')

#Shell:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.shell(lista_shell)
tempoFim = time.time()
print("Tempo da rotina ordenar por Shellsort: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')

#Quicksort:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.quicksort(lista_quick, 0, len(lista_quick) - 1)
tempoFim = time.time()
print("Tempo da rotina ordenar por Quicksort: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')

#Heapsort:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.heapsort(lista_heap)
tempoFim = time.time()
print("Tempo da rotina ordenar por Heapsort: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas, '\n')
