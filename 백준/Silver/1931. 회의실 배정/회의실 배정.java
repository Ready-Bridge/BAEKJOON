import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }


        // 끝나는 시간을 기준으로 정렬
        Arrays.sort(time, (arr0, arr1) -> {
            if(arr0[1] == arr1[1]) {
                return arr0[0] - arr1[0];
            }
            return arr0[1] - arr1[1];
        });

        int count = 0;
        int temp = 0;

        for(int i = 0; i < N; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(temp <= time[i][0]) {
                temp = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}