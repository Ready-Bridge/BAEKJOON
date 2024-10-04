import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int [][] arr;
    static int a, b, start;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());


            arr[i][0] = a;
            arr[i][1] = b;
        }

        // 끝내야 하는 시간을 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        start = arr[0][1];

        for(int i = 0; i < N; i++) {

            start = Math.min(start, arr[i][1]) - arr[i][0];

            if(start < 0 ) {
                System.out.println(-1);
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println(start);
        }
    }
}