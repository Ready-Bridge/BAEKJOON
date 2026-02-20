import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= a - 1; i++) {
            list.add(i);
        }

        int max = Math.max(a, b);

        list.add(max);

        for(int i = 1; i < b; i++) {
            list.add(b - i);
        }

        if(a == 1) {
          while(list.size() < N) {
              list.add(1, 1);
          }
        } else {
            while(list.size() < N) {
                list.add(0, 1);
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}