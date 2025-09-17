# Busca Heurística: A* e Busca Gulosa  

Este projeto em **Java** implementa e compara dois algoritmos de busca heurística: **A*** e **Busca Gulosa**. A aplicação encontra rotas entre cidades da **Romênia**, utilizando um grafo baseado no mapa de estradas, e permite visualizar o funcionamento dos algoritmos em uma interface gráfica feita em **Java Swing**.  

## Estrutura do Projeto  
- **modelo**  
  - `Cidade.java`: Representa cada cidade (nó) com heurística e conexões.  
  - `CidadeProxima.java`: Representa uma estrada (aresta) com seu custo.  

- **visao**  
  - `TelaPrincipal.java`: Contém a interface gráfica e a lógica dos algoritmos.  

## Algoritmos Implementados  
- **Busca Gulosa (Greedy Best-First Search)**  
  Escolhe sempre o próximo nó com menor distância heurística até Bucareste.  

- **Busca A* (A-Star)**  
  Utiliza a função `f(n) = g(n) + h(n)`, equilibrando o custo já percorrido (`g`) e a estimativa de distância restante (`h`).  

## Mapa de Cidades  
Para a execução dos algoritmos, foi utilizado um mapa de cidades da Romênia. A imagem abaixo ilustra as conexões entre as cidades e as distâncias (custos) de cada trecho. A tabela à direita apresenta os valores da heurística (h(n)) para cada cidade, que correspondem à distância em linha reta até Bucareste.

![Mapa das Cidades](./mapa.jpg)  
