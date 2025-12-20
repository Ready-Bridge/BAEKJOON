import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(c, 1);

        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        answer = Math.max(map.size(), answer);

        for(int i = k; i < N + k; i++) {
            map.put(arr[i % N], map.getOrDefault(arr[i % N], 0) + 1);

            int remove = arr[(i - k) % N];
            map.put(remove, map.get(remove) - 1);

            if(map.get(remove) == 0) {
                map.remove(remove);
            }

            answer = Math.max(map.size(), answer);

        }

        System.out.println(answer);

    }
}