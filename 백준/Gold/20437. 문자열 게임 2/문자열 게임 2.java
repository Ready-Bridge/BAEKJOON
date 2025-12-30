import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String text = br.readLine();
            int K = Integer.parseInt(br.readLine());
            
            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            // 알파벳(a-z) 별로 등장하는 인덱스를 저장할 리스트 배열
            List<Integer>[] alpha = new ArrayList[26];
            for(int i = 0; i < 26; i++) {
                alpha[i] = new ArrayList<>();
            }

            // 문자열을 순회하며 인덱스 저장
            for(int i = 0; i < text.length(); i++) {
                alpha[text.charAt(i) - 'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            // 각 알파벳 별로 저장된 인덱스를 확인
            for(int i = 0; i < 26; i++) {
                List<Integer> list = alpha[i];

                // 해당 알파벳이 K개보다 적게 등장했으면 계산할 필요 없음
                if(list.size() < K) continue;

                // K개 간격의 인덱스 차이를 계산
                // list: [1, 5, 10, 20], K=3 이라면
                // (1, 10), (5, 20) 이렇게 비교
                for(int j = 0; j <= list.size() - K; j++) {
                    int start = list.get(j);
                    int end = list.get(j + K - 1);

                    int length = end - start + 1;

                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }

            if(min == Integer.MAX_VALUE || max == -1) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}