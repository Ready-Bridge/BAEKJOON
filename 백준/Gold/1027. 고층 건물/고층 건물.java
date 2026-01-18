import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int answer = 0;

    static void checkView(int pos) {
        int count = 0;

        // 왼쪽 탐색
        double minSlope = Double.MAX_VALUE; // 왼쪽은 기울기가 계속 작아져야 보임
        for (int i = pos - 1; i >= 0; i--) {
            double slope = (double) (arr[pos] - arr[i]) / (pos - i);
            
            // 첫 번째 바로 옆 건물은 무조건 보임
            // 그 이후 건물은 이전 최소 기울기보다 더 작아야(내려가야) 보임
            if (i == pos - 1 || slope < minSlope) {
                count++;
                minSlope = slope;
            }
        }

        // 오른쪽 탐색
        double maxSlope = -Double.MAX_VALUE; // 오른쪽은 기울기가 계속 커져야 보임
        for (int i = pos + 1; i < arr.length; i++) {
            double slope = (double) (arr[i] - arr[pos]) / (i - pos);
            
            // 첫 번째 바로 옆 건물은 무조건 보임
            // 그 이후 건물은 이전 최대 기울기보다 더 커야(올라가야) 보임
            if (i == pos + 1 || slope > maxSlope) {
                count++;
                maxSlope = slope;
            }
        }

        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = br.readLine();
        if (line1 == null) return;
        int N = Integer.parseInt(line1);
        
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            checkView(i);
        }

        System.out.println(answer);
    }
}