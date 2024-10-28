import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [] arr;
    static int ans = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int [n];

        // 배열에 입력값 저장
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 내림차순 정렬
        arr = Arrays.stream(arr)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();

        // 앞에서 부터 (큰 변의 길이 부터) 3개씩 체크해보면서 탐색
        // 삼각형 조건은 가장 큰 변의 길이보다 나머지 두 길이의 합이 크면됨
        // (내림차순이기 때문에 앞에서 부터 탐색하면 정답임을 보장)
        for(int i = 0; i < n - 2; i++) {
                if(arr[i] < arr[i + 1] + arr[i + 2]) {
                    ans = arr[i] + arr[i + 1] + arr[i + 2];
                    break;
                }
            }

        System.out.println(ans);
    }
}