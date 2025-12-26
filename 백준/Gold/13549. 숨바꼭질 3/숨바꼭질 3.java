import java.io.*;
import java.util.*;

public class Main {

    static boolean isRange(int[] arr, int pos) {
        if(pos < 0 || pos > 100000) {
            return false;
        }

        if(arr[pos] != -1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(k <= n) {
            System.out.println(n - k);
            return;
        }

        int[] arr = new int[100001];
        Arrays.fill(arr, -1);

        Deque<Integer> q = new ArrayDeque<>();

        q.add(n);
        arr[n] = 0;

        while(!q.isEmpty()) {

            int pos = q.poll();

            if(pos == k) {
                break;
            }

            if(isRange(arr, pos * 2)) {
                arr[pos * 2] = arr[pos];
                q.addFirst(pos * 2);
            }

            if(isRange(arr, pos - 1)) {
                arr[pos - 1] = arr[pos] + 1;
                q.addLast(pos - 1);
            }

            if(isRange(arr, pos + 1)) {
                arr[pos + 1] = arr[pos] + 1;
                q.addLast(pos + 1);
            }
        }

        System.out.println(arr[k]);
        
    }
}