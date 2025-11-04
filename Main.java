import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("введите количество вершин: ");
        int n = scanner.nextInt();

        int[][] G = new int[n][n];
        int[] deg = new int[n];
        int[] loop = new int[n];


        for (int i = 0; i < n; i++) {
            deg[i] = 0;
            loop[i] = 0;
        }

        Random rand = new Random();
        int size = 0;


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                G[i][j] = G[j][i] = rand.nextInt(2);
                size += G[i][j];
            }
        }

        System.out.println("Матрица G (" + n + "x" + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d ", G[i][j]);
            }
            System.out.println();
        }

        System.out.println("Размер: " + size);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    loop[i] = G[i][j];
                } else {
                    deg[i] += G[i][j];
                }
            }
            deg[i] += 2 * loop[i];
        }
        for(int i = 0; i < n; i++) {
            System.out.println("Вершина " + i + " " + "степень вершины: " + deg[i]);
        }

        int k1 = 0;
        int k2 = 0;
        int k3 = 0;


        for (int i = 0; i < n; i++) {
            if ((deg[i] == 0 && loop[i] == 0) || (deg[i] == 2 && loop[i] == 1)) {
                System.out.println("Вершина " + i + " изолированная");
                k1++;
            }
            if (deg[i] == 1) {
                System.out.println("Вершина " + i + " концевая");
                k2++;
            }
            if ((deg[i] - 2 * loop[i]) == n - 1) {
                System.out.println("Вершина " + i + " доминирующая");
                k3++;
            }
        }

        System.out.println("     Изолированных вершин: " + k1);
        System.out.println("     Концевых вершин: " + k2);
        System.out.println("     Доминирующих вершин: " + k3);

        scanner.close();
    }
}
