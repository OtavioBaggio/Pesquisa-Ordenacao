from util import Util
from ordenacao import Ordenacao as ord
import time
 
lista_bolha = []
lista_normal = []
lista_selecao = []
lista_insercao = []
Util.popular_lista_aleatoria(lista_bolha, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_normal, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_selecao, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_insercao, 10000, 100, 20000)

#sort
tempoInicio = time.time()
lista_normal.sort()
tempoFim = time.time()
print("Tempo da rotina ordenar por sort nativo: ", (tempoFim - tempoInicio) , "s")        

#Bolha: 
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.bolha(lista_bolha)
tempoFim = time.time()
print("Tempo da rotina ordenar por bolha: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas)  

#Selecao:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.selecao(lista_selecao)
tempoFim = time.time()
print("Tempo da rotina ordenar por selecao: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas)  

#Insercao:
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = ord.insercao(lista_insercao)
tempoFim = time.time()
print("Tempo da rotina ordenar por insercao: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas)
