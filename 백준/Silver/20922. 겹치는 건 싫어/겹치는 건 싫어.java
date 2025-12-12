import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int answer = 0;
        int ptr = 0;

        while(end < N) {

            if(map.getOrDefault(arr[ptr], 0) >= K) {
                answer = Math.max(answer, end - start);
                map.put(arr[start], map.get(arr[start]) - 1);
                start++;
                continue;
            }

            map.put(arr[ptr], map.getOrDefault(arr[ptr], 0) + 1);
            ptr++;
            end++;
        }

        System.out.println(Math.max(answer, end - start));

    }
}