import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] rights;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int B = kb.nextInt();

        rights = new boolean[N];
        Arrays.fill(rights, true);
        for (int i = 0; i < B; i++) {
            int idx = kb.nextInt() - 1;
            rights[idx] = false;
        }
//        System.out.println(Arrays.toString(rights));

        int start = 0;
        int end = K;

        int fixCount = 0;
        for (int i = start; i < end; i++) {
            if (!rights[i]) fixCount++;
        }
//        System.out.println("start: " + start + " end: " + end + " fixCount: " + fixCount);
        min = fixCount;
        start++;
        end++;

        while (end <= N) {
            if (!rights[start - 1]) {
                fixCount--;
            }
            if (!rights[end - 1]) {
                fixCount++;
            }
            min = Math.min(min, fixCount);
//            System.out.println("start: " + start + " end: " + end + " fixCount: " + fixCount);
            start++;
            end++;
        }
        System.out.println(min);
    }
}
