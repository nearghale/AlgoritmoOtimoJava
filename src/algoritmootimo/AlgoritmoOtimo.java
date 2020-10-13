package algoritmootimo;

import java.util.ArrayList;

public class AlgoritmoOtimo {

    static int[] vetorPrincipal = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
    static int[] vetorSecundario = new int[3];
    static int quadrosPagina = 3;

    public static void main(String[] args) {

        for (int i = 0; i < vetorSecundario.length; i++) {
            System.out.print("[ ");
            vetorSecundario[i] = vetorPrincipal[i];

            for (int j = 0; j < vetorSecundario.length; j++) {
                System.out.printf("%s ", vetorSecundario[j]);
            }

            System.out.printf("]%n");
        }


        for (int i = 3; i < vetorPrincipal.length; i++) {

            alocarMemoria(i, vetorPrincipal[i]);

        }

        System.out.printf("total memórias alocadas %d %n", quadrosPagina);

    }

    static void alocarMemoria(int posicao, int num) {

        if (!(vetorSecundario[0] == num || vetorSecundario[1] == num || vetorSecundario[2] == num)) {
            int pos = comparar(posicao, vetorSecundario[0], vetorSecundario[1], vetorSecundario[2]);

            vetorSecundario[pos] = num;
            quadrosPagina++;

            System.out.print("[ ");
            for (int j = 0; j < vetorSecundario.length; j++) {
                System.out.printf("%s ", vetorSecundario[j]);
            }
            System.out.println("]");

        }

    }

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
