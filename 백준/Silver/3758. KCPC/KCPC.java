import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            HashMap<Integer, int[]> map = new HashMap<>();
            int[] cnt = new int[n + 1]; // 제출 횟수
            int[] submit = new int[n + 1]; // 제출 시간

            // Map 초기화
            for(int index = 1; index <= n; index++) {
                map.put(index, new int[k + 1]);
            }

            int time = 0; // 제출 시간

            for(int idx = 0; idx < m; idx++) {
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken()); // 팀 ID
                int j = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득한 점수

                int[] arr = map.get(i);

                arr[j] = Math.max(arr[j], s); // 해당 팀의 해당 문제 점수 갱신
                cnt[i]++; // 해당 팀의 풀이 제출 횟수 증가
                submit[i] = ++time; // 해당 팀의 제출 시간 기록
            }

            int[] result = new int[n + 1];

            for(Map.Entry<Integer, int[]> entry : map.entrySet()) {

                int sum = 0;

                for(int score : entry.getValue()) {
                    sum += score;
                }

                result[entry.getKey()] = sum;
            }

            int answer = 0;
            int myScore = result[t];
            int myCnt = cnt[t];
            int mySubmit = submit[t];

            for(int index = 1; index <= n; index++) {
                if(index == t) continue;

                if(result[index] > myScore) {
                    answer++;
                } else if(result[index] == myScore) {

                    if(cnt[index] < myCnt) {
                        answer++;
                    } else if(cnt[index] == myCnt) {

                        if(submit[index] < mySubmit) {
                            answer++;
                        }
                    }

                }

            }

            System.out.println(answer + 1);

        }
    }
}