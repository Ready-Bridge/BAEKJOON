import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 입력 받기

        int [] A = new int [N]; // 배열 A
        int [] B = new int [N]; // 배열 B

        // int 배열로 변환 (정렬 까지) - 오름 차순
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(A);

        // int 배열로 변환 (정렬 까지) - 내림 차순
        B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        
        // 하나는 오름차순, 하나는 내림차순으로 정렬하고 곱하면 가장 작음
        for(int i = 0; i < N; i ++) {
            result += (A[i] * B[i]);
        }

        System.out.println(result);



    }
}