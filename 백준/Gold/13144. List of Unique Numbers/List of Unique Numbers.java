import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;

        int left = 0;
        int right = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        boolean flag = false;

        while(left < N) {

            int now = map.getOrDefault(arr[right], 0);

            if(now == 0) {

                map.put(arr[right], 1);

                if(right < N - 1) {
                    flag = false;
                    right++;
                } else {
                    flag = true;
                }

            } else {

                if(flag) {
                    cnt += (right - left + 1);
                } else {
                    cnt += (right - left);
                }
                map.remove(arr[left]);
                left++;
            }
        }

        System.out.println(cnt);

    }
}