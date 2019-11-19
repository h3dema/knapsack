/*
    Dado um peso W da mochila e um conjunto de n itens com certo valor v e peso w,
    queremos calcular a quantidade de itens que podem ser colocados na mochila até o peso máximo.
    Contudo temos permissão para usar um número __limitado__ de instâncias de um item.
 */
import java.util.Arrays;
import java.util.stream.IntStream;


class Knapsack_bounded {

    /** abordagem bottom-up
    * começamos pelo caso base: zero itens com zero valor
    * e começamos a encher a mochila
    */
    public static int calcula_0_1(int capacidade, int[] pesos, int[] valores) {
        /* este procedimento é igual a Knapsack_conjunto.java */
        int n = pesos.length;
        int[][] k = new int[n+1][capacidade+1];
        for(int i = 0; i <= n; i++) {
          for(int w = 0; w <= capacidade; w++) {
            if ((i == 0) || (w == 0)) // condição inicial
              k[i][w] = 0; // nada na mochila
            else
              // ainda dá para tentar inserir o item na mochila
              if (pesos[i-1] <= w)
                // 2 condições: ainda tem espaço ou tentamos retirar um item
                k[i][w] = Math.max(valores[i-1] + k[i-1][w-pesos[i-1]], k[i-1][w]);
              else
                // mochila já está cheia
                k[i][w] = k[i-1][w];
          }
        }
        // imprime a matriz de cálculo
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

    /*
       Usamos um pequeno truque aqui.
       Primeiro recriamos a entrada de tal forma que ela fique compatível com o Knapsack 0_1
       isto é, armazenamos todos os dados em novos arrays criando as repetições indicadas em qtd.
       Então simplismente chamamos procedimento já feito para Knapsack_conjunto.java que chamamos aqui de
       calcula_0_1()
    */
    public static int calcula(int capacidade, int[] pesos, int[] valores, int[] qtd) {
        int n = IntStream.of(qtd).sum();
        int new_pesos[], new_valores[];
        new_pesos = new int[n];
        new_valores = new int[n];

        int j = 0;
        for(int i = 0; i < pesos.length; i++) {
            for(int q = 0; q < qtd[i]; q++) {
                new_pesos[j] = pesos[i];
                new_valores[j] = valores[i];
                j += 1;
            }
        }
        return calcula_0_1(capacidade, new_pesos, new_valores);
    }

    public static void main(String[] args) {
        /*
            Neste exemplo temos quatro tipos de unidades para inserir.
            Podemos repetir cada tipo do item "i" até a quantidade definida em qtd[i].

            A capacidade da mochila é de 50.
         */

        int[] valores = {60, 100, 110, 120};
        int[] pesos   = {10, 20, 20, 30};
        int[] qtd     = {2, 1, 1, 1};
        int capacidade = 50;
        System.out.printf("Valor máximo conseguido na mochila = %d\n", calcula(capacidade, pesos, valores, qtd));
        /*

        Neste caso limitamos a quantidade de cada item.
        O resultado final foi 270 = 1 item de peso 10 e cada um dos dois itens de peso 20 ==> 60 + 100 + 110 = 270

  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50  << Capacidade
  0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  <<   0
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  <<   1
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120 120  <<   2
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 120 120 120 120 120 120 120 120 120 120 160 160 160 160 160 160 160 160 160 160 220 220 220 220 220 220 220 220 220 220 220  <<   3
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 120 120 120 120 120 120 120 120 120 120 170 170 170 170 170 170 170 170 170 170 230 230 230 230 230 230 230 230 230 230 270  <<   4
  0   0   0   0   0   0   0   0   0   0  60  60  60  60  60  60  60  60  60  60 120 120 120 120 120 120 120 120 120 120 170 170 170 170 170 170 170 170 170 170 230 230 230 230 230 230 230 230 230 230 270  <<   5
Valor máximo conseguido na mochila = 270

         */
    }
}