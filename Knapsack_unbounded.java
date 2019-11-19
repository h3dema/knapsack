/*
    Dado um peso W da mochila e um conjunto de n itens com certo valor v e peso w,
    queremos calcular a quantidade de itens que podem ser colocados na mochila até o peso máximo.
    Contudo temos permissão para usar um número ilimitado de instâncias de um item.
 */
import java.util.Arrays;

class Knapsack_unbounded {

    /** abordagem bottom-up
    * começamos pelo caso base: zero itens com zero valor
    * e começamos a encher a mochila
    */
    public static int calcula(int capacidade, int[] pesos, int[] valores) {
        int n = pesos.length;
        int[] k = new int[capacidade+1];
        Arrays.fill(k, 0); // inicia array com zero, condição inicial

        for(int w = 0; w <= capacidade; w++) {
            for(int i = 0; i < n; i++) {
              // ainda dá para tentar inserir o item na mochila
              if (pesos[i] <= w)
                // 2 condições: ainda tem espaço ou tentamos retirar um item
                k[w] = Math.max(k[w], k[w-pesos[i]] + valores[i]);
            }
        }
        // imprime a matriz de cálculo
        for(int w = 0; w <= capacidade; w++)
          System.out.printf("%3d ", w);
        System.out.printf(" << Capacidade\n");
        for(int w = 0; w <= capacidade; w++)
            System.out.printf("%3d ", k[w]);
        System.out.printf("\n");

        return k[capacidade];
    }

    public static void main(String[] args) {
        /*
            Neste exemplo temos quatro tipos de unidades para inserir.
            Podemos repetir cada tipo o tanto de vezes que desejarmos.

            A capacidade da mochila é de 50.
         */

        int[] valores = {60, 100, 110, 120};
        int[] pesos   = {10, 20, 20, 30};
        int capacidade = 50;
        System.out.printf("Valor máximo conseguido na mochila = %d\n", calcula(capacidade, pesos, valores));
        /*
      Com isto conseguimos um total de peso de 50 (capacidade da mochila) com um valor de 300, que é conseguido
      colocando na mochila os cinco vezes o primeiro item.
      Se tentarmos colocar qualquer outro item, temos que retirar dois ou três do primeiro item, perdendo 120 ou 180 de valor
      e conseguindo colocar no lugar 100, 110 ou 120.

      Veja a saída do programa:

  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50  << Capacidade
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 120 120 120 120 120 120 120 120 120 120 180 180 180 180 180 180 180 180 180 180 240 240 240 240 240 240 240 240 240 240 300
Valor máximo conseguido na mochila = 300


         */
    }
}