# Busca Heurística: A* e Busca Gulosa  

Este projeto implementa os algoritmos de **Busca Gulosa** e **Busca A*** no clássico **mapa da Romênia**.  

## Descrição  
- As cidades são representadas como nós de um grafo.  
- As estradas entre as cidades são as arestas com seus respectivos custos.  
- A heurística utilizada é a **distância em linha reta até Bucareste**, fornecida em tabela.  

## Funcionalidades  
- O usuário escolhe a **cidade de origem** e o **algoritmo de busca** (Gulosa ou A*).  
- O programa retorna o **caminho completo** da cidade inicial até Bucareste.  
- As cidades e distâncias são inseridas manualmente no código.  

## Algoritmos  
- **Busca Gulosa**: utiliza apenas a heurística (menor distância em linha reta até Bucareste) para escolher o próximo nó.  
- **Busca A\***: combina o custo real do caminho percorrido com a heurística para encontrar a rota ótima.  

## Mapa da Romênia  
As heurísticas foram baseadas nas distâncias em linha reta até Bucareste.  

![Mapa das Cidades](/Mapa.png)  
