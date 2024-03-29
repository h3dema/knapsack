# Knapsack (ou o problema da mochila)


O problema da mochila é um problema na otimização combinatória.
Isto é o programa recebe um conjunto de itens, cada um com um peso e um valor.
O programa deve determinar os itens a serem incluídos em uma coleção (a mochila) para que o peso total seja menor ou igual a um determinado limite e o valor total seja o maior possível.

Seu nome deriva do problema enfrentado por alguém que é limitado por uma mochila de tamanho fixo e deve preenchê-la com os itens mais valiosos.

Existem diversas variações deste problema. Aqui veremos algumas delas.


* Knapsack_conjunto.java

Este programa executa o problema da mochila sobre um conjunto de itens.
O programa irá pegar cada item listado (sem repetição) e tentará achar o subconjunto deles que enche a mochila e possui o maior valor
Este é o problema clássico, algumas vezes chamado de 0-1 knapsack, pois você só pode ter 0 ou 1 unidades de cada item.

O problema é definido como:

![](Knapsack_conjunto.png)


* Knapsack_unbounded.java

Este programa executa o problema da mochila sobre um conjunto de itens, a diferença é que neste caso os itens podem ser repetidos.

O problema é definido como:

![](Knapsack_unbounded.png)



* Knapsack_bounded.java

Este programa executa o problema da mochila sobre um conjunto de itens, a diferença é que neste caso os itens podem ser repetidos,
contudo existe um limite para a quantidade de cada item.

O problema é definido como:

![](Knapsack_bounded.png)



# Compilar


Para compilar todas as classes neste repositorio, somente rode:

```
make
```

Você pode, então, chamar cada classe individualmente com:

```
java Knapsack_conjunto
```