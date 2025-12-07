import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());


        list.sort((e1, e2) -> {

            int cmp = Integer.compare(e2.getValue(), e1.getValue());
            if (cmp != 0) return cmp;

            cmp = Integer.compare(
                    e2.getKey().length(),
                    e1.getKey().length()
            );

            if (cmp != 0) return cmp;

            return e1.getKey().compareTo(e2.getKey());
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append('\n');
        }
        
        System.out.println(sb);
    }
}