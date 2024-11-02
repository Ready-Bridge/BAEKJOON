import java.io.*;
import java.util.*;

public class Main {

    static int n, k, ans;
    static ArrayList<Integer> arrList;
    static ArrayList<Integer> compareList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arrList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrList);

        // 인접한 요소들 간의 차이를 계산해 compareList에 저장
        compareList = new ArrayList<>();
        for (int i = 0; i < arrList.size() - 1; i++) {
            compareList.add(arrList.get(i + 1) - arrList.get(i));
        }

        // k가 n보다 크거나 같으면 차이 계산 없이 0을 출력
        if (k >= n) {
            System.out.println(0);
            return;
        }

        // k-1개의 가장 큰 차이를 제거
        for (int i = 0; i < k - 1 && !compareList.isEmpty(); i++) {
            int max = Collections.max(compareList); // 가장 큰 차이값 찾기
            compareList.remove(Integer.valueOf(max)); // 가장 큰 차이값 제거
        }

        // 나머지 차이값을 모두 더하여 출력
        ans = 0;
        for (int diff : compareList) {
            ans += diff;
        }

        System.out.println(ans);
    }
}
