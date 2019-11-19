/**
 * O problema da mochila classico pode ser apresentado como:
 * Dado os pesos e os valores de n itens, colocar esses itens em uma mochila de capacidade W para obter o valor máximo
 * total na mochila.
 *
 * Em outras palavras, dados dois conjuntos de números inteiros valor[] e pesos[], ambos com elementos entre 0 e n-1.
 * valores[] representa os valores e pesos[] representa os pesos associados aos n itens respectivamente.
 * A capacidade da mochila é dada por um inteiro W.
 * Precisamos descobrir o subconjunto máximo de valores[],
 * tal que a soma dos pesos deste subconjunto é menor ou igual a W.
 * Um item não pode ser quebrado (fracionado), isto é, ou o item é escolhido ou não.
 *
 *
 * solução simples:
 * ===============
 * Considerar todos os subconjuntos de itens e calcular o peso total e valor de todos os subconjuntos.
 * Avaliamos os subconjuntos cujo peso total é menor do que W.
 * E deste subconjunto, escolhemos o subconjunto de valor máximo.
 * --> muito lento O(2^n)
 *
 * recorrencia:
 * o valor máximo que pode ser obtido a partir de n itens é um máximo de dois valores:
 *
 * caso 1) O valor máximo é obtido pela soma dos valores dos "n-1" itens e que totalizam o peso W
 *         (excluindo n-ésimo produto).
 *
 * caso 2) O valor máximo é obtido pelo valor do item "n" somado com os valor que pode ser obtido com
 *         "n-1" itens W e menos peso do item n
           (incluindo o n-ésimo produto)
 *
 * Note que se o peso do item "n" é maior que W, o item de ordem "n" não pode ser inserido e
 * portanto a solução parcial é dada pelo caso 1
 */


class Knapsack_conjunto {

  /** abordagem bottom-up
    * come�amos pelo caso base: zero itens com zero valor
    * e come�amos a encher a mochila
    */
  public static int calcula(int capacidade, int[] pesos, int[] valores) {
    int n = pesos.length;
    int[][] k = new int[n+1][capacidade+1];
    for(int i = 0; i <= n; i++) {
      for(int w = 0; w <= capacidade; w++) {
        if ((i == 0) || (w == 0)) // condi��o inicial
          k[i][w] = 0;
        else
          // ainda d� para tentar inserir o item na mochila
          if (pesos[i-1] <= w)
            // 2 condi��es: ainda tem espa�o ou tentamos retirar um item
            k[i][w] = Math.max(valores[i-1] + k[i-1][w-pesos[i-1]], k[i-1][w]);
          else
            // mochila j� est� cheia
            k[i][w] = k[i-1][w];
      }
    }
    // imprime a matriz de c�lculo
    for(int w = 0; w <= capacidade; w++)
      System.out.printf("%3d ", w);
    System.out.printf(" << Capacidade\n");
    for(int i = 0; i <= n; i++) {
      for(int w = 0; w <= capacidade; w++)
        System.out.printf("%3d ", k[i][w]);
      System.out.printf(" << %3d\n", i);
    }

    return k[n][capacidade];
  }

  public static void main(String[] args) {
    /*
        Neste exemplo temos quatro unidades para inserir.
        * uma de peso 10 e valor 60, duas de peso 20 com valor 100, e a última de peso 30 e valor 120. Neste caso a melhor combinação é deixar o último item de fora.

        A capacidade da mochila é de 50.
     */

    int[] valores = {60, 100, 100, 120};
    int[] pesos   = {10, 20, 20, 30};
    int capacidade = 50;
    System.out.printf("Valor máximo conseguido na mochila = %d\n", calcula(capacidade, pesos, valores));

    /*
      Com isto conseguimos um total de peso de 50 (capacidade da mochila) com um valor de 260, que é conseguido colocando na mochila os trẽs primeiros
      items. Se tentarmos colocar o quarto item, temos que tirar o primeiro e segundo ou o segundo e terceiro, em ambos os casos, estaremos reduzindo
      o valor total na mochila.

      Veja a saída do programa:

  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50  << Capacidade
  0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  <<   0
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  <<   1
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 100 100 100 100 100 100 100 100 100 100 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160  <<   2
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 100 100 100 100 100 100 100 100 100 100 160 160 160 160 160 160 160 160 160 160 200 200 200 200 200 200 200 200 200 200 260  <<   3
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 100 100 100 100 100 100 100 100 100 100 160 160 160 160 160 160 160 160 160 160 200 200 200 200 200 200 200 200 200 200 260  <<   4
Valor máximo conseguido na mochila = 260

     */
  }


}