import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int A = kb.nextInt();
        int B = kb.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = K;
        }

        int separate = N / A;
        int days = 0;
        int turn = 0;
        outer:
        while (true) {
            days++;
            for (int i = 0; i < A; i++) {
                arr[turn + i] += B;
            }
            turn = (turn + A) % N;

            // 모든 화분이 1씩 감소
            for (int i = 0; i < N; i++) {
                arr[i]--;
            }

            // 수분이 0이 된 화분이 있으면 캣닢이 죽었으므로 반복문 끝
            for (int i = 0; i < N; i++) {
                if (arr[i] == 0) break outer;
            }
        }
        System.out.println(days);
    }
}
