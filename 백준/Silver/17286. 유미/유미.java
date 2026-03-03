import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] rows = new int[4];
    static int[] cols = new int[4];
    static boolean[] visited = new boolean[4];
    static int[] arr = new int[4];

    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            rows[i] = kb.nextInt();
            cols[i] = kb.nextInt();
        }

        permutation(1);
        System.out.println((int)Math.floor(min));
    }

    static void permutation(int idx) {
        if (idx >= 4) { // 기저조건
            double sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += getDist(arr[i], arr[i + 1]);
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (visited[i]) continue;

            arr[idx] = i;
            visited[i] = true;
            permutation(idx + 1);
            visited[i] = false;
        }
    }

    static double getDist(int idxA, int idxB) {
        int dr = rows[idxA] - rows[idxB];
        int dc = cols[idxA] - cols[idxB];
        return Math.sqrt(dr * dr + dc * dc);
    }
}

