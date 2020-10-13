package algoritmootimo;

import java.util.ArrayList;

public class AlgoritmoOtimo {

    /* 
        A primeira Parte do código consiste na criação de 2 vetores, e de um contador que irá contar 
        a quantidade de alocações de página, o primeiro vetor contém os dados a serem alocados, e o 
        segundo o vetor que representará as 3 posições de memória para alocação dos dados do vetor principal. 
        Quando um vetor é criado em Java com um tipo primitivo, como um vetor de inteiro por exemplo, as posições são guardadas com o valor 0. 
        O contador guarda o número 3 em sua inicialização, pois como não tem nenhum dado na memória, então o 
        algoritmo não precisa verificar por meio de uma comparação, se existe já um dado na memória quando 
        um novo dado precisar ser alocado, portando os 3 primeiros dados, já são alocados direto sem nenhuma verificação.
     */
    static int[] vetorPrincipal = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
    static int[] vetorSecundario = new int[3];
    static int quadrosPagina = 3;

    //Essa é o método main, onde é o primeiro método que o sistema procurará executar quando inicializado
    public static void main(String[] args) {

        /* Laço de repetição for, que faz as 3 primeiras alocações de memória,
           e já exibe o resultado na tela */
        for (int i = 0; i < vetorSecundario.length; i++) {
            System.out.print("[ ");
            vetorSecundario[i] = vetorPrincipal[i];

            for (int j = 0; j < vetorSecundario.length; j++) {
                System.out.printf("%s ", vetorSecundario[j]);
            }

            System.out.printf("]%n");
        }

        /* Laço de repetição for, que chama o método para alocação de memória*/
        for (int i = 3; i < vetorPrincipal.length; i++) {

            alocarMemoria(i, vetorPrincipal[i]);

        }

        //instrução para exibição da quantidade de Page Hint
        System.out.printf("total Page Hints alocadas %d %n", quadrosPagina);

    }

    //Método que recebe a posição da memória para ser alocada e o dado
    static void alocarMemoria(int posicao, int num) {

        //estrutura de seleção que verifica se NÃO existe o mesmo dado na memória para alocar
        if (!(vetorSecundario[0] == num || vetorSecundario[1] == num || vetorSecundario[2] == num)) {

            //variável que recebe a posição que deve alocar o novo dado
            int pos = comparar(posicao, vetorSecundario[0], vetorSecundario[1], vetorSecundario[2]);

            vetorSecundario[pos] = num;
            quadrosPagina++;

            //exibição de o estado atual da memória
            System.out.print("[ ");
            for (int j = 0; j < vetorSecundario.length; j++) {
                System.out.printf("%s ", vetorSecundario[j]);
            }
            System.out.println("]");

        }

    }

    //método que compara qual o dado da posição de memória que irá demorar a ser utilizada, e fazendo a substituição desse dado para o novo dado
    static int comparar(int posicao, int num, int num2, int num3) {

        int contadorA = 0;
        int contadorB = 0;
        int contadorC = 0;

        for (int i = posicao; i < vetorPrincipal.length; i++) {

            contadorA++;
            if (num == vetorPrincipal[i]) {
                break;
            }
        }

        for (int i = posicao; i < vetorPrincipal.length; i++) {

            contadorB++;
            if (num2 == vetorPrincipal[i]) {
                break;
            }
        }

        for (int i = posicao; i < vetorPrincipal.length; i++) {

            contadorC++;
            if (num3 == vetorPrincipal[i]) {
                break;
            }
        }

        if (contadorA > contadorB) {
            if (contadorA >= contadorC) {
                return 0;
            }
        }
        if (contadorB > contadorA) {
            if (contadorB >= contadorC) {
                return 1;
            }
        }
        if (contadorC > contadorA) {
            if (contadorC >= contadorB) {
                return 2;
            }
        }

        return -1;

    }

}
