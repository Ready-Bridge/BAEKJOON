import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int [][] arr;

    static void calculate(int day, int sum) {

        // 모든 일 수 다 돌았을 때
        if(day > N) {

            if(max < sum) {
                max = sum;
            }
            return;

        }

        if(day + arr[day][0] <= N + 1) {

            calculate(day + arr[day][0], sum + arr[day][1]); // 그 다음 일이 가능한 시점이면 이동

        }


        calculate(day + 1, sum); // 지금 일 안했으면 바로 다음날로 이동

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        calculate(1, 0);

        System.out.println(max);
    }
}