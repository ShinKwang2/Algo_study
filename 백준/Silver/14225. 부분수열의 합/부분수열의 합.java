import java.util.*;

public class Main {

    static int[] arr;
    static int N;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        int LIMIT = 0;
        for (int i = 0; i < N; i++) {
            LIMIT += arr[i];
        }
        LIMIT += 1;

        comb(0, 0);
        for (int i = 1; i <= LIMIT; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static void comb(int idx, int sum) {
        if (idx == N){
            set.add(sum);
            return;
        }

        // 현재 위치 뽑을 때
        comb(idx + 1, sum + arr[idx]);
        // 안뽑을 때
        comb(idx + 1, sum);
    }
}
